package com.ntuzy.dao;

public interface AccountDao {

	/**
	 * 
	 * @param name
	 * @param money
	 */
	public void outAccount(String name,Double money);
	/**
	 * 
	 * @param name
	 * @param money
	 */
	public void inAccount(String name,Double money);
	
	
}
