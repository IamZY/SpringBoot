package com.ntuzy.demo.bean;

public class MyException extends RuntimeException {

	private int code;
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public MyException(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
}
