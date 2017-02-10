package com.example.monkeyman.rundgangdurchdiealtstadt;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 * Created by David A on 11.01.2017.
 */
public class Details extends FragmentActivity {

    Sehenswuerdigkeit s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        s = null;
        if(params != null){
            s = params.getParcelable("Sehenswuerdigkeit");
        }
        try {
            fillViews(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void fillViews(Sehenswuerdigkeit se) throws IOException {
        TextView titel = (TextView) findViewById(R.id.titel);
        TextView beschreibung = (TextView) findViewById(R.id.beschreibung);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Drawable d;

        if(!se.id.equals("s11")) {
            InputStream ims = getAssets().open(se.id + ".PNG");
            d = Drawable.createFromStream(ims, null);
            image.setImageDrawable(resize(d));
        }

        titel.setText(se.nameDeutsch);
        beschreibung.setText(se.beschreibungDeutsch);
    }
    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 420, 300, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }
}
