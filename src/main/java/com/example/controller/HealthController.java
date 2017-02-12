package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HealthController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @RequestMapping(value = "/health", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void health() {
        logger.info("Health service has been invoked.");
    }

}