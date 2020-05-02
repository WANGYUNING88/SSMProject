package com.forrest.websocket.controller;

import com.alibaba.fastjson.JSONObject;
import com.forrest.websocket.common.Common;
import com.forrest.websocket.util.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;


@Controller
public class FileUploadController {

	private final ResourceLoader resourceLoader;

	@Autowired
	public FileUploadController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}
	/**
	 * 
	 * @param file 要上传的文件
	 * @param map
	 * @param response
	 * @throws InterruptedException
	 * @throws FileNotFoundException 
	 */
	@RequestMapping("fileUpload")
	public void upload(@RequestParam("fileName") MultipartFile file, 
			Map<String, Object> map,
			HttpServletResponse response) throws InterruptedException, FileNotFoundException { 
		//上传成功或者失败的标志
		boolean flag = false;
		if (file==null){
			return;
		}
		String[] names = file.getOriginalFilename().split("/|\\\\");
		String filename = names[names.length-1];
		if (FileUtils.upload(file,Common.getUploadPath(),filename)) {
			// 上传成功，给出页面提示
			
		//	map = readImage(file.getOriginalFilename(),map);
			flag = true;

		} else {

		}

		// 显示图片
		map.put("flag",flag);
		map.put("fileName", filename);
		PrintWriter out = null;
		try {
			response.reset();
			response.setContentType("text/html;charset=utf-8");
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JSONObject json = new JSONObject(map);
			if(out!=null) {
	        	out.print(json);
	        	out.flush();
	        	out.close();
	        }
		}
	}


	/**
	 * 显示单张图片
	 * 
	 * @return
	 */
	@RequestMapping("show")
	@ResponseBody
	public ResponseEntity showPhotos(String fileName) {
		System.out.println("显示图片");
		ResponseEntity responseEntity;
		try {
			// 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
			responseEntity = 
			ResponseEntity.ok(resourceLoader.getResource("file:" + Common.getUploadPath() + fileName));
			if(responseEntity!=null)
				System.out.println("****显示图片成功****");
			else
				System.out.println("****显示图片失败****");
				
		} catch (Exception e) {
			System.out.println("****显示图片出错****");
			return ResponseEntity.notFound().build();
		}
		return responseEntity;
	}

}
