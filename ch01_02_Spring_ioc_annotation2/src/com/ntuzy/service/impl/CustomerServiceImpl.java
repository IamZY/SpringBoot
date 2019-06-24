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
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.dao.impl.CustomerDaoImpl;
import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

	// 引用properties
	@Value("${url}")
	private String url;

	@Override
	public void save() {
		System.out.println(url);
	}

	@Bean(name = "custDao")
	public CustomerDao getDao() {
		System.out.println("执行 我们的方法....");
		return new CustomerDaoImpl();
	}

}
