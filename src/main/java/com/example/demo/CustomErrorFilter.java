package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CustomErrorFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(CustomErrorFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info("[MAU] doFilter...");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        try {
            // valider l'encodage de l'URL
            String path = httpRequest.getRequestURI();
            LOG.info("[MAU] path={}", path);

//            if( httpRequest.getRequestURI().contains("%")) {
//                LOG.info("[MAU] contains %");
//
//                String val = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
//                LOG.info("[MAU] decode uri={}", val);
//                HttpServletRequest modifiedRequest = new HttpServletRequestWrapper((httpRequest)) {
//                    @Override
//                    public String getRequestURI() {
//                        return val;
//                    }
//                };
//                // si tout est correct, continuer le traitement
//                chain.doFilter(modifiedRequest, response);
//            }else{
//                // si tout est correct, continuer le traitement
//                chain.doFilter(request, response);
//            }

//            URLDecoder.decode(path, StandardCharsets.UTF_8.name());

            chain.doFilter(request, response);


        } catch(IllegalArgumentException e){
            LOG.info("[MAU] doFilter - show error 400");
//            httpResponse.sendRedirect(httpRequest.getContextPath() + "/error/400");
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL encoding :"+ e.getMessage());
        } catch (Exception e) {

            LOG.info("[MAU] doFilter - Exception Message: "+ e.getMessage());
            LOG.info("[MAU] doFilter - Exception Message: "+ e.getClass());

//            LOG.info("[MAU] doFilter - IllegalArgumentException - Message: "+ e.getMessage());
//            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL encoding :"+ e.getMessage());


            if(httpResponse.getStatus() == HttpServletResponse.SC_BAD_REQUEST){
                LOG.info("[MAU] doFilter - show error 400");
//                httpResponse.sendRedirect(httpRequest.getContextPath() + "/error/400");
                httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL encoding :"+ e.getMessage());
            }else{
                LOG.info("[MAU] doFilter -sendError SC_INTERNAL_SERVER_ERROR - status="+ httpResponse.getStatus());
                httpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Server Error");
            }
        }
    }
}
