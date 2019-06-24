package com.ntuzy.test;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntuzy.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class Test2 {

	@Resource
	private CustomerService customerService;
	
	@org.junit.Test
	public void test1() {
		customerService.save();
		customerService.update();
	}


}
