package com.example.monkeyman.rundgangdurchdiealtstadt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;

import org.json.JSONException;

import java.io.Serializable;

/**
 * Created by David A on 11.01.2017.
 */
public class Details extends AppCompatActivity implements Serializable {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Intent intent = getIntent();
        Sehenswuerdigkeit se = (Sehenswuerdigkeit) intent.getSerializableExtra("Sehenswuerdigkeit");
        fillViews(se);
    }
    private void fillViews(Sehenswuerdigkeit se){
        TextView titel = (TextView) findViewById(R.id.titel);
        TextView beschreibung = (TextView) findViewById(R.id.beschreibung);
        ImageView image = (ImageView) findViewById(R.id.imageView);

        titel.setText(se.nameDeutsch);
        beschreibung.setText(se.beschreibungDeutsch);


    }



}
