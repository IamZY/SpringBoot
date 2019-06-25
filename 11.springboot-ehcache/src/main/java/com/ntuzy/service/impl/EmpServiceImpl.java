package com.ntuzy.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ntuzy.dao.EmpRepository;
import com.ntuzy.domain.Emp;
import com.ntuzy.service.EmpService;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {

	@Resource
	private EmpRepository empRepository;

	@Override
	@Cacheable(value = "emp") // value 指的是缓存配置的名称
	public List<Emp> findAll() {
		return empRepository.findAll();
	}

	@Override
	@Cacheable(value = "emp") // value 指的是缓存配置的名称
	public Emp findById(Integer id) {
		return empRepository.findOne(id);
	}

	@Override
	@Cacheable(value = "emp") // value 指的是缓存配置的名称 key 指定缓存的名称
	public Page<Emp> findByPage(Pageable pageable) {
		return empRepository.findAll(pageable);
	}

	@Override
	@CacheEvict(value = "emp", allEntries = true) // 把数据从缓存中清除
	public void save(Emp emp) {
		empRepository.save(emp);
	}

}
