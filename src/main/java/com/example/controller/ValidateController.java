package com.example.controller;

import com.example.entity.Range;
import com.example.util.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidateController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    @ResponseBody
    public boolean validate(@RequestBody Range range) {
        logger.info(range.toString());
        return Validator.isValid(range);
    }


}