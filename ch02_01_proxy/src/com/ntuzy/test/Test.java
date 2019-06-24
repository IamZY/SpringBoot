package com.ntuzy.test;

import com.ntuzy.proxy.CglibProxyUtils;
import com.ntuzy.proxy.JDKProxyUtils;
import com.ntuzy.service.CustomerService;
import com.ntuzy.service.impl.CustomerServiceImpl;
import com.ntuzy.service.impl.CustomerServiceImpl2;

public class Test {

	public static void test1() {
		CustomerService customerService = new CustomerServiceImpl();
		CustomerService proxy = (CustomerService) JDKProxyUtils.getProxy(customerService);
		proxy.save();
		proxy.update();
	}

	public static void test2() {
		CustomerServiceImpl2 customerService = new CustomerServiceImpl2();
		CustomerServiceImpl2 proxy = (CustomerServiceImpl2) CglibProxyUtils.getProxy(customerService);
		proxy.save();
		proxy.update();
	}

	public static void main(String[] args) {
//		test1();
		test2();
	}

}
