package com.ntuzy.controller;

import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController // =Controller+ResponseBody
public class HelloController {
	
	private Map<String, Object>  result = new HashMap<>();
	
	@RequestMapping("/hello")
	@ResponseBody
	public Map<String, Object> hello() {
		result.put("name", "tom");
		result.put("gender", "男");
		return result;
	}
	
	
}
