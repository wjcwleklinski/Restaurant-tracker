package com.wjcwleklinski.restauranttracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    Logger logger;

    @GetMapping(path = "/home")
    public String homePage() {
        logger.warn("TEST");
        return "home";
    }
}
