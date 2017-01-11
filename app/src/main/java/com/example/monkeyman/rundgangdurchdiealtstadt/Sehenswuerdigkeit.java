package com.example.monkeyman.rundgangdurchdiealtstadt;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by MonkeyMan on 14.12.2016.
 */
public class Sehenswuerdigkeit implements Serializable{
    int id;
    String nameDeutsch, nameEnglisch;
    LatLng latLng;
    String beschreibungDeutsch, beschreibungEnglisch;

    public Sehenswuerdigkeit(int id, String nameDeutsch, String nameEnglisch, LatLng latLng) {
        this.id = id;
        this.nameDeutsch = nameDeutsch;
        this.nameEnglisch = nameEnglisch;
        this.latLng = latLng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDeutsch() {
        return nameDeutsch;
    }

    public void setNameDeutsch(String nameDeutsch) {
        this.nameDeutsch = nameDeutsch;
    }

    public String getNameEnglisch() {
        return nameEnglisch;
    }

    public void setNameEnglisch(String nameEnglisch) {
        this.nameEnglisch = nameEnglisch;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
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
}
