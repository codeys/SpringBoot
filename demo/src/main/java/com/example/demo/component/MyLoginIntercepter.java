package com.example.demo.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class MyLoginIntercepter implements HandlerInterceptor {
	private static final String[] IGNORE_URL = {};
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object user = request.getSession().getAttribute("user");
		//String url = request.getRequestURL().toString();
		if(user==null) {
			request.setAttribute("message", "未登录");
			request.getRequestDispatcher("/index.html").forward(request, response);
			return false;
		}else {
			return true;
		}
		
	}
}
