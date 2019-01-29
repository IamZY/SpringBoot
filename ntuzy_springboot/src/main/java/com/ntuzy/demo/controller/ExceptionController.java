package com.ntuzy.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ntuzy.demo.bean.JsonData;
import com.ntuzy.demo.bean.MyException;
import com.ntuzy.demo.bean.User;

@RestController
public class ExceptionController {
	@RequestMapping(value = "/api/v1/test_ext")
	public Object index() {
		
		int i = 1/0;
		
		return new User(11,"1223","1",new Date());
	}
	
	
	@RequestMapping(value = "/api/v1/test_myext")
	public Object MyExt() {
		throw new MyException(100, "aaa");
	}
	
	
}
