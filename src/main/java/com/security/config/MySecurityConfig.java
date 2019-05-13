package com.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	/**
	 * 定制授权规则
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		http.authorizeRequests().antMatchers("/").permitAll()
			.antMatchers("/level1/**").hasRole("VIP1")
			.antMatchers("/level2/**").hasRole("VIP2")
			.antMatchers("/level3/**").hasRole("VIP3");
		
		//开启自动配置登录功能
		http.formLogin();
		
		//开启自动配置注销功能；
		http.logout().logoutSuccessUrl("/");
	}
	
	
	/**
	 *定制认证规则 
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123456")).roles("VIP1","VIP2")
			.and().withUser("lisi").password("123456").roles("VIP2","VIP3");
	}

}
