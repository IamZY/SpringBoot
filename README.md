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

## 文件上传

+ 普通文件上传

  ```JAVA
  package com.ntuzy.demo.controller;
  
  import java.awt.Image;
  import java.io.File;
  import java.io.IOException;
  import java.util.UUID;
  
  import javax.servlet.http.HttpServletRequest;
  
  import org.springframework.stereotype.Controller;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestParam;
  import org.springframework.web.bind.annotation.ResponseBody;
  import org.springframework.web.multipart.MultipartFile;
  
  import com.ntuzy.demo.bean.JsonData;
  
  @Controller
  public class FileController {
  
  	
  	@RequestMapping(value = "/index")
  	public Object index() {
  		return "index";
  	}
  	
  	
  	private static final String filePath = "D:/src/SpringBoot/ntuzy_springboot/src/main/resources/static/images/";
  	
  	
  	@RequestMapping(value="upload")
  	@ResponseBody
  	public JsonData upload(@RequestParam("head_img")MultipartFile file,HttpServletRequest request) {
  		
  		//file.isEmpty(); 判断图片是否为空
   		//file.getSize(); 图片大小进行判断
   		
   		String name = request.getParameter("name");
   		System.out.println("用户名："+name);
          
   		// 获取文件名
          String fileName = file.getOriginalFilename();	        
          System.out.println("上传的文件名为：" + fileName);
          
          // 获取文件的后缀名,比如图片的jpeg,png
          String suffixName = fileName.substring(fileName.lastIndexOf("."));
          System.out.println("上传的后缀名为：" + suffixName);
          
          // 文件上传后的路径
          fileName = UUID.randomUUID() + suffixName;
          System.out.println("转换后的名称:"+fileName);
          
          File dest = new File(filePath + fileName);
         
          try {
              file.transferTo(dest);
              return new JsonData(0, fileName);
  //            return fileName;
          } catch (IllegalStateException e) {
              e.printStackTrace();
          } catch (IOException e) {
              e.printStackTrace();
          }
  //        return  new JsonData(-1, "fail to save ", null);
  //        return "上传失败";
          
          return new JsonData(-1,"fail to save file");
  		
  	}
  	
  }
  
  ```

  

+ jar包的方式文件上传

  `@Bean`必须放在有`@SpringBootApplication`的类下

  

  ```java
  package com.ntuzy.demo.controller;
  
  import javax.servlet.MultipartConfigElement;
  
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.boot.web.servlet.MultipartConfigFactory;
  import org.springframework.context.annotation.Bean;
  
  @SpringBootApplication
  public class NtuZyApplication {
  	public static void main(String[] args) {
  		SpringApplication.run(NtuZyApplication.class);
  	}
  	
  	@Bean
  	public MultipartConfigElement multipartConfigElement() {
  		
  		MultipartConfigFactory factory = new MultipartConfigFactory();
  		// 单个文件最大
  		factory.setMaxFileSize("10240KB");
  		// 设置上传数据的总大小
  		factory.setMaxRequestSize("1024000KB");
  		
  		return factory.createMultipartConfig();
  	}
  	
  }
  
  ```

  `java -jar xxx.jar`

  导出jar包的时候需要在`pom.xml`中添加

  ```xml
  <build>
      <plugins>
          <plugin>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-maven-plugin</artifactId>
          </plugin>
      </plugins>
  </build>
  ```

## 热部署

+ Maven

  ```xml
  <dependency>  
      <groupId>org.springframework.boot</groupId>  
      <artifactId>spring-boot-devtools</artifactId>  
      <optional>true</optional>  
  </dependency>
  ```

  不监听热部署的文件

  > spring.devtools.restart.exclude=static/**,public/**

  手动触发热部署

  > spring.devtools.restart.trigger-file=trigger.txt

## 配置文件

+ YAML

  ```properties
  # application.properties示例
  server.port=8090  
  server.session-timeout=30  
  server.tomcat.max-threads=0  
  server.tomcat.uri-encoding=UTF-8 
  ```

  ```YAML
  # application.yml示例
  server:  
  	port: 8090  
      session-timeout: 30  
      tomcat.max-threads: 0  
  	tomcat.uri-encoding: UTF-8 
  ```

### 自动注入

## 单元测试

+ 代码

  ```java
  package ntuzy_springboot.demo;
  
  import org.junit.After;
  import org.junit.Before;
  import org.junit.Test;
  import org.junit.runner.RunWith;
  import org.springframework.boot.test.context.SpringBootTest;
  import org.springframework.test.context.junit4.SpringRunner;
  
  import com.ntuzy.demo.controller.NtuZyApplication;
  
  import junit.framework.TestCase;
  
  @RunWith(SpringRunner.class)
  @SpringBootTest(classes= {NtuZyApplication.class})
  public class SpringBootTestDemo {
  
  	
  	@Test
  	public void testOne() {
  		System.out.println("test hello 1");
  		TestCase.assertEquals(1, 1);
  	}
  	
  	@Test
  	public void testTwo() {
  		System.out.println("test hello 2");
  		TestCase.assertEquals(1, 1);
  	}
  	
  	 
  	
  	@Before
  	public void testBefore() {
  		System.out.println("before...");
  	}
  	
  	@After
  	public void testAfter() {
  		System.out.println("after...");
  	}
  	
  	
  	
  }
  
  
  ```

  + MockMvc

  ```java
  package ntuzy_springboot.demo;
  
  import org.junit.Test;
  import org.junit.runner.RunWith;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
  import org.springframework.boot.test.context.SpringBootTest;
  import org.springframework.test.context.junit4.SpringRunner;
  import org.springframework.test.web.servlet.MockMvc;
  import org.springframework.test.web.servlet.MvcResult;
  import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
  import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
  
  import com.ntuzy.demo.controller.NtuZyApplication;
  
  @RunWith(SpringRunner.class)
  @SpringBootTest(classes= {NtuZyApplication.class})
  @AutoConfigureMockMvc
  public class MockMvcTestDemo {
  
  	@Autowired
  	private MockMvc mockMvc;
  
  	@Test
  	public void apiTest() throws Exception {
  		
  		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
  		// 获取状态码
  		int status = mvcResult.getResponse().getStatus();
  		System.out.println(status);
  	} 
  	
  }
  
  ```

## 配置全局异常

+ 代码

  ```java
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
  		map.put("msg", e.getMessage());
  		map.put("url", request.getRequestURL());
  		return map;
  		
  	}
  	
  }
  
  ```

+ 跳转自定义异常页面

  模板引擎



























































