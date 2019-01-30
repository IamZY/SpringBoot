package com.ntuzy.demo.intecpter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(new LoginInterecepter()).addPathPatterns("/v1/*/**");   //拦截全部 /**
		// 先进先出
//		registry.addInterceptor(new TwoInterecepter()).addPathPatterns("/v1/*/**");   //拦截全部 /**

//		registry.addInterceptor(new LoginInterecepter()).addPathPatterns("/v1/*/**").excludePathPatterns("");   //拦截...除了...
		
		
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	
	
	
}
