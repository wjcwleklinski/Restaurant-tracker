package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.entity.User;
import com.wjcwleklinski.restauranttracker.retrofit.resources.ifconfig.IfconfigData;
import com.wjcwleklinski.restauranttracker.retrofit.resources.zomato.cities.LocationSuggestion;
import com.wjcwleklinski.restauranttracker.service.IfconfigService;
import com.wjcwleklinski.restauranttracker.service.UserService;
import com.wjcwleklinski.restauranttracker.service.ZomatoService;
import com.wjcwleklinski.restauranttracker.util.HttpResponseUtil;
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
import java.util.Collections;

@Controller
public class HomeController {

    @Autowired
    private Logger logger;

    @Autowired
    private UserService userService;

    @Autowired
    private ZomatoService zomatoService;

    @Autowired
    private IfconfigService ifconfigService;

    @RequestMapping(path = "/home")
    public ModelAndView homePage(HttpServletRequest request) {
        logger.info("Home page loaded");
        ModelAndView modelAndView = new ModelAndView();
//
//
//
        logger.info(HttpResponseUtil.getIp());

        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping(path = "/dbtest")
    public @ResponseBody Iterable<User> dbtest() {
        return userService.findAll();
    }
}
