package com.wang.ssmtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {

	@RequestMapping("toListJsp")
	public String toListJsp() {
		System.out.println("��ת��listҳ��");
		return "list";
	}
	
}
