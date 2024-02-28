package com.example.demo.controllers;

import com.example.demo.services.BasicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
public class BasicController {
    @Autowired
    private Environment environment;
    @Autowired
    private BasicService basicService;
    Logger logger = LoggerFactory.getLogger(BasicController.class);
    @Value("${customVarTree.num1}")
    Integer value1;
    @Value("${customVarTree.num2}")
    Integer value2;

    @GetMapping("/")
    public String welcomeMessage() {
        String message = "Welcome in this app";
        logger.info(message);
        return message;
    }

    @GetMapping("/exp")
    public double calculatePower() {
        return basicService.calculatePower(value1, value2);
    }
    @GetMapping("/get-errors")
    public void throwCustomError() {
        Error error= new Error("Custom error occurred!");
        logger.error("Throwing custom error...",error);
    }
}
