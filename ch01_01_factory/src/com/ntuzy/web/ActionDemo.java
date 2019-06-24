package com.ntuzy.web;

import com.ntuzy.dao.impl.CustomerDaoImpl;
import com.ntuzy.ioc.BeanFactory;
import com.ntuzy.service.CustomerService;
import com.ntuzy.service.impl.CustomerServiceImpl;

public class ActionDemo {

	public static void main(String[] args) {
//		CustomerService customerService = new CustomerServiceImpl();
		CustomerService customerService = (CustomerService) BeanFactory.getBean("customerService");
		customerService.save();
	}
	
}
