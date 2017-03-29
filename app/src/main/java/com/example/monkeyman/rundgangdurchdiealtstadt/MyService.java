package com.example.monkeyman.rundgangdurchdiealtstadt;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by MonkeyMan on 18.01.2017.
 */
public class MyService extends Service implements LocationListener {

    ArrayList<Sehenswuerdigkeit> sehenswuerdigkeiten;
    String language="";
    private LocationManager mLocationManager;

    @Override
    public void onCreate() {
        createLocationManager();
        Log.i("hallo", "serviceOncreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocationManager.removeUpdates(this);
        Log.i("hallo", "destroyservice");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle params = intent.getExtras();
        sehenswuerdigkeiten = (ArrayList<Sehenswuerdigkeit>) params.getSerializable("List");
        language = params.getString("Language");
        Log.i("hallo", "serviceOnstart");
        return super.onStartCommand(intent, flags, startId);
    }

    private void createLocationManager() {
        mLocationManager = (LocationManager) getSystemService(Service.LOCATION_SERVICE);
        Criteria crta = new Criteria();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD) {
            crta.setAccuracy(Criteria.ACCURACY_MEDIUM);
        } else {
            crta.setAccuracy(Criteria.ACCURACY_MEDIUM);
        }
        crta.setPowerRequirement(Criteria.POWER_HIGH);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10, this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // Send a notification
    private void sendNotification(Sehenswuerdigkeit s) {
        // Intent to start the main Activity
        Intent notificationIntent = new Intent(getApplicationContext(), Details.class);
        notificationIntent.putExtra("Sehenswuerdigkeit",s);
        notificationIntent.putExtra("Sprache",language);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Details.class);
        stackBuilder.addNextIntent(notificationIntent);
        PendingIntent notificationPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // Creating and sending Notification
        NotificationManager notificatioMng =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificatioMng.notify(
                0,
                createNotification(s, notificationPendingIntent));
    }

    // Create a notification
    private Notification createNotification(Sehenswuerdigkeit s, PendingIntent notificationPendingIntent) {
        String contentTitle;
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this);
        if(language.equals("English")){
            contentTitle = s.getNameEnglisch();
        } else{
            contentTitle = s.getNameDeutsch();
        }

        notificationBuilder
                .setColor(Color.RED)
                .setSmallIcon(R.drawable.cast_ic_notification_0)
                .setContentTitle(contentTitle)
                .setContentIntent(notificationPendingIntent)
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_VIBRATE | Notification.DEFAULT_SOUND)
                .setAutoCancel(true);
        return notificationBuilder.build();
    }

    @Override
    public void onLocationChanged(Location location) {
        Log.i("hallo", "locationchanged");
        for (int i = 0; i < sehenswuerdigkeiten.size(); i++) {
            Sehenswuerdigkeit s = sehenswuerdigkeiten.get(i);
            int m = (int) location.distanceTo(s.loc);
            Log.i("Distance to"+s.nameDeutsch, m+"");
            if (m < s.radius) {
                Toast.makeText(this, "Radius: " + s.radius+" Distance: "+m, Toast.LENGTH_SHORT).show();
                sendNotification(s);
            }
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
