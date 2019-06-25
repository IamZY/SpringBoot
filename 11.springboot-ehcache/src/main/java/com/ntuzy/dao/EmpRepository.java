package com.ntuzy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import com.ntuzy.domain.Emp;

public interface EmpRepository extends JpaRepository<Emp, Integer>, JpaSpecificationExecutor<Emp> {

	/**
	 * 固定写法
	 * 
	 * @param name
	 * @return
	 */
	// 查询name(驼峰式命名)
	public List<Emp> findByName(String name);

	public List<Emp> findByNameAndGender(String name, String gender);

	public List<Emp> findByTelephoneLike(String telphone);

	@Query("from Emp where name=?")
	public List<Emp> queryName(String name);

	@Query(value = "select * from t_emp where name = ?", nativeQuery = true)
	public List<Emp> queryName2(String name);

	@Query("update Emp set address=? where id = ?")
	@Modifying
	public void updateAddressById(String address, Integer id);

}
