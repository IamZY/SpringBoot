package com.ntuzy.dao;

import java.util.List;

import com.ntuzy.domain.Account;

public interface AccountMapper {
	
	public void save(Account account);
	public List<Account> findAll();
	public Account findById(Integer id);
	public void update(Account account);
	public void delete(Integer id);
}
