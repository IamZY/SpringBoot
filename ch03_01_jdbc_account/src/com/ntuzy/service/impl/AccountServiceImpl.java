package com.ntuzy.service.impl;

import javax.annotation.Resource;

import com.ntuzy.dao.AccountDao;
import com.ntuzy.service.AccountService;

public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}



	@Override
	public void translate(String outName, String inName, Double money) {
		accountDao.outAccount(outName, money);
		accountDao.inAccount(inName, money);
	}

}
