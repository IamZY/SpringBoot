package com.ntuzy.domain;

public class Customer {
	
	private String username;
	private Integer age;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Customer [username=" + username + ", age=" + age + "]";
	}
	
	
	
	
	
}
