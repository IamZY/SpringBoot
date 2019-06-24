package com.ntuzy.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ntuzy.dao.UserDao;

@Service
public class UserService {

	@Resource
	private UserDao userDao;
	
	public void save() {
		userDao.save();
	}
	
}
