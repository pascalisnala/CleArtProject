package com.example.pascalisnala.cleart.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Attraction {

    @SerializedName("attrid")
    private int attrid;

    @SerializedName("attrname")
    private String attrname;

    @SerializedName("location")
    private String location;

    @SerializedName("details")
    private String details;

    @SerializedName("schedule")
    private String schedule;

    public Attraction(int attrid, String attrname, String location, String details, String schedule) {
        this.attrid = attrid;
        this.attrname = attrname;
        this.location = location;
        this.details = details;
        this.schedule = schedule;
    }

    public int getAttrid() {
        return attrid;
    }

    public String getAttrname() {
        return attrname;
    }

    public String getLocation() {
        return location;
    }

    public String getDetails() {
        return details;
    }

    public String getSchedule() {
        return schedule;
    }

}
