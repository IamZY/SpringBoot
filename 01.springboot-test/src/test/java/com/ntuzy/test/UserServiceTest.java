package com.ntuzy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntuzy.Application;
import com.ntuzy.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { Application.class })   // @SpringBoot测试类 加载SpringBoot启动器类
public class UserServiceTest {
	
	@Resource
	private UserService userService;
	
	@Test
	public void save() {
		userService.save();
	}
	
}
