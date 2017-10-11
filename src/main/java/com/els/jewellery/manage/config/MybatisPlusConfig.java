package com.els.jewellery.manage.config;

import java.sql.SQLException;
import java.util.HashMap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.els.jewellery.manage.common.constant.DSEnum;
import com.els.jewellery.manage.config.properties.DruidProperties;
import com.els.jewellery.manage.config.properties.MutiDataSourceProperties;
import com.els.jewellery.manage.core.datascope.DataScopeInterceptor;
import com.els.jewellery.manage.core.mutidatesource.DynamicDataSource;

/**
 * MybatisPlus配置
 *
 * @author portal
 * @Date 2017/5/20 21:58
 */
@Configuration
@EnableTransactionManagement(order = 2) // 由于引入多数据源，所以让spring事务的aop要在多数据源切换aop的后面
@MapperScan(basePackages = { "com.els.jewellery.manage.**.dao" })
public class MybatisPlusConfig {

	@Autowired
	DruidProperties druidProperties;

	@Autowired
	MutiDataSourceProperties mutiDataSourceProperties;

	/**
	 * 账号库数据源
	 */
	private DruidDataSource accountDataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		druidProperties.config(dataSource);
		mutiDataSourceProperties.config(dataSource);
		return dataSource;
	}

	/**
	 * 数据源
	 */
	private DruidDataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		druidProperties.config(dataSource);
		return dataSource;
	}

	/**
	 * 单数据源连接池配置
	 */
	@Bean
	@ConditionalOnProperty(prefix = "custom", name = "muti-datasource-open", havingValue = "false")
	public DruidDataSource singleDatasource() {
		return dataSource();
	}

	/**
	 * 多数据源连接池配置
	 */
	@Bean
	@ConditionalOnProperty(prefix = "custom", name = "muti-datasource-open", havingValue = "true")
	public DynamicDataSource mutiDataSource() {

		DruidDataSource dataSource = dataSource();
		DruidDataSource accountDataSource = accountDataSource();

		try {
			dataSource.init();
			accountDataSource.init();
		} catch (SQLException sql) {
			sql.printStackTrace();
		}

		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		HashMap<Object, Object> hashMap = new HashMap<>();
		hashMap.put(DSEnum.DATA_SOURCE, dataSource);
		hashMap.put(DSEnum.DATASOURCE_ACCOUNT, accountDataSource);
		dynamicDataSource.setTargetDataSources(hashMap);
		dynamicDataSource.setDefaultTargetDataSource(dataSource);
		return dynamicDataSource;
	}

	/**
	 * mybatis-plus分页插件
	 */
	@Bean
	public PaginationInterceptor paginationInterceptor() {
		return new PaginationInterceptor();
	}

	/**
	 * 数据范围mybatis插件
	 */
	@Bean
	public DataScopeInterceptor dataScopeInterceptor() {
		return new DataScopeInterceptor();
	}
}
