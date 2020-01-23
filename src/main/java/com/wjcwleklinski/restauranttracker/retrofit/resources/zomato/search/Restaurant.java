
package com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.search;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant {

    @SerializedName("restaurant")
    @Expose
    private Restaurant_ restaurants;

    public Restaurant_ getRestaurant() {
        return restaurants;
    }

    public void setRestaurant(Restaurant_ restaurants) {
        this.restaurants = restaurants;
    }

}
