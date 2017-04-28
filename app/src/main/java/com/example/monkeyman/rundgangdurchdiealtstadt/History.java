package com.example.monkeyman.rundgangdurchdiealtstadt;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by David A on 28.04.2017.
 */

public class History extends FragmentActivity {

    String language;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history);
        Intent intent = getIntent();
        language = intent.getSerializableExtra("Sprache").toString();

        TextView titel = (TextView) findViewById(R.id.titel);
        TextView beschreibung = (TextView) findViewById(R.id.beschreibung);
        ImageView image = (ImageView) findViewById(R.id.imageView);
        Drawable d;

        titel.setText(R.string.historyLabel);
        beschreibung.setText(R.string.historyText);

        InputStream ims = null;
        try {
            ims = getAssets().open("Stadtbild.PNG");
            d = Drawable.createFromStream(ims, null);
            image.setImageDrawable(resize(d));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 700, 406, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }

}