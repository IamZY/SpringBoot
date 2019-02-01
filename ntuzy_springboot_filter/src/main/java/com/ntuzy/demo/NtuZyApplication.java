package com.ntuzy.demo;


import javax.servlet.MultipartConfigElement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ntuzy.demo.*"})
@ServletComponentScan
@MapperScan("com.ntuzy.demo.mapper")
@EnableScheduling //开启定时任务
@EnableAsync      // 开启异步任务
public class NtuZyApplication {
	public static void main(String[] args) {
		SpringApplication.run(NtuZyApplication.class);
	}
}
