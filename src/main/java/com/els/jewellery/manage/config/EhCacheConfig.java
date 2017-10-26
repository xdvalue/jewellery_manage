package com.els.jewellery.manage.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import net.sf.ehcache.CacheManager;

/**
 * ehcache配置
 *
 * @author portal
 * @date 2017-05-20 23:11
 */
@Configuration
@EnableCaching
public class EhCacheConfig {

	/**
	 * EhCache的配置
	 */
	@Bean
	public EhCacheCacheManager cacheManager(CacheManager cacheManager) {
		return new EhCacheCacheManager(cacheManager);
	}

	/**
	 * EhCache的配置
	 */
	@Bean
	public EhCacheManagerFactoryBean ehcache() {
		EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
		ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		return ehCacheManagerFactoryBean;
	}
}