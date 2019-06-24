package com.ntuzy.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.ntuzy.dao.CustomerDao;

@Component(value = "customerDao") // Ĭ�����ƾ�������Сд
public class CustomerDaoImpl implements CustomerDao {

	@PostConstruct
	public void init() {
		System.out.println("��ʼ������.....");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("���ٷ���.....");
	}

	@Override
	public void save() {
		System.out.println("���浽���ݿ�....");
	}

}
