package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;
	
	@Autowired
	private RedisTemplate<String, Object> myRedisTemplate;
	
	// 操作rabbit
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	//AmqpAdmin创建及删除Exchange,Queue,Binding
	@Autowired
	private AmqpAdmin amqpAdmin;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void redisTest() {
//		stringRedisTemplate.opsForValue().set("key1", "hello");
//		System.out.println(stringRedisTemplate.opsForValue().get("key1"));
		myRedisTemplate.opsForValue().set("emp1", "账上");
	}
	
	/***
	 * 发送消息
	 */
	@Test
	public void sendRabbitmq() {
		Map<String,Object> map = new HashMap<>();
		map.put("message", "这是一条消息！");
		map.put("body", Arrays.asList("hello",123));
		rabbitTemplate.convertAndSend("exchange.direct", "atguigu", map);
	}
	
	/***
	 * 接收消息
	 */
	@Test
	public void receiveRabbitmq() {
		Object message = rabbitTemplate.receiveAndConvert("atguigu");
		System.out.println(message);
	}

}
