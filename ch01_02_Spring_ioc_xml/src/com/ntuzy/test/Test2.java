package com.ntuzy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ntuzy.dao.CustomerDao;

public class Test2 {

	/**
	 * 类路径加载方式
	 */
	public static void test1() {
		// 初始化ioc容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中取出对象

		for (int i = 0; i < 5; i++) {
			CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
			System.out.println(customerDao);

		}

	}

	public static void test2() {
		// 初始化ioc容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中取出对象
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
		System.out.println(customerDao);
		// 销毁对象
		// 前提是单例模式
		((AbstractApplicationContext) ac).registerShutdownHook();

	}

	public static void main(String[] args) {
		// test1();
		test2();
	}

}
