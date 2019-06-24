package com.ntuzy.service.impl;

import org.springframework.stereotype.Service;

import com.ntuzy.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public void save() {
		System.out.println("save....");
	}

	@Override
	public void update() {
		System.out.println("update....");
	}

}
