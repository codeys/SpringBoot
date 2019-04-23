package com.example.demo.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {

	/***
	 * 配置Druid数据源
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druid() {
		return new DruidDataSource();
	}
	
	//配置Druid监控
	//1.配置一个管理后台的servlet
	@Bean
	public ServletRegistrationBean<StatViewServlet> statViewServlet() {
		ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(),"/druid/*");
		Map<String,String> initParameters = new HashMap<String, String>();
		initParameters.put("loginUsername","admin");
		initParameters.put("loginPassword","123456");
		initParameters.put("allow","");//默认就是允许所有访问
		initParameters.put("deny","192.168.15.21");
		bean.setInitParameters(initParameters);
		return bean;
	}
	
	//2.配置一个web监控的filter
	@Bean
	public FilterRegistrationBean<WebStatFilter> webStatFilter() {
		FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<WebStatFilter>();
		bean.setFilter(new WebStatFilter());
		bean.setUrlPatterns(Arrays.asList("/*"));
		Map<String,String> initParameters = new HashMap<String, String>();
		initParameters.put("exclusions","*.js,*.css,/druid/*");
		bean.setInitParameters(initParameters);
		return bean;
	}
}
