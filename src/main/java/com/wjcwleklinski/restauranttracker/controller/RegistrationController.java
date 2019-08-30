package com.wjcwleklinski.restauranttracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistrationController {

    @GetMapping(path = "/register")
    public String register() {
        return "register";
    }
}
