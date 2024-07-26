package com.example.demo;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import io.undertow.util.StatusCodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class CustomHttHandler implements HttpHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CustomHttHandler.class);

    private final HttpHandler next;

    public CustomHttHandler(HttpHandler next) {
        this.next = next;
    }

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        LOG.info("[MAU]handleRequest...");
        try{
            String path = exchange.getRequestPath();
            String decode = URLDecoder.decode(path, StandardCharsets.UTF_8.name());

            next.handleRequest(exchange);
        }catch (Exception e){
            LOG.info("Error decoding URL:  {}", e.getMessage());

            //redirect
            exchange.setStatusCode(StatusCodes.BAD_REQUEST);
            exchange.getResponseHeaders().put(Headers.LOCATION, "/error/400");
        }
    }
}
