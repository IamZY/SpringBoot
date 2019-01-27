package com.ntuzy.demo.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntuzy.demo.bean.User;

@RestController
public class SampleController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
    
    @RequestMapping("/test")
    public Map<String,String> testMap(){
    	Map<String,String> map = new HashMap<String,String>();
    	map.put("tom", "123");
    	return map;
    }
    
    @GetMapping("/testJson")
    public Object testJson(){
    	return new User(10, "123", "1234", new Date());
    }
    
}
