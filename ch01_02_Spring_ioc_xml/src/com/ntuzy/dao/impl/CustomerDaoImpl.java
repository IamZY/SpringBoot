package com.ntuzy.dao.impl;

import com.ntuzy.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {

	public void init() {
		System.out.println("初始化方法.....");
	}

	public void destroy() {
		System.out.println("销毁方法.....");
	}

	@Override
	public void save() {
		System.out.println("保存到数据库....");
	}

}
