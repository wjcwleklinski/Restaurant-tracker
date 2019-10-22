package com.wjcwleklinski.restauranttracker.retrofit.resources.ipstack;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

    @SerializedName("geoname_id")
    @Expose
    private int geonameId;
    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("languages")
    @Expose
    private List<Language> languages = null;
    @SerializedName("country_flag")
    @Expose
    private String countryFlag;
    @SerializedName("country_flag_emoji")
    @Expose
    private String countryFlagEmoji;
    @SerializedName("country_flag_emoji_unicode")
    @Expose
    private String countryFlagEmojiUnicode;
    @SerializedName("calling_code")
    @Expose
    private String callingCode;
    @SerializedName("is_eu")
    @Expose
    private boolean isEu;

    public int getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(int geonameId) {
        this.geonameId = geonameId;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getCountryFlagEmoji() {
        return countryFlagEmoji;
    }

    public void setCountryFlagEmoji(String countryFlagEmoji) {
        this.countryFlagEmoji = countryFlagEmoji;
    }

    public String getCountryFlagEmojiUnicode() {
        return countryFlagEmojiUnicode;
    }

    public void setCountryFlagEmojiUnicode(String countryFlagEmojiUnicode) {
        this.countryFlagEmojiUnicode = countryFlagEmojiUnicode;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(String callingCode) {
        this.callingCode = callingCode;
    }

    public boolean isIsEu() {
        return isEu;
    }

    public void setIsEu(boolean isEu) {
        this.isEu = isEu;
    }
}
