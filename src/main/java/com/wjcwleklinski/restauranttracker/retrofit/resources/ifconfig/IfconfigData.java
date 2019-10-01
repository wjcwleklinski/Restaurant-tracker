package com.wjcwleklinski.restauranttracker.retrofit.resources.ifconfig;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IfconfigData {

    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("ip_decimal")
    @Expose
    private long ipDecimal;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("country_eu")
    @Expose
    private boolean countryEu;
    @SerializedName("country_iso")
    @Expose
    private String countryIso;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("latitude")
    @Expose
    private double latitude;
    @SerializedName("longitude")
    @Expose
    private double longitude;
    @SerializedName("asn")
    @Expose
    private String asn;
    @SerializedName("asn_org")
    @Expose
    private String asnOrg;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public long getIpDecimal() {
        return ipDecimal;
    }

    public void setIpDecimal(int ipDecimal) {
        this.ipDecimal = ipDecimal;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isCountryEu() {
        return countryEu;
    }

    public void setCountryEu(boolean countryEu) {
        this.countryEu = countryEu;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
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

    public String getAsn() {
        return asn;
    }

    public void setAsn(String asn) {
        this.asn = asn;
    }

    public String getAsnOrg() {
        return asnOrg;
    }

    public void setAsnOrg(String asnOrg) {
        this.asnOrg = asnOrg;
    }

    @Override
    public String toString() {
        return "IfconfigData{" +
                "ip='" + ip + '\'' +
                ", ipDecimal=" + ipDecimal +
                ", country='" + country + '\'' +
                ", countryEu=" + countryEu +
                ", countryIso='" + countryIso + '\'' +
                ", city='" + city + '\'' +
                ", hostname='" + hostname + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", asn='" + asn + '\'' +
                ", asnOrg='" + asnOrg + '\'' +
                '}';
    }
}
