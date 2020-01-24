package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.search.Restaurant;
import com.wjcwleklinski.restauranttracker.service.OpenCageService;
import com.wjcwleklinski.restauranttracker.service.ZomatoService;
import com.wjcwleklinski.restauranttracker.util.LatLon;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

//todo: Exceptions; get rid of hardcoded start = "0";



@Controller
public class RankingController {

    @Autowired
    private ZomatoService zomatoService;

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

        Optional<LatLon> optionalLatLon = openCageService.getLatLongByCityName(providedLocation);
        if (!optionalLatLon.isPresent()) {
            throw new NullPointerException();
        }
        LatLon latLon = optionalLatLon.get();

        Optional<List<Restaurant>> optionalRestaurants = zomatoService
                .getRestaurantsInRadiusFromLatLon(latLon.getLat(), latLon.getLon(), "0");
        if (!optionalRestaurants.isPresent()) {
            throw new NullPointerException();
            // do smth if so
        }
        List<Restaurant> restaurants = optionalRestaurants.get();

        logger.info(providedLocation + "  " + latLon);
        model.addAttribute("restaurants", restaurants);

        return "ranking";
    }

}
