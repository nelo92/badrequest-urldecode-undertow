package com.example.demo;

import io.undertow.util.UrlDecodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(UrlDecodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleUrlDecodeException(UrlDecodeException ex, Model model){
        LOG.info("handleUrlDecodeException...");
        model.addAttribute("error", "Bad Request");
        model.addAttribute("message", "The request could not be understood by the server.");
        return "error-400";
    }
}
