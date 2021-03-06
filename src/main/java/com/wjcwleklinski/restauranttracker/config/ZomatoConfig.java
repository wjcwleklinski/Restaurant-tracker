package com.wjcwleklinski.restauranttracker.config;

public interface ZomatoConfig {

    // move those to application.props

    String API_URL = "https://developers.zomato.com/api/v2.1/";
    String API_KEY = "aca77aa4669e61efd2483f52d1e9bc8e";

    String SEARCH_ENTITY_TYPE = "zone";
    String SEARCH_COUNT = "15";
    String SEARCH_SORT = "rating";
    String SEARCH_ORDER = "desc";

}
