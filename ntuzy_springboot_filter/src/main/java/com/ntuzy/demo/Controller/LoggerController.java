package com.ntuzy.demo.Controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntuzy.demo.bean.JsonData;


@RestController
@RequestMapping("/api/log")
public class LoggerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@GetMapping("log")
	public Object testLog() {
		logger.debug("this is debug");
		logger.info("this is info");
		logger.warn("this is warn");
		logger.error("this is error");
		
		return JsonData.buildSuccess();
	}
	
	
	
	
	
	
	
}
