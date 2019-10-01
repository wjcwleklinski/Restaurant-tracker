package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.retrofit.resources.ifconfig.IfconfigData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.CityData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.LocationSuggestion;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.LocationDetails;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.BestRatedRestaurant;
import com.wjcwleklinski.restauranttracker.service.IfconfigService;
import com.wjcwleklinski.restauranttracker.service.ZomatoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
public class RankingController {

    @Autowired
    ZomatoService zomatoService;

    @Autowired
    IfconfigService ifconfigService;

    @Autowired
    Logger logger;

    @GetMapping
    public String ranking(Model model) {

        try {
            // get lat and lon
            IfconfigData ifconfigData = ifconfigService.getIfconfigData();
            double lon = ifconfigData.getLongitude();
            double lat = ifconfigData.getLatitude();
            // get city name and id based on lat/lon
            CityData cityData = zomatoService.getCityDataByLatLon(String.valueOf(lat), String.valueOf(lon));
            LocationSuggestion firstSuggestion = cityData.getLocationSuggestions().stream().findFirst().get();
            String cityName = firstSuggestion.getName();
            String countryName = firstSuggestion.getCountryName();
            int cityId = firstSuggestion.getId();
            model.addAttribute("location", cityName + ", " + countryName);

            // get best rated restaurants based on city id
            LocationDetails ld = zomatoService.getLocationDetailsById(String.valueOf(cityId));
            List<BestRatedRestaurant> restaurants = ld.getBestRatedRestaurant();
            model.addAttribute("restaurants", restaurants);

        } catch (IOException e) {
            logger.warn("Unable to get location");
            model.addAttribute("location", "Not found");
        }
        return "ranking";
    }
}
