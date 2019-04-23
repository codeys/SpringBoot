package com.example.demo.config;

import java.util.Arrays;

import javax.servlet.Filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import com.example.demo.filter.MyFilter;
import com.example.demo.listener.MyListener;
import com.example.demo.servlet.MyServlet;

@Configuration
public class MyServletConfig {
	/**
	 * 注册Servlet
	 */
//	@Bean
//	public ServletRegistrationBean<MyServlet> myServlet() {
//		ServletRegistrationBean<MyServlet> registrationBean = new ServletRegistrationBean<MyServlet>(new MyServlet(),"/myServlet");
//	    return registrationBean;
//	}
//	
	/**
	 *注册Filter 
	 */
	@Bean
	public FilterRegistrationBean<MyFilter> myFilter(){
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<MyFilter>();
		registrationBean.setFilter(new MyFilter());
		registrationBean.setUrlPatterns(Arrays.asList("/hello","/myServlet"));
		return registrationBean;
	}
	
	/**
	 * 注册Listener
	 */
	@Bean
	public ServletListenerRegistrationBean<MyListener> myListener(){
		ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<MyListener>(new MyListener());
		return registrationBean;
	}
	
	/***
	 * 设置设置匹配*.do后缀请求
	 * @param dispatcherServlet
	 * @return
	 */
//	@Bean
//	public ServletRegistrationBean myDispatchServlet(DispatcherServlet dispatcherServlet) {
//		ServletRegistrationBean registrationBean = new ServletRegistrationBean(dispatcherServlet);
//		registrationBean.addUrlMappings("*.do");
//		return registrationBean;
//	}
}
