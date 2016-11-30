package com.example.monkeyman.rundgangdurchdiealtstadt;

import android.app.Activity;
import android.graphics.Camera;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    CameraPosition camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        googleMap.setMyLocationEnabled(true);
        LatLng schaerding = new LatLng(48.456754, 13.431395);
        camera = CameraPosition.builder().target(schaerding).zoom(16).build();

        googleMap.addMarker(new MarkerOptions().position(schaerding).title("Marker in Schärding"));
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camera));
    }
}
