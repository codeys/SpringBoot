package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

import com.example.demo.component.MyLocaleResolver;


@Configuration
public class LocalResolveConfig {
	/**
	 * 国际化
	 * 
	 * @return
	 */
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
	
}
