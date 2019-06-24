package com.ntuzy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ntuzy.config.SpringConfig;
import com.ntuzy.dao.CustomerDao;
import com.ntuzy.service.CustomerService;

public class Test {

	/**
	 * 注解
	 */
	public static void test1() {
		// 初始化ioc容器
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		// 从容器中取出对象
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
		System.out.println(customerDao);
	}

	public static void test2() {
		// 初始化ioc容器
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		// 从容器中取出对象
		CustomerService customerService =  (CustomerService) ac.getBean("customerService");
		customerService.save();
	}
	
	public static void test3() {
		// 初始化ioc容器
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		// 从容器中取出对象
		CustomerDao customerDao = (CustomerDao) ac.getBean("custDao");
		System.out.println(customerDao);
	}

	public static void main(String[] args) {
//		 test1();
//		 test2();
		test3();
	}

}
