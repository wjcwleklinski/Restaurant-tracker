package com.wjcwleklinski.restauranttracker.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Configuration
public class SessionManager {

    @Autowired
    private Logger logger;



    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postAction() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getAction() {
    }

    @Pointcut("execution(* com.wjcwleklinski.restauranttracker.controller.*.*(..))")
    public void controllerPointcut() {}

//    @Before("controllerPointcut()")
//    public void printer(JoinPoint joinPoint) {
//        logger.info(joinPoint.getSignature().getName());
//    }

    @Before("getAction()")
    public void getMethodCalled(JoinPoint joinPoint) {
        logger.info("Method: GET, endpoint: " + joinPoint.getSignature().getName());
    }

    @Before("postAction()")
    public void postMethodCalled(JoinPoint joinPoint) {
        logger.info("Method: POST, endpoint: " + joinPoint.getSignature().getName());
    }
}
