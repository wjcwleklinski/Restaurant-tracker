package com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.BestRatedRestaurant;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.location.Location;

public class LocationDetails {

    @SerializedName("popularity")
    @Expose
    private String popularity;
    @SerializedName("nightlife_index")
    @Expose
    private String nightlifeIndex;
    @SerializedName("nearby_res")
    @Expose
    private List<String> nearbyRes = null;
    @SerializedName("top_cuisines")
    @Expose
    private List<String> topCuisines = null;
    @SerializedName("popularity_res")
    @Expose
    private String popularityRes;
    @SerializedName("nightlife_res")
    @Expose
    private String nightlifeRes;
    @SerializedName("subzone")
    @Expose
    private String subzone;
    @SerializedName("subzone_id")
    @Expose
    private int subzoneId;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("num_restaurant")
    @Expose
    private int numRestaurant;
    @SerializedName("best_rated_restaurant")
    @Expose
    private List<BestRatedRestaurant> bestRatedRestaurant = null;

    public String getPopularity() {
        return popularity;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }

    public String getNightlifeIndex() {
        return nightlifeIndex;
    }

    public void setNightlifeIndex(String nightlifeIndex) {
        this.nightlifeIndex = nightlifeIndex;
    }

    public List<String> getNearbyRes() {
        return nearbyRes;
    }

    public void setNearbyRes(List<String> nearbyRes) {
        this.nearbyRes = nearbyRes;
    }

    public List<String> getTopCuisines() {
        return topCuisines;
    }

    public void setTopCuisines(List<String> topCuisines) {
        this.topCuisines = topCuisines;
    }

    public String getPopularityRes() {
        return popularityRes;
    }

    public void setPopularityRes(String popularityRes) {
        this.popularityRes = popularityRes;
    }

    public String getNightlifeRes() {
        return nightlifeRes;
    }

    public void setNightlifeRes(String nightlifeRes) {
        this.nightlifeRes = nightlifeRes;
    }

    public String getSubzone() {
        return subzone;
    }

    public void setSubzone(String subzone) {
        this.subzone = subzone;
    }

    public int getSubzoneId() {
        return subzoneId;
    }

    public void setSubzoneId(int subzoneId) {
        this.subzoneId = subzoneId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getNumRestaurant() {
        return numRestaurant;
    }

    public void setNumRestaurant(int numRestaurant) {
        this.numRestaurant = numRestaurant;
    }

    public List<BestRatedRestaurant> getBestRatedRestaurant() {
        return bestRatedRestaurant;
    }

    public void setBestRatedRestaurant(List<BestRatedRestaurant> bestRatedRestaurant) {
        this.bestRatedRestaurant = bestRatedRestaurant;
    }

}