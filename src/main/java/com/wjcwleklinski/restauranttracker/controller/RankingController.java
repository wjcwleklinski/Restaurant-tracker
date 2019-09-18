package com.wjcwleklinski.restauranttracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RankingController {

    @GetMapping
    public String ranking() {

        return "ranking";
    }
}
