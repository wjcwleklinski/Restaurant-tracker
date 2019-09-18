package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.entity.Role;
import com.wjcwleklinski.restauranttracker.entity.User;
import com.wjcwleklinski.restauranttracker.service.RoleService;
import com.wjcwleklinski.restauranttracker.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;


@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    Logger logger;

    @GetMapping(path = "/registration")
    public String registration(Model model) {
        User user = new User();
        String validPassword = "";
        model.addAttribute("user", user);
        model.addAttribute("validPassword", validPassword);
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String registerUser(@Valid User user, BindingResult bindingResult, String validPassword) {

        // check if user already exists
        User existingUser = userService.findByEmail(user.getEmail());
        if (existingUser != null) {
            bindingResult.rejectValue("email", "error.user",
                    "User with provided email already exists!");
        }

        if( !userService.passwordsMatch(user.getPassword(), validPassword) ) {
            bindingResult.rejectValue("password", "error.user",
                    "Passwords are not the same!");
        }
        if(bindingResult.hasErrors())
            return "registration";
        else {

            userService.saveNewUser(user);
        }
        return "registration";
    }
}
