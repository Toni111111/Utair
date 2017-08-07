package com.example.tony.kodeutair.model.modelcities;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tony on 31/07/17.
 */

public class CityModel {
    @SerializedName("zip")
    private String zip;
    @SerializedName("country")
    private String country;
    @SerializedName("city")
    private String city;
    @SerializedName("members")
    private String members;
    @SerializedName("lon")
    private String lon;
    @SerializedName("state")
    private String state;
    @SerializedName("lat")
    private String lat;


    public String getZip() {
        return zip;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getMembers() {
        return members;
    }

    public String getLon() {
        return lon;
    }

    public String getState() {
        return state;
    }

    public String getLat() {
        return lat;
    }
}
