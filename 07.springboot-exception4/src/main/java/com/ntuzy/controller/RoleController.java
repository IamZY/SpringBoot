package com.ntuzy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/role")
public class RoleController {

	@RequestMapping("/add")
	public String add() {
		String name = null;
		name = name.toLowerCase();
		return "list";
	}
	
}
