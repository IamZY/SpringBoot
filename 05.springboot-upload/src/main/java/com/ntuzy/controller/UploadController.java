package com.ntuzy.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	Map<String, Object> result = new HashMap<String, Object>();

	/**
	 * 接受文件
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	@RequestMapping("/uploadAttach")
	public Map<String, Object> upload(@RequestParam("attach") MultipartFile file) throws IllegalStateException, IOException {

		String fileName = file.getOriginalFilename();
		String fileContentType = file.getContentType();

		// 保存到硬盘
		file.transferTo(new File("e:/" + file.getOriginalFilename()));

		result.put("success", true);
		return result;

	}

}
