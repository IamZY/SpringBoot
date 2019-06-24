package com.ntuzy.test;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.ntuzy.dao.EmpRepository;
import com.ntuzy.domain.Emp;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EmpRepositoryTest {

	@Resource
	private EmpRepository empRepository;

	@Test
	public void testSave() {
		Emp emp = new Emp();
		emp.setName("王五");
		emp.setGender("女");
		emp.setTelephone("333333333");
		emp.setAddress("南京");
		// empRepository.save(emp);
	}

	@Test
	public void testFindByName() {
		List<Emp> findByName = empRepository.findByName("张三");
		for (Emp e : findByName) {
			System.out.println(e.getName());
		}
	}

	@Test
	public void testfindByNameAndGender() {
		List<Emp> findByName = empRepository.findByNameAndGender("张三", "男");
		for (Emp e : findByName) {
			System.out.println(e.getName());
		}
	}

	@Test
	public void testFindByTelephoneLike() {
		List<Emp> findByName = empRepository.findByTelephoneLike("%1%");
		for (Emp e : findByName) {
			System.out.println(e.getName());
		}
	}

	@Test
	public void testQueryName() {
		List<Emp> findByName = empRepository.queryName("张三");
		for (Emp e : findByName) {
			System.out.println(e.getTelephone());
		}
	}

	@Test
	public void testQueryName2() {
		List<Emp> findByName = empRepository.queryName2("张三");
		for (Emp e : findByName) {
			System.out.println(e.getTelephone());
		}
	}

	@Test
	@Transactional // 事务与test一起使用的时候 事务会自动回滚
	@Rollback(false) // 取消自动回滚
	public void testUpdateAddressById() {
		empRepository.updateAddressById("北京", 2);
	}

	@Test
	public void save() {
		Emp emp = new Emp();
		emp.setName("王五66");
		emp.setGender("女");
		emp.setTelephone("444444444");
		emp.setAddress("南京");

		empRepository.save(emp);
	}

	// 修改
	@Test
	public void testUpdate() {
		Emp emp = new Emp();
		emp.setId(4);
		emp.setName("王五6666");
		emp.setGender("女");
		emp.setTelephone("1346666677777");
		emp.setAddress("广州白云");

		empRepository.save(emp);
	}

	// 查询所有数据
	@Test
	public void testFindAll() {
		// 强制转换
		List<Emp> list = (List<Emp>) empRepository.findAll();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

	// 查询一个对象
	@Test
	public void testFineOne() {
		// 强制转换
		Emp emp = empRepository.findOne(4);
		System.out.println(emp);
	}

	// 删除一个对象
	@Test
	public void testDelete() {
		empRepository.delete(4);
	}

	@Test
	public void testSort() {
		// 封装排序条件的对象
		Sort sort = new Sort(new Order(Direction.DESC, "id"));

		Iterable<Emp> list = empRepository.findAll(sort);
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}

	@Test
	public void testPageable() {
		// Pageable：用于封装分页参数 。 当前页码和查询记录数（注意：当前页码从0开始的）
		Sort sort = new Sort(new Order(Direction.DESC, "id"));

		Pageable pageable = new PageRequest(0, 2, sort);
		// 封装排序条件的对象
		// Page: 用于封装分页查询后的结果
		Page<Emp> pageData = empRepository.findAll(pageable);

		System.out.println("总记录数：" + pageData.getTotalElements());
		List<Emp> content = pageData.getContent();
		for (Emp emp : content) {
			System.out.println(emp);
		}
		System.out.println("总页数：" + pageData.getTotalPages());

	}

}
