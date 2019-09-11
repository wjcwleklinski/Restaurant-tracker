package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    @RequestMapping(path = "/registration")
    public String registration(Model model) {

        User user = new User();
        user.setUsername("Jan");
        model.addAttribute("user", user);

        return "registration";
    }
}
