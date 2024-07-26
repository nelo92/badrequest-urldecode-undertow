package com.example.demo;


import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

//@Component
public class UrlDecodeFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(UrlDecodeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOG.info("doFilter...");
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (IllegalArgumentException e) {
            LOG.info("doFilter - IllegalArgumentException - Message: "+ e.getMessage());
            throw e;
        }
    }
}
