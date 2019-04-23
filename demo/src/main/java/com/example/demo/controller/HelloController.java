package com.example.demo.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
 
	@RequestMapping("/hello")
	public String hello(Map<String,Object> map) {
		map.put("hello","world");
		map.put("users", Arrays.asList("zhangsan","lisi","wanger"));
		return "hello";
	}
	
}
