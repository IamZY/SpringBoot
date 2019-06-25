package com.ntuzy.test;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntuzy.dao.UserRepository;
import com.ntuzy.domain.Role;
import com.ntuzy.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ManyToManyTest {

	@Resource
	private UserRepository userRepository;

	@Test
	public void testSave() {

		User user = new User();
		user.setName("eric");
		user.setPassword("1234");

		Role role1 = new Role();
		role1.setName("超级管理员");

		Role role2 = new Role();
		role2.setName("普通管理员");

		user.getRoles().add(role1);
		user.getRoles().add(role2);
		role1.getUsers().add(user);
		role2.getUsers().add(user);

		userRepository.save(user);

	}

	@Test
	public void testFind() {
		User user = userRepository.findOne(1);

		Set<Role> roles = user.getRoles();

		System.out.println("用户" + user.getName() + "的角色为:");
		for (Role role : roles) {
			System.out.println(role.getName());
		}

	}

}
