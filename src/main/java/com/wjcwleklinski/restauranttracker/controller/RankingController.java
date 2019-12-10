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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
        try {
            IpStackData data = ipStackService.getDataByIp(ip);
            request.getSession().setAttribute("city", data.getCity());
            request.getSession().setAttribute("country", data.getCountryName());

            CityData hostLocation = zomatoService.getCityDataByLatLon(
                    String.valueOf(data.getLatitude()), String.valueOf(data.getLongitude()));


            LocationDetails locationDetails =
                    zomatoService.getLocationDetailsById(String.valueOf(hostLocation.getLocationSuggestions().get(0).getId()));

            List<BestRatedRestaurant> restaurants = locationDetails.getBestRatedRestaurant();
            model.addAttribute("restaurants", restaurants);

        } catch (Exception e) {
            logger.warn("Unable to find user's location");
            e.printStackTrace();
        }

        return "ranking";
    }
}
