package com.wjcwleklinski.restauranttracker.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    @Autowired
    private Logger logger;


    @PostMapping("/user")
    public void addToFavourite(@RequestBody String restaurantId) {
        logger.info(restaurantId);
    }

}
