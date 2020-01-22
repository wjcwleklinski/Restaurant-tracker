
package com.wjcwleklinski.restauranttracker.retrofit.resources.opencage;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Components {

    @SerializedName("ISO_3166-1_alpha-2")
    @Expose
    private String iSO31661Alpha2;
    @SerializedName("ISO_3166-1_alpha-3")
    @Expose
    private String iSO31661Alpha3;
    @SerializedName("_category")
    @Expose
    private String category;
    @SerializedName("_type")
    @Expose
    private String type;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("continent")
    @Expose
    private String continent;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("country_code")
    @Expose
    private String countryCode;
    @SerializedName("county")
    @Expose
    private String county;
    @SerializedName("political_union")
    @Expose
    private String politicalUnion;
    @SerializedName("postcode")
    @Expose
    private String postcode;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("state_district")
    @Expose
    private String stateDistrict;

    public String getISO31661Alpha2() {
        return iSO31661Alpha2;
    }

    public void setISO31661Alpha2(String iSO31661Alpha2) {
        this.iSO31661Alpha2 = iSO31661Alpha2;
    }

    public String getISO31661Alpha3() {
        return iSO31661Alpha3;
    }

    public void setISO31661Alpha3(String iSO31661Alpha3) {
        this.iSO31661Alpha3 = iSO31661Alpha3;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPoliticalUnion() {
        return politicalUnion;
    }

    public void setPoliticalUnion(String politicalUnion) {
        this.politicalUnion = politicalUnion;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateDistrict() {
        return stateDistrict;
    }

    public void setStateDistrict(String stateDistrict) {
        this.stateDistrict = stateDistrict;
    }

}
