package com.ntuzy.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ntuzy.demo.bean.ServerSettings;

@Controller
@RequestMapping("/freemark")
public class FreeMarkController {

	@Autowired
	private ServerSettings setting;
	
	@GetMapping("hello")
	public String index(ModelMap modelMap) {
		
		modelMap.addAttribute("setting",setting);
		
		return "fm/index";
	}
	
	
}
