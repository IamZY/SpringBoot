package com.ntuzy.demo.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ntuzy.demo.bean.User;
import com.ntuzy.demo.mapper.UserMapper;
import com.ntuzy.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	
	
	@Override
	public int add(User user) {
		userMapper.insert(user);
		int id = user.getId();
		return id;
	}



	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public int addAcount() {
		
		User user = new User();
		user.setAge(11);
		user.setName("测试事务");
		user.setPhone("110");
		user.setCreateTime(new Date());
		
		userMapper.insert(user);
		
		int i = 1/0;
		
		return 0;
	}

}
