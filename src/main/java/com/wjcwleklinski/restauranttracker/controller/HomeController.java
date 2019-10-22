package com.wjcwleklinski.restauranttracker.controller;

import com.wjcwleklinski.restauranttracker.entity.User;
import com.wjcwleklinski.restauranttracker.retrofit.resources.ipstack.IpStackData;
import com.wjcwleklinski.restauranttracker.service.IpStackService;
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

@Controller
public class HomeController {

    @Autowired
    private Logger logger;

    @Autowired
    private UserService userService;

    @Autowired
    private ZomatoService zomatoService;

    @Autowired
    private IpStackService ipStackService;


    @RequestMapping(path = "/home")
    public ModelAndView homePage(HttpServletRequest request) {
        logger.info("Home page loaded");
        ModelAndView modelAndView = new ModelAndView();

        String ip = HttpResponseUtil.getHardcodedIp();
        logger.info(ip);
        try {
            IpStackData ipStackData = ipStackService.getDataByIp(ip);
            logger.info(String.valueOf(ipStackData.getLatitude()));
        } catch (Exception e) {
            logger.warn("Unable to access ipstack data");
        }

        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping(path = "/dbtest")
    public @ResponseBody Iterable<User> dbtest() {
        return userService.findAll();
    }
}
