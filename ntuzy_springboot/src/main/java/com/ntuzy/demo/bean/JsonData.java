package com.ntuzy.demo.bean;

import java.io.Serializable;

public class JsonData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// 状态码
	private int code;
	// 结果
	private Object data;
	
	private String msg;
	
	
	
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public JsonData(int code, Object data) {
		super();
		this.code = code;
		this.data = data;
	}
	public JsonData(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	
}
