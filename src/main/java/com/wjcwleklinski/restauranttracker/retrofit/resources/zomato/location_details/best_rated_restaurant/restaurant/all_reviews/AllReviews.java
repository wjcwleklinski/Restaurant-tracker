package com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.restaurant.all_reviews;


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AllReviews {

    @SerializedName("reviews")
    @Expose
    private List<Review> reviews = null;

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}