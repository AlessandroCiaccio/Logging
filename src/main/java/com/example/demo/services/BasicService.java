package com.example.demo.services;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class BasicService {
    Logger logger = (Logger) LoggerFactory.getLogger(BasicService.class);

    public double calculatePower(Integer value1, Integer value2) {
        double result = Math.pow(value1, value2);
        logger.debug("Starting calculation...");
        logger.debug("{} raised to the power of {} is: {}", value1, value2, result);
        logger.debug("Calculation finished.");
        return result;
    }

}
