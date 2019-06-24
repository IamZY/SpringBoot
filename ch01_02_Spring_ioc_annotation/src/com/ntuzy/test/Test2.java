package com.ntuzy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntuzy.dao.CustomerDao;

/**
 * ÕûºÏJunit
 * 
 * @author iamzy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test2 {

	@Resource
	private CustomerDao customerDao;
	
	@Test
	public void test1() {
		System.out.println(customerDao);
	}

}
