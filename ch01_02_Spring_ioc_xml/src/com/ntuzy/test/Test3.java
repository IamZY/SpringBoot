package com.ntuzy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.service.CustomerService;

public class Test3 {

	public static void test1() {
		// 初始化ioc容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中取出对象
		CustomerService customerService = (CustomerService) ac.getBean("customerService");
		System.out.println(customerService);

	}

	public static void main(String[] args) {
		test1();
	}

}
