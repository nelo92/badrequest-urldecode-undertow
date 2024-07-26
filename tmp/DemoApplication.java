package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

//	@Bean
//	public FilterRegistrationBean<UrlDecodeFilter> urlDecodeFilter(){
//		FilterRegistrationBean<UrlDecodeFilter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new UrlDecodeFilter());
//		registrationBean.addUrlPatterns("/*");
//		registrationBean.setOrder(Integer.MIN_VALUE);// Ensure this filter is invoked first
//		return registrationBean;
//	}

}
