package com.example.monkeyman.rundgangdurchdiealtstadt;

/**
 * Created by MonkeyMan on 14.12.2016.
 */
public class Sehenswuerdigkeit {
    int id;
    String name;
    double latitude, longitude;
    String beschreibungDeutsch, beschreibungEnglisch;

    public Sehenswuerdigkeit(int id, String name, double latitude, double longitude,
                             String beschreibungDeutsch, String beschreibungEnglisch) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.beschreibungDeutsch = beschreibungDeutsch;
        this.beschreibungEnglisch = beschreibungEnglisch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getBeschreibungDeutsch() {
        return beschreibungDeutsch;
    }

    public void setBeschreibungDeutsch(String beschreibungDeutsch) {
        this.beschreibungDeutsch = beschreibungDeutsch;
    }

    public String getBeschreibungEnglisch() {
        return beschreibungEnglisch;
    }

    public void setBeschreibungEnglisch(String beschreibungEnglisch) {
        this.beschreibungEnglisch = beschreibungEnglisch;
    }

    @Override
    public String toString() {
        return "Sehenswuerdigkeit: "+name;
    }
}
