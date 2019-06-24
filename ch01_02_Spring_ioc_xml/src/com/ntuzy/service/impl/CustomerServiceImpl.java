package com.ntuzy.service.impl;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.dao.impl.CustomerDaoImpl;
import com.ntuzy.domain.Customer;
import com.ntuzy.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao customerDao;

	// 使用SpringIOC 容器的依赖注入
	// 构造方法的参数注入
	public CustomerServiceImpl(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	public CustomerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	// setter 方法注入
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void save() {
		customerDao.save();
	}

	private String Sex;

	public void setSex(String sex) {
		Sex = sex;
	}

	private Customer customer;

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	private String[] Address;

	public void setAddress(String[] address) {
		Address = address;
	}

	private ArrayList<Customer> customerList;

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	private Map<String, Customer> customerMap;

	public void setCustomerMap(Map<String, Customer> customerMap) {
		this.customerMap = customerMap;
	}

	private Properties customerProperties;

	public void setCustomerProperties(Properties customerProperties) {
		this.customerProperties = customerProperties;
	}

	@Override
	public String toString() {
		return "CustomerServiceImpl [Sex=" + Sex + ", customer=" + customer + ", Address=" + Arrays.toString(Address)
				+ ", customerList=" + customerList + ", customerMap=" + customerMap + ", customerProperties="
				+ customerProperties + "]";
	}

}
