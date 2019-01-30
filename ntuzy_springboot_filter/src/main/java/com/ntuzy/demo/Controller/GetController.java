package com.ntuzy.demo.Controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

	private Map<String,Object> map = new HashMap<String, Object>();
	
	
	@RequestMapping("/api/test_filter")
	public Object testFilter(HttpServletRequest request) {
		map.clear();
		String userName = request.getParameter("username");
		map.put("username", userName);
		return map;
	}
	
	@RequestMapping("/v1/test_request")
	public Object testRequest(HttpServletRequest request) {
		
		System.out.println(".....testRequest....");
		
		map.clear();
		String id = request.getParameter("id");
		map.put("username", id);
		return map;
	}
	
}
