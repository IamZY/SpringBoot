package com.ntuzy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntuzy.domain.Emp;
import com.ntuzy.service.EmpService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmpServiceTest {

	@Resource
	private EmpService empService;

	@Test
	public void testFindById() {
		// 第一次查询
		System.out.println(empService.findById(1));
		// 第二次查询
		System.out.println(empService.findById(1));
	}

	@Test
	public void testFindByPage() {
		// 查询第一次
		Pageable pageable = new PageRequest(0, 2);
		System.out.println(empService.findByPage(pageable).getTotalElements());

		// 查询第二次
		System.out.println(empService.findByPage(pageable).getTotalElements());

		// 换页
		pageable = new PageRequest(1, 2);
		System.out.println(empService.findByPage(pageable).getTotalElements());

	}
	
	
	@Test
	public void testFindAll() {
		// 第一次查询
		System.out.println(empService.findAll().size());
		
		// 添加
		Emp emp = new Emp();
		emp.setName("陈留");
		empService.save(emp);
		
		// 第二次查询
		System.out.println(empService.findAll().size());
	}

}
