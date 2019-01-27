package com.ntuzy.demo.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

// 可以为空
//	@JsonInclude(Include.NOT_NULL)
	private int age;
	// 返回前台 忽视此字段
	@JsonIgnore
	private String pwd;
	// 设置别名
	@JsonProperty("account")
	private String phone;
	// 时间格式化
	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale = "zh",timezone="GMT+8")
	private Date createTime;
	
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int age, String pwd, String phone, Date createTime) {
		super();
		this.age = age;
		this.pwd = pwd;
		this.phone = phone;
		this.createTime = createTime;
	}
	
}
