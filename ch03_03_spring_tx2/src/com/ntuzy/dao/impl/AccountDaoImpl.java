package com.ntuzy.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ntuzy.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

	// ×¢ÈëJDBCÄ£°å
	private JdbcTemplate temp;

	public void setTemp(JdbcTemplate temp) {
		this.temp = temp;
	}

	@Override
	public void outAccount(String name, Double money) {
		temp.update("update account set money = money - ? where name = ? ",money,name);
	}

	@Override
	public void inAccount(String name, Double money) {
		temp.update("update account set money = money + ? where name = ? ",money,name);
	}

}
