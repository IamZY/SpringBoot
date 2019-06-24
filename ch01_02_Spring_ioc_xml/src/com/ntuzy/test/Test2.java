package com.ntuzy.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ntuzy.dao.CustomerDao;

public class Test2 {

	/**
	 * ��·�����ط�ʽ
	 */
	public static void test1() {
		// ��ʼ��ioc����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ��������ȡ������

		for (int i = 0; i < 5; i++) {
			CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
			System.out.println(customerDao);

		}

	}

	public static void test2() {
		// ��ʼ��ioc����
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		// ��������ȡ������
		CustomerDao customerDao = (CustomerDao) ac.getBean("customerDao");
		System.out.println(customerDao);
		// ���ٶ���
		// ǰ���ǵ���ģʽ
		((AbstractApplicationContext) ac).registerShutdownHook();

	}

	public static void main(String[] args) {
		// test1();
		test2();
	}

}
