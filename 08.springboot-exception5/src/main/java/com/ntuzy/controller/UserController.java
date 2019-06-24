package com.ntuzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/list")
	public String list() {
		System.out.println("run list4444....");
		return "list";
	}

	@RequestMapping("/add")
	public String add() {
		int i = 1 / 0;
		return "list";
	}

	@RequestMapping("/update")
	public String update() {
		String name = null;
		name = name.toLowerCase();
		return "list";
	}

	

}
