package com.ntuzy.demo.bean;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@ControllerAdvice
public class CustomExtHandler {
	
	private static final Logger Log = LoggerFactory.getLogger(CustomExtHandler.class);

	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	Object handleException(Exception e,HttpServletRequest request) {
		
		Log.error("url {},msg {}",request.getRequestURL(),e.getMessage()); 
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 100);
		map.put("msg", e.getMessage());
		map.put("url", request.getRequestURL());
		return map;
	}
	
	
	@ExceptionHandler(value=MyException.class)
	@ResponseBody
	Object handlerMyException(MyException e,HttpServletRequest request) {
		// 页面跳转
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("error.html");
//		modelAndView.addObject("msg",e.getMessage());
//		return modelAndView;
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", e.getCode());
		map.put("msg", e.getMsg());
		map.put("url", request.getRequestURL());
		return map;
		
	}
	
	
	
	
}
