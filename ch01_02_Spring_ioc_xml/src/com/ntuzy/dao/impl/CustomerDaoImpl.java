package com.ntuzy.dao.impl;

import com.ntuzy.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao {

	public void init() {
		System.out.println("��ʼ������.....");
	}

	public void destroy() {
		System.out.println("���ٷ���.....");
	}

	@Override
	public void save() {
		System.out.println("���浽���ݿ�....");
	}

}
