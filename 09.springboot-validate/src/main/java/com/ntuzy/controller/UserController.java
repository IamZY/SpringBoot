package com.ntuzy.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ntuzydomain.User;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/toAdd")
	public String toAdd(User user) {
		return "add";
	}
	
	@RequestMapping("add")
	public String add(@Valid User user,BindingResult result) {
		// 如果存在
		if (result.hasErrors()) {
			// 返回add.html
			return "add";
		}
		
		
		System.out.println("保存用户信息....");
		
		return "succ";
		
	}
	

}
