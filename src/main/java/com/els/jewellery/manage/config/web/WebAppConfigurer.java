package com.els.jewellery.manage.config.web;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration()
public class WebAppConfigurer extends WebMvcConfigurerAdapter {

	@Bean
	public MultipartResolver multipartResolver(){
		CommonsMultipartResolver commonsMultipartResolve = new CommonsMultipartResolver();
		commonsMultipartResolve.setMaxUploadSize(104857600);
		commonsMultipartResolve.setMaxUploadSizePerFile(5242880);
		commonsMultipartResolve.setMaxInMemorySize(4096);
		return commonsMultipartResolve;
	}
	
	@Bean
    public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
        registration.getUrlMappings().clear();
        return registration;
    }

}
