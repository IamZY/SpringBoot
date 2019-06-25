package com.ntuzy.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisConfig {

	/**
	 * 1.创建JedisPoolConfig对象：连接池参数
	 * @return
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisPoolConfig getJedisPoolConfig(){
		JedisPoolConfig poolConfig = new JedisPoolConfig();
	
//		//最大空闲数
//		poolConfig.setMaxIdle(5);
//		poolConfig.setMinIdle(3);
//		//最大连接数
//		poolConfig.setMaxTotal(10);
		
		
		return poolConfig;
	}
	
	/**
	 * 2.创建JedisConnectionFactory: 配置redis连接参数
	 */
	@Bean 
	@ConfigurationProperties(prefix="spring.redis")
	public JedisConnectionFactory getJedisConnectionFactory(JedisPoolConfig poolConfig){
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		
		//关联
		connectionFactory.setPoolConfig(poolConfig);
		
//		//redis主机地址
//		connectionFactory.setHostName("localhost");
//		//redis端口
//		connectionFactory.setPort(6379);
//		//redis数据库索引
//		connectionFactory.setDatabase(1);
		
		return connectionFactory;
	}
	
	/**
	 * 3.创建RedisTemplate： 用于执行redis的操作方法
	 */
	@Bean
	public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory connectionFactory){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();

		//关联connectionFactory
		redisTemplate.setConnectionFactory(connectionFactory);
		
		//设置key序列化
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		//设置value序列化
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		
		return redisTemplate;
	}
	
	
	
}
