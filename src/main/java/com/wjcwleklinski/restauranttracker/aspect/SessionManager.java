package com.wjcwleklinski.restauranttracker.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class SessionManager {

    @Autowired
    Logger logger;


    @Pointcut("execution(* com.wjcwleklinski.restauranttracker.controller.LoginController.*(..))")
    public void loginPointcut() {}



    @AfterReturning("loginPointcut()")
    public void addUsernameToSession() {
        logger.info("in aspect");
    }
}
