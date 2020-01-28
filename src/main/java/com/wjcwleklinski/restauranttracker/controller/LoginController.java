package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.service.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private Logger logger;

    @GetMapping(path = "/login")
    public String login() {
        //logger.info("Get");

        return "login";
    }

    @GetMapping(path = "/login-success")
    public String successfulLogin(HttpServletRequest request) {

        HttpSession session = request.getSession();
        String loginEmail = request.getUserPrincipal().getName();
        String username = userService.findByEmail(loginEmail).getUsername();

        session.setAttribute("loggedUser", username);


        return "redirect:/home";
    }
}
