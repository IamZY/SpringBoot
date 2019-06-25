package com.ntuzy.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ntuzy.dao.EmpRepository;
import com.ntuzy.domain.Dept;
import com.ntuzy.domain.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OneToManyTest {

	@Resource
	private EmpRepository empRepository;
	
	@Test
	public void testsave() {
		
		Dept dept = new Dept();
		dept.setDeptName("秘书部");

		Emp emp = new Emp();
		emp.setName("小红");
		
		dept.getEmps().add(emp);
		emp.setDept(dept);
		
		empRepository.save(emp);
		
	}
	
	
	@Test
	public void testFind() {
		Emp emp = empRepository.findOne(5);
		
		Dept dept = emp.getDept();
		
		System.out.println("员工" + emp.getName() + ",部门" + dept.getDeptName());
		
	}
	
	
	
	
}
