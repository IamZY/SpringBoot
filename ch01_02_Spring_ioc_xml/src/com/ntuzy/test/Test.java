package com.ntuzy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ntuzy.dao.CustomerDao;

public class Test {
	
	/**
	 * 类路径加载方式
	 */
	public static void test1() {
		// 初始化ioc容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从容器中取出对象
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
		
		System.out.println(customerDao);
	}
	
	/**
	 * 文件系统
	 */
	public static void test2() {
		// 初始化ioc容器
//		ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\src\\SpringBoot\\ch01_02_Spring_ioc_xml\\src\\applicationContext.xml");
		ApplicationContext ac = new FileSystemXmlApplicationContext("./src/applicationContext.xml");
		// 从容器中取出对象
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
		
		System.out.println(customerDao);
	}
	
	
	public static void main(String[] args) {
//		test1();
		test2();
	}
	
}
