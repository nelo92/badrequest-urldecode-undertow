package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	private static final Logger LOG = LoggerFactory.getLogger(DemoApplication.class);
	
	public static void main(String[] args) {
		LOG.info("[MAU] Application start...");
		SpringApplication.run(DemoApplication.class, args);
	}

}
