package com.ntuzy.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ntuzy.demo.bean.JsonData;

@Controller
@PropertySource({"classpath:application.properties"})
public class FileController {

	
	@RequestMapping(value = "/index")
	public Object index() {
		
		// 使用这个方式需要引用thymeleaf
		return "index";
	}
	
	
//	private static final String filePath = "D:/src/SpringBoot/ntuzy_springboot/src/main/resources/static/images/";
//	private static final String filePath = "C:/Users/IamZY/Desktop";
	@Value("${web.file.path}")
	private String filePath;
	
	
	@RequestMapping(value="upload")
	@ResponseBody
	public JsonData upload(@RequestParam("head_img")MultipartFile file,HttpServletRequest request) {
		
		//file.isEmpty(); 判断图片是否为空
 		//file.getSize(); 图片大小进行判断
 		
		System.out.println("注入的文件路径:" + filePath);
		
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
