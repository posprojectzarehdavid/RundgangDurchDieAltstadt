package com.example.monkeyman.rundgangdurchdiealtstadt;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    CameraPosition camera;
    HashMap<Marker, Sehenswuerdigkeit> markers;
    ArrayList<Sehenswuerdigkeit> sehenswFromCSV;
    GoogleApiClient googleApiClient;
    Location lastLocation;
    SharedPreferences prefs;
    String language = "";
    boolean serviceEnabled;
    boolean allowPermission = false;
    LocationRequest locationRequest;
    private final int UPDATE_INTERVAL = 1000;
    private final int FASTEST_INTERVAL = 1000;

    Intent intent;
    SharedPreferences.OnSharedPreferenceChangeListener listener;

    SehenwuerdigkeitenTexte st = new SehenwuerdigkeitenTexte();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);

        checkPermission();
        askPermission();

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
                preferenceChanged(prefs, s);
            }
        };

        if (prefs.contains("Sprache")) {
            Log.i("syslang", "prefscontains");
            language = prefs.getString("Sprache", "English");
        } else {
            String systemlanguage = Locale.getDefault().getDisplayLanguage();
            Log.i("syslang", systemlanguage);
            SharedPreferences.Editor editor = prefs.edit();
            if (systemlanguage.equals("Deutsch") || systemlanguage.equals("English")
                    || systemlanguage.equals("German") || systemlanguage.equals("Englisch")) {
                Log.i("syslang", "systemlang gesetzt " + systemlanguage);
                editor.putString("Sprache", systemlanguage);
                editor.commit();
                language = prefs.getString("Sprache", systemlanguage);
            } else {
                editor.putString("Sprache", "English");
                Log.i("syslang", "defaultsprache gesetzt");
                editor.commit();
                language = prefs.getString("Sprache", "English");
            }
        }

        if (prefs.contains("Service")) {
            serviceEnabled = prefs.getBoolean("Service", true);
        } else {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("Service", true);
            editor.commit();
            serviceEnabled = true;
        }

        prefs.registerOnSharedPreferenceChangeListener(listener);
        st.InitLists();
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map_fragment);
        markers = new HashMap<>();
        sehenswFromCSV = getValuesFromCSV();

        if (serviceEnabled) {
            createServiceIntent();
            startService(intent);
        }
        locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL);

        mapFragment.getMapAsync(this);
    }

    private void createServiceIntent() {
        intent = new Intent(this, MyService.class);
        intent.putExtra("List", sehenswFromCSV);
        intent.putExtra("Language", language);
    }

    private void preferenceChanged(SharedPreferences prefs, String s) {
        if (s.equals("Sprache")) {
            String val = prefs.getString(s, "");
            language = val;
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            if (val.equals("English")) {
                conf.locale = new Locale("en");
            } else if (val.equals("Deutsch")) {
                conf.locale = new Locale("de");
            }
            Toast.makeText(this, R.string.restart, Toast.LENGTH_LONG).show();

            res.updateConfiguration(conf, dm);

        } else if (s.equals("Service")) {
            boolean service = prefs.getBoolean(s, false);
            serviceEnabled = service;
            if (serviceEnabled) {
                createServiceIntent();
                startService(intent);
            } else {
                stopService(intent);
            }
        }
    }

    protected synchronized void createGoogleApi() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        createGoogleApi();
        googleApiClient.connect();
        Log.i("hallo", "apiclient im on onstart connected");
    }

    @Override
    protected void onResume() {
        super.onResume();
        googleApiClient.connect();
        Log.i("hallo", "apiclient im on resume connected");
    }

    @Override
    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
        Log.i("hallo", "apiclient im on onstop disconnected");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        googleApiClient.disconnect();
        Log.i("hallo", "app destroyed");
        //stopService(intent);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.setMyLocationEnabled(true);
        LatLng schaerding = new LatLng(48.456754, 13.431395);
        camera = CameraPosition.builder().target(schaerding).zoom(16).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        markerSetzen(googleMap);

        googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Sehenswuerdigkeit se = markers.get(marker);
                Intent intent = new Intent(getApplicationContext(), Details.class);
                intent.putExtra("Sehenswuerdigkeit", se);
                intent.putExtra("Sprache", language);
                startActivity(intent);
            }
        });
    }

    private void markerSetzen(GoogleMap googleMap) {
        Marker m;
        for (int i = 0; i < sehenswFromCSV.size(); i++) {
            Sehenswuerdigkeit s = sehenswFromCSV.get(i);
            if (language.equals("Deutsch")) {
                m = googleMap.addMarker(new MarkerOptions().position(s.latLng).title(s.getNameDeutsch()));
            } else {
                m = googleMap.addMarker(new MarkerOptions().position(s.latLng).title(s.getNameEnglisch()));
            }
            markers.put(m, s);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionsmenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(getApplicationContext());
        switch (id) {
            case R.id.optionen:
                startActivity(new Intent(this, PrefsActivity.class));
                return true;
            case R.id.shutdown:
                googleApiClient.disconnect();
                if (serviceEnabled) {
                    stopService(intent);
                }
                System.exit(0);
                /*dlgAlert.setMessage(R.string.message);
                dlgAlert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        googleApiClient.disconnect();
                        stopService(intent);
                        System.exit(0);
                    }
                });
                dlgAlert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();*/
            default:
                return false;
        }
    }

    private ArrayList getValuesFromCSV() {
        String line;
        BufferedReader br;
        ArrayList<Sehenswuerdigkeit> al = new ArrayList();
        try {
            br = new BufferedReader(new InputStreamReader(getResources().getAssets().open("latlng_values.csv")));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                LatLng ll = new LatLng(Double.parseDouble(values[0]), Double.parseDouble(values[1]));
                int radius = Integer.parseInt(values[5]);
                Sehenswuerdigkeit s = new Sehenswuerdigkeit(values[4], values[2], values[3], ll, radius);
                s.setBeschreibungDeutsch(st.deutscheTexte.get(values[4].toLowerCase() + "_d"));
                s.setBeschreibungEnglisch(st.englischeTexte.get(values[4].toLowerCase() + "_e"));
                al.add(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return al;
    }

    @Override
    public void onConnected(Bundle bundle) {
        lastLocation = LocationServices.FusedLocationApi
                .getLastLocation(googleApiClient);
    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }

    private void askPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {

        }
        if(!allowPermission){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        googleApiClient.connect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 100: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, R.string.allow, Toast.LENGTH_LONG).show();
                    allowPermission = true;
                } else {
                    Toast.makeText(this, R.string.deny, Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }
}
