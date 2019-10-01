package com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.restaurant.R;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.restaurant.R.has_menu_status.HasMenuStatus;

public class R {

    @SerializedName("has_menu_status")
    @Expose
    private HasMenuStatus hasMenuStatus;
    @SerializedName("res_id")
    @Expose
    private int resId;

    public HasMenuStatus getHasMenuStatus() {
        return hasMenuStatus;
    }

    public void setHasMenuStatus(HasMenuStatus hasMenuStatus) {
        this.hasMenuStatus = hasMenuStatus;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

}