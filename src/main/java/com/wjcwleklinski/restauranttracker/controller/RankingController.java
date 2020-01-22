package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.retrofit.resources.ipstack.IpStackData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.CityData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.LocationSuggestion;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.LocationDetails;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.location_details.best_rated_restaurant.BestRatedRestaurant;
import com.wjcwleklinski.restauranttracker.service.IpStackService;
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
    private Logger logger;

    @GetMapping(path = "/ranking")
    public String ranking(Model model, HttpServletRequest request) {


        String ip = HttpResponseUtil.getHardcodedIp();
        IpStackData data = ipStackService.getIpStackDataByIp(ip);
        String locationMsg = "We were unable to find you. Please provide your location.";

        if (data != null) {
            locationMsg = data.getCity() + ", " + data.getCountryName();
            List<BestRatedRestaurant> restaurants = zomatoService.getBestRatedRestaurantsByLatLon(data.getLatitude(),
                    data.getLongitude());
            if (restaurants != null) {
                model.addAttribute("restaurants", restaurants);
            }

        }
        request.getSession().setAttribute("location", locationMsg);


        return "ranking";
    }

    @PostMapping(path = "/ranking")
    public String rankingWithProvidedLocation(@RequestParam String providedLocation, Model model) {
        logger.info(providedLocation);

        List<BestRatedRestaurant> restaurants = zomatoService.getBestRatedRestaurantsByCityName(providedLocation);
        model.addAttribute("restaurants", restaurants);
        return "ranking";
    }

}
