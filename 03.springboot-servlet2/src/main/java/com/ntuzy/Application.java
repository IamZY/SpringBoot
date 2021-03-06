package com.ntuzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.ntuzy.servlet.HelloFilter;
import com.ntuzy.servlet.HelloListener;
import com.ntuzy.servlet.HelloServlet;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// 注册Servlet程序
	@Bean
	public ServletRegistrationBean getServletRegistrationBean() {
		ServletRegistrationBean bean = new ServletRegistrationBean(new HelloServlet());
		bean.addUrlMappings("/helloServlet");
		return bean;
	}

	// 注册Filter
	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		FilterRegistrationBean bean = new FilterRegistrationBean(new HelloFilter());
		// 过滤器拦截路径
		bean.addUrlPatterns("/helloServlet");
		return bean;
	}

	// 注册Listener
	@Bean
	public ServletListenerRegistrationBean<HelloListener> getServletListenerRegistrationBean() {
		ServletListenerRegistrationBean<HelloListener> bean = new ServletListenerRegistrationBean<HelloListener>(
				new HelloListener());
		return bean;
	}

}
