package com.els.jewellery.manage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.els.jewellery.manage.config.properties.CustomProperties;

/**
 * SpringBoot方式启动类
 *
 * @author portal
 * @Date 2017/5/21 12:06
 */
@SpringBootApplication
public class MainApp extends WebMvcConfigurerAdapter {

	protected final static Logger logger = LoggerFactory.getLogger(MainApp.class);

	@Autowired
	CustomProperties customProperties;

	/**
	 * 增加swagger的支持
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		try {
			if (customProperties.getSwaggerOpen()) {
				registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
				registry.addResourceHandler("/webjars/**")
						.addResourceLocations("classpath:/META-INF/resources/webjars/");
			}
		} catch (Exception e) {
			logger.error("加载swagger-ui出错", e);
		}
	}

	public static void main(String[] args) {
		try {
			SpringApplication.run(MainApp.class, args);
			logger.info("后台管理系统启动成功");
		} catch (Exception e) {
			logger.error("后台管理系统启动失败", e);
		}
	}

}
