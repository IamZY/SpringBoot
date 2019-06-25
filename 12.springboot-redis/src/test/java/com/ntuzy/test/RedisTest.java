package com.ntuzy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntuzy.domain.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

	@Resource
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	public void testSet() {
		redisTemplate.opsForValue().set("name", "张三");
	}

	@Test
	public void testGet() {
		String name = (String) redisTemplate.opsForValue().get("name");
		System.out.println(name);
	}

	@Test
	public void testSave() {
		Emp emp = new Emp();
		emp.setName("张三");
		emp.setGender("男");

		// 重新设置value序列化区
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

		redisTemplate.opsForValue().set("emp", emp);

	}

	@Test
	public void testGetEmp() {
		// 重新设置value序列化区
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

		Emp emp2 = (Emp) redisTemplate.opsForValue().get("emp");
		System.out.println(emp2);
	}

	// 以JSON格式存入JavaBean
	@Test
	public void testSetJavaBeanUserJson() {
		// 重新设置value序列化区
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Emp.class));

		Emp emp = new Emp();
		emp.setName("李四");
		emp.setGender("男");

		redisTemplate.opsForValue().set("emp_json", emp);
	}

	// 以JSON格式取出JavaBean
	@Test
	public void testGetJavaBeanUserJson() {
		// 重新设置value序列化区
		redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Emp.class));

		Emp emp = (Emp) redisTemplate.opsForValue().get("emp_json");
		System.out.println(emp);
	}

}
