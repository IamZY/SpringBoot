package com.ntuzy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ntuzy.dao.CustomerDao;

public class Test {
	
	/**
	 * ��·�����ط�ʽ
	 */
	public static void test1() {
		// ��ʼ��ioc����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ��������ȡ������
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
		
		System.out.println(customerDao);
	}
	
	/**
	 * �ļ�ϵͳ
	 */
	public static void test2() {
		// ��ʼ��ioc����
//		ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\src\\SpringBoot\\ch01_02_Spring_ioc_xml\\src\\applicationContext.xml");
		ApplicationContext ac = new FileSystemXmlApplicationContext("./src/applicationContext.xml");
		// ��������ȡ������
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
		
		System.out.println(customerDao);
	}
	
	
	public static void main(String[] args) {
//		test1();
		test2();
	}
	
}
