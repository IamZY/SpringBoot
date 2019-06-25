package com.ntuzy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ntuzy.domain.Emp;

public interface EmpService {

	public List<Emp> findAll();

	public Emp findById(Integer id);

	public Page<Emp> findByPage(Pageable pageable);

	public void save(Emp emp);

}
