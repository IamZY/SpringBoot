package com.ntuzy.demo;


import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ntuzy.demo.*"})
@ServletComponentScan
@MapperScan("com.ntuzy.demo.mapper")
public class NtuZyApplication {
	public static void main(String[] args) {
		SpringApplication.run(NtuZyApplication.class);
	}
}
