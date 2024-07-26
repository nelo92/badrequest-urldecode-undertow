package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {

    private static final Logger LOG = LoggerFactory.getLogger(CustomErrorController.class);

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request){
        LOG.info("handleError...");
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status!=null){
            Integer statusCode = Integer.valueOf(status.toString());
            if(statusCode== HttpStatus.BAD_REQUEST.value()){
                return "error-400"; // nom du fichier HTML de la page d'erreur
            }
        }
        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
