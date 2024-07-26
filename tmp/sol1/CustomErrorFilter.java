package com.example.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
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
            String val = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
            LOG.info("[MAU] path decode ={}", val);
            // si tout est correct, continuer le traitement
            chain.doFilter(request, response);
        } catch (IllegalArgumentException e) {
            LOG.info("[MAU] doFilter - IllegalArgumentException - Message: "+ e.getMessage());
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid URL encoding :"+ e.getMessage());
        }
    }
}
