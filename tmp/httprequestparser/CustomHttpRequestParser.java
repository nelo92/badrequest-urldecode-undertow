package com.example.demo;

import io.undertow.server.protocol.http.HttpRequestParser;
import org.xnio.OptionMap;

public class CustomHttpRequestParser extends HttpRequestParser {
    public CustomHttpRequestParser(OptionMap options) {
        super(options);
    }
}
