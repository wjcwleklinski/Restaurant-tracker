package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.entity.User;
import com.wjcwleklinski.restauranttracker.service.UserService;
import com.wjcwleklinski.restauranttracker.service.ZomatoService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private Logger logger;

    @Autowired
    private UserService userService;

    @Autowired
    private ZomatoService zomatoService;

    @RequestMapping(path = "/home")
    public ModelAndView homePage(HttpServletRequest request) {
        logger.info("Home page loaded");
        ModelAndView modelAndView = new ModelAndView();

        // add username to session to display on header
        try {
            HttpSession session = request.getSession();
            Principal principal = request.getUserPrincipal();
            String loginEmail = principal.getName();
            String username = userService.findByEmail(loginEmail).getUsername();
            session.setAttribute("loggedUser", username);
        } catch (Exception e) {
            logger.info("There is no logged in user");
        }

//        try {
//            CityData krakow = zomatoService.getCityData("Krakow");
//            logger.warn(krakow.getLocationSuggestions().get(0).getName());
//        } catch (IOException e) {
//            logger.warn("error");
//            logger.warn(e.getMessage());
//        }

        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping(path = "/dbtest")
    public @ResponseBody Iterable<User> dbtest() {
        return userService.findAll();
    }
}
