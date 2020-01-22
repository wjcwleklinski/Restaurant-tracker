
package com.wjcwleklinski.restauranttracker.retrofit.resources.opencage;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpenCageResponse {

    @SerializedName("documentation")
    @Expose
    private String documentation;
    @SerializedName("licenses")
    @Expose
    private List<License> licenses = null;
    @SerializedName("rate")
    @Expose
    private Rate rate;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("stay_informed")
    @Expose
    private StayInformed stayInformed;
    @SerializedName("thanks")
    @Expose
    private String thanks;
    @SerializedName("timestamp")
    @Expose
    private Timestamp timestamp;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }

    public List<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(List<License> licenses) {
        this.licenses = licenses;
    }

    public Rate getRate() {
        return rate;
    }

    public void setRate(Rate rate) {
        this.rate = rate;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StayInformed getStayInformed() {
        return stayInformed;
    }

    public void setStayInformed(StayInformed stayInformed) {
        this.stayInformed = stayInformed;
    }

    public String getThanks() {
        return thanks;
    }

    public void setThanks(String thanks) {
        this.thanks = thanks;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

}
