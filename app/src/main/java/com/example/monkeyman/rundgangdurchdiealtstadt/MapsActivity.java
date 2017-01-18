package com.example.monkeyman.rundgangdurchdiealtstadt;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    CameraPosition camera;
    HashMap<Marker, Sehenswuerdigkeit> markers;
    ArrayList<Sehenswuerdigkeit> sehenswFromCSV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
        markers = new HashMap<>();
        sehenswFromCSV = new ArrayList<>();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.setMyLocationEnabled(true);
        LatLng schaerding = new LatLng(48.456754, 13.431395);
        camera = CameraPosition.builder().target(schaerding).zoom(16).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
        markerSetzen(googleMap);
        if(googleMap != null){
            googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Sehenswuerdigkeit se = markers.get(marker);
                    Intent intent = new Intent(getApplicationContext(), Details.class);
                    intent.putExtra("Sehenswuerdigkeit", se);
                    startActivity(intent);
                }
            });
        }

        //googleMap.addMarker(new MarkerOptions().position(schaerding).title("Marker in Schärding"));
    }



    private void markerSetzen(GoogleMap googleMap) {
        ArrayList<Sehenswuerdigkeit> values = getValuesFromCSV();
        for (int i = 0; i<values.size(); i++){
            Sehenswuerdigkeit s = values.get(i);
            Marker m = googleMap.addMarker(new MarkerOptions().position(s.latLng).title(s.getNameDeutsch()));
            markers.put(m, s);
        }

    }

    private ArrayList getValuesFromCSV() {
        String line;
        BufferedReader br;
        int id = 1;
        ArrayList<Sehenswuerdigkeit> al = new ArrayList();
        try {
            br = new BufferedReader(new InputStreamReader(getResources().getAssets().open("latlng_values.csv")));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                LatLng ll = new LatLng(Double.parseDouble(values[0]),Double.parseDouble(values[1]));
                Sehenswuerdigkeit s = new Sehenswuerdigkeit(id, values[2], values[3], ll);
                al.add(s);
                id++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return al;
    }
}
