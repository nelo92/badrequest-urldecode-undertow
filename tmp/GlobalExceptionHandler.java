package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

//    @ExceptionHandler(BadRequestException.class)
//    public ResponseEntity<String> handleBadRequestException(BadRequestException ex) {
//        LOG.info("[MAU] handleBadRequestException...");
//        return ResponseEntity.badRequest().body("Invalid URL format: " + ex.getMessage());
//    }
}
