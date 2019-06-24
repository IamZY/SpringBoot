package com.ntuzy.service.impl;

import com.ntuzy.dao.CustomerDao;
import com.ntuzy.dao.impl.CustomerDaoImpl;
import com.ntuzy.ioc.BeanFactory;
import com.ntuzy.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	// ��ͳ��ʽ �����̫��
	private CustomerDao customerDao = (CustomerDao) BeanFactory.getBean("customerDao");
	
	
	@Override
	public void save() {
		customerDao.save();
	}
	
	
}
