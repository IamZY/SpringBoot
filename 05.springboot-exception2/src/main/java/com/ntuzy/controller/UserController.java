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

	// java.lang.ArithmeticException
	@ExceptionHandler(value = { java.lang.ArithmeticException.class })
	public ModelAndView handlerArithmeticException(Exception e) {
		// 设置错误信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", e.toString());
		modelAndView.setViewName("error1");
		return modelAndView;
	}

	// java.lang.NullPointerException
	@ExceptionHandler(value = { java.lang.NullPointerException.class })
	public ModelAndView handlerNullPointerException(Exception e) {
		// 设置错误信息
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("exception", e.toString());
		modelAndView.setViewName("error2");
		return modelAndView;
	}

}
