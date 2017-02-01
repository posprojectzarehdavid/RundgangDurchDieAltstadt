package com.example.monkeyman.rundgangdurchdiealtstadt;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by MonkeyMan on 14.12.2016.
 */
public class Sehenswuerdigkeit implements Parcelable{
    String id;
    String nameDeutsch, nameEnglisch;
    LatLng latLng;
    String beschreibungDeutsch, beschreibungEnglisch;

    public Sehenswuerdigkeit(String id, String nameDeutsch, String nameEnglisch, LatLng latLng) {
        this.id = id;
        this.nameDeutsch = nameDeutsch;
        this.nameEnglisch = nameEnglisch;
        this.latLng = latLng;
    }

    protected Sehenswuerdigkeit(Parcel in) {
        id = in.readString();
        nameDeutsch = in.readString();
        nameEnglisch = in.readString();
        beschreibungDeutsch = in.readString();
        beschreibungEnglisch = in.readString();
        latLng = in.readParcelable(LatLng.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nameDeutsch);
        dest.writeString(nameEnglisch);
        dest.writeString(beschreibungDeutsch);
        dest.writeString(beschreibungEnglisch);
        dest.writeParcelable(latLng, flags);
    }

    public static final Creator<Sehenswuerdigkeit> CREATOR = new Creator<Sehenswuerdigkeit>() {
        @Override
        public Sehenswuerdigkeit createFromParcel(Parcel in) {
            return new Sehenswuerdigkeit(in);
        }

        @Override
        public Sehenswuerdigkeit[] newArray(int size) {
            return new Sehenswuerdigkeit[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public int describeContents() {
        return 0;
    }


}
