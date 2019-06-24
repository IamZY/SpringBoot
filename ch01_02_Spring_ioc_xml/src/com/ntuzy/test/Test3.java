package com.ntuzy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.service.CustomerService;

public class Test3 {

	public static void test1() {
		// ��ʼ��ioc����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ��������ȡ������
		CustomerService customerService = (CustomerService) ac.getBean("customerService");
		System.out.println(customerService);

	}

	public static void main(String[] args) {
		test1();
	}

}
