package com.ntuzy.demo.controller;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ntuzy.demo.*"})
//@ServletComponentScan
public class NtuZyApplication {
	public static void main(String[] args) {
		SpringApplication.run(NtuZyApplication.class);
	}
	
	
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		
		MultipartConfigFactory factory = new MultipartConfigFactory();
		// 单个文件最大
		factory.setMaxFileSize("10240KB");
		// 设置上传数据的总大小
		factory.setMaxRequestSize("1024000KB");
		
		return factory.createMultipartConfig();
		
		
	}
	
	
	
}
