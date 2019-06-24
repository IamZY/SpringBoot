package com.ntuzy.dao.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ntuzy.dao.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {

	// ×¢ÈëJDBCÄ£°å
	@Resource(name="jdbcTemplate")
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
