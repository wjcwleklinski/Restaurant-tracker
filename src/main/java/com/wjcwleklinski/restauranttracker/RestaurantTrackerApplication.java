package com.wjcwleklinski.restauranttracker;

import com.wjcwleklinski.restauranttracker.controller.HomeController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class RestaurantTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantTrackerApplication.class, args);
	}

}
