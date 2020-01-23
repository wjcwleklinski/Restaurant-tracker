package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.retrofit.resources.ipstack.IpStackData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.CityData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.LocationSuggestion;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.LocationDetails;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.BestRatedRestaurant;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.search.Restaurant;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.search.Restaurant_;
import com.wjcwleklinski.restauranttracker.service.IpStackService;
import com.wjcwleklinski.restauranttracker.service.OpenCageService;
import com.wjcwleklinski.restauranttracker.service.ZomatoService;
import com.wjcwleklinski.restauranttracker.util.HttpResponseUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RankingController {

    @Autowired
    private ZomatoService zomatoService;

    @Autowired
    private IpStackService ipStackService;

    @Autowired
    private OpenCageService openCageService;

    @Autowired
    private Logger logger;

    @GetMapping(path = "/ranking")
    public String ranking(Model model, HttpServletRequest request) {

        return "ranking";
    }

    @PostMapping(path = "/ranking")
    public String rankingWithProvidedLocation(@RequestParam String providedLocation, Model model) {
        logger.info(providedLocation);

        String latLon = openCageService.getLatLongByCityName(providedLocation);
        logger.info("Location: " + latLon);
        String[] location = latLon.split(", ");
        logger.info(location[0] + " i " + location[1]);

        List<Restaurant> restaurants2 = zomatoService.getRestaurantsInRadiusFromLatLon(location[0], location[1]);

        logger.info(restaurants2.get(0).getRestaurant().getName() + "  " + restaurants2.size());



        return "ranking";
    }

}
