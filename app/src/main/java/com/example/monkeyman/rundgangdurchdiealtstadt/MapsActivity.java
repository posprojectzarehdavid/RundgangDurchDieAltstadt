package com.example.monkeyman.rundgangdurchdiealtstadt;

import android.Manifest;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.media.Image;
import android.os.Build;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.EnvironmentCompat;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import com.google.android.gms.location.LocationListener;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener{

    CameraPosition camera;
    HashMap<Marker, Sehenswuerdigkeit> markers;
    ArrayList<Sehenswuerdigkeit> sehenswFromCSV;
    GoogleApiClient googleApiClient;
    Location lastLocation;
    LocationManager locationManager;

    private LocationRequest locationRequest;
    private final int UPDATE_INTERVAL = 3 * 60 * 1000;
    private final int FASTEST_INTERVAL = 30 * 1000;

    private static final long GEO_DURATION = 60 * 60 * 1000;
    private static final String GEOFENCE_REQ_ID = "My Geofence";
    private static final float GEOFENCE_RADIUS = 10.0f; // in meters

    private PendingIntent geoFencePendingIntent;
    private final int GEOFENCE_REQ_CODE = 0;

    SehenwuerdigkeitenTexte st = new SehenwuerdigkeitenTexte();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        st.InitLists();
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map_fragment);
        markers = new HashMap<>();
        sehenswFromCSV = getValuesFromCSV();
        checkPermission();
        askPermission();
        createLocationManager();
        mapFragment.getMapAsync(this);
        createGoogleApi();
        //startGeofence();
    }

    private void checkLocation() {
        if(lastLocation != null){
            lastLocation.setLatitude(48.457);
            lastLocation.setLongitude(13.4319);
            if(lastLocation.getLongitude() == 13.4319 && lastLocation.getLatitude()==48.457){
                Intent intent = new Intent(this, GeofenceTrasitionService.class);
                startService(intent);
                //startActivity(intent);
            }
        }

    }

    private void createLocationManager() {
        locationManager = (LocationManager) getSystemService(Service.LOCATION_SERVICE);
        Criteria crta = new Criteria();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            crta.setAccuracy(Criteria.ACCURACY_FINE);
        } else {
            crta.setAccuracy(Criteria.ACCURACY_MEDIUM);
        }
        crta.setPowerRequirement(Criteria.POWER_LOW);
    }

    private void startGeofence() {
        for (int i = 0; i < sehenswFromCSV.size(); i++) {
            Geofence geofence = createGeofence(sehenswFromCSV.get(i).getLatLng(), GEOFENCE_RADIUS);
            GeofencingRequest geofenceRequest = createGeofenceRequest(geofence);
            addGeofence(geofenceRequest);
        }
    }

    private Geofence createGeofence(LatLng latLng, float radius) {
        return new Geofence.Builder()
                .setRequestId(GEOFENCE_REQ_ID)
                .setCircularRegion(latLng.latitude, latLng.longitude, radius)
                .setExpirationDuration(GEO_DURATION)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER
                        | Geofence.GEOFENCE_TRANSITION_EXIT)
                .build();
    }

    private GeofencingRequest createGeofenceRequest(Geofence geofence) {
        return new GeofencingRequest.Builder()
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                .addGeofence(geofence)
                .build();
    }

    private PendingIntent createGeofencePendingIntent() {
        if (geoFencePendingIntent != null)
            return geoFencePendingIntent;

        Intent intent = new Intent(this, GeofenceTrasitionService.class);
        return PendingIntent.getService(
                this, GEOFENCE_REQ_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    private void addGeofence(GeofencingRequest request) {
        LocationServices.GeofencingApi.addGeofences(
                googleApiClient,
                request,
                createGeofencePendingIntent()
        ).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(Status status) {
                if (status.isSuccess()) {
                    // 4. If successful, save the geofence

                } else {
                    // 5. If not successful, log and send an error
                    Log.e("Hallo", "Registering geofence failed: " + status.getStatusMessage() +
                            " : " + status.getStatusCode());

                }
            }
        });
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
        if (googleApiClient != null) {
            googleApiClient.connect();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (googleApiClient != null) {
            googleApiClient.disconnect();
        }
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
                startActivity(intent);
            }
        });
        //googleMap.addMarker(new MarkerOptions().position(schaerding).title("Marker in Schärding"));
    }


    private void markerSetzen(GoogleMap googleMap) {
        Circle geoFenceLimits;
        for (int i = 0; i < sehenswFromCSV.size(); i++) {
            Sehenswuerdigkeit s = sehenswFromCSV.get(i);
            Marker m = googleMap.addMarker(new MarkerOptions().position(s.latLng).title(s.getNameDeutsch()));
            CircleOptions circleOptions = new CircleOptions()
                    .center(m.getPosition())
                    .strokeColor(Color.argb(50, 0, 102, 255))
                    .fillColor(Color.argb(100, 0, 204, 255))
                    .radius(GEOFENCE_RADIUS);
            geoFenceLimits = googleMap.addCircle(circleOptions);
            markers.put(m, s);
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
                Sehenswuerdigkeit s = new Sehenswuerdigkeit(values[4], values[2], values[3], ll);
                s.setBeschreibungDeutsch(st.deutscheTexte.get(values[4].toLowerCase()+"_d"));
                s.setBeschreibungEnglisch(st.englischeTexte.get(values[4].toLowerCase()+"_e"));
                if(!values[4].equals("s11")) {
                    InputStream ims = getAssets().open(values[4] + ".PNG");
                    Drawable d = Drawable.createFromStream(ims, null);
                    s.setBild(d);
                }

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
        getLastKnownLocation();
    }

    private void getLastKnownLocation() {
        lastLocation = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        //startLocationUpdates();
        checkLocation();
    }

    private void startLocationUpdates() {
        locationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
                .setInterval(UPDATE_INTERVAL)
                .setFastestInterval(FASTEST_INTERVAL);

        LocationServices.FusedLocationApi
                .requestLocationUpdates(googleApiClient, locationRequest, new com.google.android.gms.location.LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        checkLocation();
                    }
                });
    }

    private boolean checkPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }


    private void askPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){

        }
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},100);
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
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permission granted
                    Toast.makeText(this, R.string.allow, Toast.LENGTH_LONG).show();
                    getLastKnownLocation();
                } else {
                    Toast.makeText(this, "You did not allow to access your current location", Toast.LENGTH_LONG).show();
                    MapsActivity.this.closeContextMenu();
                }
                break;
            }
        }
    }

    @Override
    public void onLocationChanged(Location location) {

    }
}
