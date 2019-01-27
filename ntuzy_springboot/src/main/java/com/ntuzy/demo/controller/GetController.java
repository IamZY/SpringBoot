package com.ntuzy.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ntuzy.demo.bean.User;

@RestController
public class GetController {
	
	private Map<String,Object> params = new HashMap<String,Object>();
	
	
	@RequestMapping(path = "/{city_id}/{user_id}",method = RequestMethod.GET)
	public Object findUser(@PathVariable("city_id")String cityId,@PathVariable("user_id")String userId) {
		params.clear();
		
		params.put("cityId", cityId);
		params.put("userId", userId);
		
		System.out.println(params);
		
		return params;
	}
	
//	@RequestMapping("/pageUser/{size}/{from}")
	@GetMapping(value="/v1/page_user1")
	public Object pageUser(int from,int size) {
		params.clear();
		params.put("from", from);
		params.put("size", size);
		
		System.out.println(params);
		
		return params;
	}
	
	
	@GetMapping(value="/v1/page_user2")
	public Object pageUserV2(@RequestParam(defaultValue="0",name="page")int from,int size) {
		params.clear();
		params.put("from", from);
		params.put("size", size);
		
		System.out.println(params);
		
		return params;
	}
	
	
	@RequestMapping("v1/save_user")
	public Object saveUser(@RequestBody User user) {
		params.clear();
		params.put("user", user);
		return params;
	}
	
	
	@RequestMapping("v1/save_user")
	public Object getHeader(@RequestHeader("access_token") String token,String id) {
		params.clear();
		params.put("access_token", token);
		params.put("id", id);
		return params;
	}
	
	@RequestMapping("v1/test_request")
	public Object getRequest(HttpServletRequest request) {
		params.clear();
		String id = request.getParameter("id");
		params.put("id", id);
		return params;
	}
	
	
	
}
