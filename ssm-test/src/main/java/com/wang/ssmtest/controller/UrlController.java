package com.wang.ssmtest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {

	@RequestMapping("toListJsp")
	public String toListJsp() {
		return "list";
	}
	@RequestMapping("toTest")
	public String toTest() {
		return "test";
	}
	@RequestMapping("toRegister")
	public String toRegister() {
		return "register";
	}

}
