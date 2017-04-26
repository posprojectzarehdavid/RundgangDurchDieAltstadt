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
 * Created by David A on 11.01.2017.
 */
public class Details extends FragmentActivity {

    Sehenswuerdigkeit s;
    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        Intent intent = getIntent();
        Bundle params = intent.getExtras();
        language = intent.getSerializableExtra("Sprache").toString();
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

        if(!se.id.equals("s10")) {
            InputStream ims = getAssets().open(se.id + ".PNG");
            d = Drawable.createFromStream(ims, null);
            image.setImageDrawable(resize(d));
        }
        else{
            InputStream ims = getAssets().open(se.id + ".jpg");
            d = Drawable.createFromStream(ims, null);
            image.setImageDrawable(resize(d));
        }
        if(language.equals("English")){
            titel.setText(se.getNameEnglisch());
            beschreibung.setText(se.getBeschreibungEnglisch());
        }
        else if(language.equals("Deutsch")){
            titel.setText(se.getNameDeutsch());
            beschreibung.setText(se.getBeschreibungDeutsch());
        }
    }

    private Drawable resize(Drawable image) {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b, 420, 300, false);
        return new BitmapDrawable(getResources(), bitmapResized);
    }
}
