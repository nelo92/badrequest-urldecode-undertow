package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MaTestController {

    private static final Logger LOG = LoggerFactory.getLogger(MaTestController.class);


    @GetMapping("/decode/{value}")
    public String decode(@DecodedPathVariable("value") String decodedValue) {
        return "Decoded value: " + decodedValue;
    }
    @GetMapping("/decode/{value}/suite")
    public String decodesuite(@DecodedPathVariable("value") String decodedValue) {
        return "Decoded value: " + decodedValue;
    }


    @GetMapping("/test/{input}")
    public String test(@PathVariable String input) {
        return method(input);
    }

    @GetMapping("/test/{input}/suite")
    public String testsuite(@PathVariable String input) {
       return method(input);
    }

//    @RequestMapping(value = "/test1/{input}", method = RequestMethod.PUT)
//    public String test1(@PathVariable String input) {
//        return method(input);
//    }

    private String method(String input){
        LOG.info("Received input: {}", input);
        LOG.debug("DEBUG - Received input: {}", input);
        return "Valid input :" + input;
    }
}
