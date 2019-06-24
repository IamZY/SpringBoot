package com.ntuzy.test;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ntuzy.bean.Account;

public class Test {

	public static void test1() {

		// 撞见JdbcTemplate对象
		JdbcTemplate jdbcTemplate = new JdbcTemplate();

		// 注入数据源
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:mysql:///spring");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("123456");

		jdbcTemplate.setDataSource(dataSource);

		// jdbcTemplate.update("insert into account(name,money) values(?,?)",
		// "zhangsan", 5000);
		// jdbcTemplate.update("insert into account(name,money) values(?,?)", "lisi",
		// 4000);
		// jdbcTemplate.update("update account set money=? where id=?", 6000, 1);
		// jdbcTemplate.update("delete from account where id=?", 1);

		// List<Account> list = jdbcTemplate.query("select * from account", new
		// BeanPropertyRowMapper(Account.class));
		// for (Account account : list) {
		// System.out.println(account.getName());
		// }

		Account account = (Account) jdbcTemplate.queryForObject("select * from account where id=?", new BeanPropertyRowMapper(Account.class), 2);
		System.out.println(account.getMoney());
	}

	public static void main(String[] args) {
		test1();
	}

}
