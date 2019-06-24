package com.ntuzy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntuzy.config.SpringConfig;
import com.ntuzy.service.CustomerService;

/**
 * ¡„≈‰÷√’˚∫œJunit
 * 
 * @author iamzy
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
public class Test2 {

	@Resource
	private CustomerService customerService;
	
	@Test
	public void test() {
		customerService.save();
	}

}
