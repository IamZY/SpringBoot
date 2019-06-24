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
	 * ע��
	 */
	public static void test1() {
		// ��ʼ��ioc����
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		// ��������ȡ������
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
		System.out.println(customerDao);
	}

	public static void test2() {
		// ��ʼ��ioc����
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		// ��������ȡ������
		CustomerService customerService =  (CustomerService) ac.getBean("customerService");
		customerService.save();
	}
	
	public static void test3() {
		// ��ʼ��ioc����
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
		// ��������ȡ������
		CustomerDao customerDao = (CustomerDao) ac.getBean("custDao");
		System.out.println(customerDao);
	}

	public static void main(String[] args) {
//		 test1();
//		 test2();
		test3();
	}

}
