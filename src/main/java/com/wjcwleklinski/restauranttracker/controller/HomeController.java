package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.entity.User;
import com.wjcwleklinski.restauranttracker.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @Autowired
    private Logger logger;

    @Autowired
    private UserService userService;

    @GetMapping(path = "/home")
    public String homePage() {
        logger.info("Home page loaded");
        return "home";
    }

    @GetMapping(path = "/dbtest")
    public @ResponseBody Iterable<User> dbtest() {
        return userService.findAll();
    }
}
