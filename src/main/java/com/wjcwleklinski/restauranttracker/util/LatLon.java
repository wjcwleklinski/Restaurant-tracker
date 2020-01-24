package com.wjcwleklinski.restauranttracker.util;

public class LatLon {

    private Double lat;
    private Double lon;

    public LatLon(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public String getLat() {
        return String.valueOf(lat);
    }

    public void setLat(String lat) {
        this.lat = Double.valueOf(lat);
    }

    public String getLon() {
        return  String.valueOf(lon);
    }

    public void setLon(String lon) {
        this.lon = Double.valueOf(lon);
    }

    @Override
    public String toString() {
        return lat + ", " + lon;
    }
}
