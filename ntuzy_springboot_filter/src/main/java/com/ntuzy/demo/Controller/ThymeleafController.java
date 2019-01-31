package com.ntuzy.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntuzy.demo.bean.ServerSettings;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

	@Autowired
	private ServerSettings serverSettings;
	
	
	@GetMapping("hello")
	public String hello() {
		return "index";
	}
	
	@GetMapping("info")
	public String info(ModelMap modelMap) {
		
		modelMap.addAttribute("settings",serverSettings);
		
		return "admin/info";
	}
	
	
}
