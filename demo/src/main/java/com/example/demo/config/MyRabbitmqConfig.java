package com.example.demo.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitmqConfig {

	@Bean
	public MessageConverter myMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
