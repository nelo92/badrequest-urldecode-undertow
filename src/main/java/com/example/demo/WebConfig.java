package com.example.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new DecodedPathVariableResolver());
	}

	@Bean
	public FilterRegistrationBean<CustomErrorFilter> urlDecodeFilter(){
		FilterRegistrationBean<CustomErrorFilter> registrationBean = new FilterRegistrationBean<>();
		registrationBean.setFilter(new CustomErrorFilter());
		registrationBean.addUrlPatterns("/*");
		registrationBean.setOrder(Integer.MIN_VALUE);// Ensure this filter is invoked first
		return registrationBean;
	}

}
