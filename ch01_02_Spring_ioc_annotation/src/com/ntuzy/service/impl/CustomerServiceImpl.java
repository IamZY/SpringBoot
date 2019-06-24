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

	// ע����ͨ����
	@Value("tom")
	private String name;

	// ����properties
	@Value("${url}")
	private String url;

	// �Զ����������Զ�ע�� ֱ�Ӹ�ֵ������(����Ҫ�ṩ���췽������setter����)
	// ���Spring������û���κ�һ��CustomerDao���� ��ô�� ע��ʧ��
	// @Autowired
	// @Qualifier(value="customerDao") // ָ������ע�� ������������ϵ�ʵ��������
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
