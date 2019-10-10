package com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.collections;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CollectionsData {

    @SerializedName("collections")
    @Expose
    private List<Collection> collections = null;
    @SerializedName("has_more")
    @Expose
    private int hasMore;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("display_text")
    @Expose
    private String displayText;
    @SerializedName("has_total")
    @Expose
    private int hasTotal;

    public List<Collection> getCollections() {
        return collections;
    }

    public void setCollections(List<Collection> collections) {
        this.collections = collections;
    }

    public int getHasMore() {
        return hasMore;
    }

    public void setHasMore(int hasMore) {
        this.hasMore = hasMore;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public int getHasTotal() {
        return hasTotal;
    }

    public void setHasTotal(int hasTotal) {
        this.hasTotal = hasTotal;
    }



}
