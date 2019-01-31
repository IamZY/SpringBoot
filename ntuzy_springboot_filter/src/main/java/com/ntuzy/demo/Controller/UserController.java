package com.ntuzy.demo.Controller;

import static org.mockito.Mockito.lenient;

import java.util.Date;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ntuzy.demo.bean.JsonData;
import com.ntuzy.demo.bean.User;
import com.ntuzy.demo.mapper.UserMapper;
import com.ntuzy.demo.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserMapper userMapper;
	
	@GetMapping("add")
	@ResponseBody
	public Object add() {
		User user = new User();
		user.setAge(11);
		user.setName("tom");
		user.setPhone("110");
		user.setCreateTime(new Date());
		
		int id = userService.add(user);
		
		return new JsonData().buildSuccess(id);
	}
	
	
	@GetMapping("getAll")
	@ResponseBody
	public Object getAll() {
		return new JsonData().buildSuccess(userMapper.getAll());
	}
	
	@GetMapping("addAccount")
	@ResponseBody
	public Object addAccount() {
		
		int id = userService.addAcount();
		
		return new JsonData().buildSuccess(id);
	}
	
	
}
