package com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.restaurant.R.has_menu_status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HasMenuStatus {

    @SerializedName("delivery")
    @Expose
    private int delivery;
    @SerializedName("takeaway")
    @Expose
    private int takeaway;

    public int getDelivery() {
        return delivery;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public int getTakeaway() {
        return takeaway;
    }

    public void setTakeaway(int takeaway) {
        this.takeaway = takeaway;
    }

}