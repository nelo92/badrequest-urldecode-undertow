package com.example.demo;

import io.undertow.UndertowOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;


@Component
public class UnderTowConfig implements WebServerFactoryCustomizer<UndertowServletWebServerFactory> {
    private static final Logger LOG = LoggerFactory.getLogger(UnderTowConfig.class);
    @Override
    public void customize(UndertowServletWebServerFactory factory) {
        LOG.info("[MAU] customize...");
        factory.addBuilderCustomizers(builder -> {
            builder.setServerOption(UndertowOptions.DECODE_URL, false);
//            builder.setServerOption(UndertowOptions.URL_CHARSET, "UTF-8");
//                builder.setServerOption(UndertowOptions.ALLOW_UNESCAPED_CHARACTERS_IN_URL, Boolean.TRUE);
        });
    }
}
