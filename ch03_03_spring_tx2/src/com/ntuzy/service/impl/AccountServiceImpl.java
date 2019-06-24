package com.ntuzy.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.ntuzy.dao.AccountDao;
import com.ntuzy.service.AccountService;

@Transactional(isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public void translate(String outName, String inName, Double money) {
		accountDao.outAccount(outName, money);
		int i = 1 / 0;
		accountDao.inAccount(inName, money);
	}

}
