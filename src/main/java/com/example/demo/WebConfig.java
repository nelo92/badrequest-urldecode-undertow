package com.example.demo;

import io.undertow.servlet.api.DeploymentInfo;
import org.springframework.boot.web.embedded.undertow.UndertowDeploymentInfoCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

	@Bean
	public WebServerFactoryCustomizer<UndertowServletWebServerFactory> undertowServerFactoryCustomizer(){
		return factory -> factory.addDeploymentInfoCustomizers(new UndertowDeploymentInfoCustomizer() {
			@Override
			public void customize(DeploymentInfo deploymentInfo) {
				deploymentInfo.addInnerHandlerChainWrapper(handler -> new CustomHttHandler(handler));
			}
		});
	}

//		implements WebMvcConfigurer {
//
//    @Bean
//	public FilterRegistrationBean<CustomErrorFilter> urlDecodeFilter(){
//		FilterRegistrationBean<CustomErrorFilter> registrationBean = new FilterRegistrationBean<>();
//		registrationBean.setFilter(new CustomErrorFilter());
//		registrationBean.addUrlPatterns("/*");
//		registrationBean.setOrder(Integer.MIN_VALUE);// Ensure this filter is invoked first
//		return registrationBean;
//	}

}
