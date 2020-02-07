package com.wang.ssmtest.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.ssmtest.bean.Msg;
import com.wang.ssmtest.utils.CodeUtil;
import com.wang.ssmtest.utils.IpUtils;

@Controller
public class CodeController {
	@RequestMapping("/code")
	public void getCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Map<String, Object> map = CodeUtil.generateCodeAndPic(true);
		System.out.println("验证码的值为：" + map.get("code"));
		session.setAttribute("code", map.get("code").toString());
		// 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);
        response.setContentType("image/jpeg");
		ServletOutputStream outputStream = response.getOutputStream();
		ImageIO.write((RenderedImage) map.get("codePic"), "jpeg", outputStream);
		outputStream.close();
	}
	
	@RequestMapping("/isCode")
	@ResponseBody
	public Msg isCode(HttpServletRequest request,@RequestParam(value = "code", defaultValue = "defaultValue") String code) {
		System.out.println(IpUtils.getIpAddress(request));
		if("defaultValue".equals(code)) {
			return Msg.fail().add("result", "验证失败！");
		}
		String codeOne = request.getSession().getAttribute("code").toString();
		code = code.toUpperCase();
		System.out.println("处理后code为【"+code+"】");
		return Msg.success().add("result", code.equals(codeOne));
	}
}
