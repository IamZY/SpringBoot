package com.ntuzy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.service.CustomerService;

public class Test {
	
	/**
	 * ע��
	 */
	public static void test1() {
		// ��ʼ��ioc����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ��������ȡ������
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDaoImpl");
		System.out.println(customerDao);
	}
	
	public static void test2() {
		// ��ʼ��ioc����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ��������ȡ������
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDaoImpl");
//		System.out.println(customerDao);
		((AbstractApplicationContext)ac).registerShutdownHook();
	}

	public static void test3() {
		// ��ʼ��ioc����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ��������ȡ������
		CustomerService customerService = (CustomerService) ac.getBean("customerService");
		customerService.save();
	}
	
	public static void main(String[] args) {
//		test1();
//		test2();
		test3();
	}
	
}
