package com.ntuzy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ntuzy.dao.AccountMapper;
import com.ntuzy.domain.Account;
import com.ntuzy.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountMapper accountMapper;

	@Override
	public void save(Account account) {
		if (account.getId() == null) {
			accountMapper.save(account);
		} else {
			update(account);
		}
	}

	@Override
	public List<Account> findAll() {
		return accountMapper.findAll();
	}

	@Override
	public Account findById(Integer id) {
		return accountMapper.findById(id);
	}

	@Override
	public void update(Account account) {
		accountMapper.update(account);
	}

	@Override
	public void delete(Integer id) {
		accountMapper.delete(id);
	}

}
