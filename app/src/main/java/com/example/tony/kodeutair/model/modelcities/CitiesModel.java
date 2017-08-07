package com.example.tony.kodeutair.model.modelcities;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CitiesModel implements Parcelable {
    @SerializedName("results")
    private ArrayList<CityModel> cities;
    @SerializedName("meta")
    private Meta meta;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }

    public ArrayList<CityModel> getCities() {
        return cities;
    }

    public Meta getMeta() {
        return meta;
    }
}
