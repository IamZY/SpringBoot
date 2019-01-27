# SpringBoot

## 注解

+ 获取参数(Get)

  ```java
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
  
  ```

+ 获取参数(post)

  ```java
  package com.ntuzy.demo.controller;
  
  
  import java.util.HashMap;
  import java.util.Map;
  
  import org.springframework.web.bind.annotation.DeleteMapping;
  import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.PutMapping;
  import org.springframework.web.bind.annotation.RestController;
  
  @RestController
  public class OtherHttpController {
  
  	private Map<String, Object> params = new HashMap<String,Object>();
  	
  	
  	@PostMapping("v1/login")
  	public Object login(String id,String pwd) {
  		params.clear();
  		params.put("id", id);
  		params.put("pwd", pwd);
  		
  		return params;
  	}
  	
  	
  	@PutMapping("v1/put")
  	public Object put(String id,String pwd) {
  		params.clear();
  		params.put("id", id);
  		params.put("pwd", pwd);
  		
  		return params;
  	}
  	
  	
  	@DeleteMapping("v1/del")
  	public Object del(String id,String pwd) {
  		params.clear();
  		params.put("id", id);
  		params.put("pwd", pwd);
  		
  		return params;
  	}
  	
  	
  }
  
  ```

## Json

+ 实例

  ```JAVA
  package com.ntuzy.demo.bean;
  
  import java.util.Date;
  
  import com.fasterxml.jackson.annotation.JsonFormat;
  import com.fasterxml.jackson.annotation.JsonIgnore;
  import com.fasterxml.jackson.annotation.JsonInclude;
  import com.fasterxml.jackson.annotation.JsonProperty;
  
  public class User {
  
  	// 可以为空
  //	@JsonInclude(Include.NOT_NULL)
  	private int age;
  	// 返回前台 忽视此字段
  	@JsonIgnore
  	private String pwd;
  	// 设置别名
  	@JsonProperty("account")
  	private String phone;
  	// 时间格式化
  	@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale = "zh",timezone="GMT+8")
  	private Date createTime;
  	
  	public Date getCreateTime() {
  		return createTime;
  	}
  	public void setCreateTime(Date createTime) {
  		this.createTime = createTime;
  	}
  	public int getAge() {
  		return age;
  	}
  	public void setAge(int age) {
  		this.age = age;
  	}
  	public String getPwd() {
  		return pwd;
  	}
  	public void setPwd(String pwd) {
  		this.pwd = pwd;
  	}
  	public String getPhone() {
  		return phone;
  	}
  	public void setPhone(String phone) {
  		this.phone = phone;
  	}
  	public User() {
  		super();
  		// TODO Auto-generated constructor stub
  	}
  	public User(int age, String pwd, String phone, Date createTime) {
  		super();
  		this.age = age;
  		this.pwd = pwd;
  		this.phone = phone;
  		this.createTime = createTime;
  	}
  	
  }
  
  ```

## 静态资源文件

+ 默认配置

  同个文件的加载顺序,静态资源文件
  Spring Boot 默认会挨个从` META/resources > resources > static > public ` 里面找是否存在相应的资源，如果有则直接返回。

+ 自定义配置

  `spring.resources.static-locations = classpath:/META-INF/resources/,classpath:/resources/,classpath:/static/,classpath:/public/ `