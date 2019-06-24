package com.ntuzy.service.impl;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.dao.impl.CustomerDaoImpl;
import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	// 注入普通类型
	@Value("tom")
	private String name;

	// 引用properties
	@Value("${url}")
	private String url;

	// 自动根据类型自动注入 直接赋值给变量(不需要提供构造方法或者setter方法)
	// 如果Spring环境中没有任何一个CustomerDao类型 那么会 注入失败
	// @Autowired
	// @Qualifier(value="customerDao") // 指定名称注入 如果有两个以上的实现类的情况
	// private CustomerDao customerDao;

	@Resource(name = "customerDao")  // resource=autowired+qualilfier
	private CustomerDao customerDao;

	@Override
	public void save() {
		System.out.println(name);
		System.out.println(url);
		System.out.println(customerDao);
	}

}
