package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.demo.component.MyLoginIntercepter;

/***
 * 扩展SpringMVC配置
 * 
 * @author yushuai
 *
 *         2019年4月19日
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/index.html").setViewName("login");
	}

	/**
	 * 拦截器
	 */
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new MyLoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html",
//				"/static/**");
//	}
	
	//开启路径后缀匹配
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		configurer.setUseSuffixPatternMatch(true);
	}

}
