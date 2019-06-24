package com.ntuzy.dao.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.ntuzy.dao.CustomerDao;

@Component(value = "customerDao") // 默认名称就是类名小写
public class CustomerDaoImpl implements CustomerDao {

	@PostConstruct
	public void init() {
		System.out.println("初始化方法.....");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("销毁方法.....");
	}

	@Override
	public void save() {
		System.out.println("保存到数据库....");
	}

}
