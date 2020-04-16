package com.wang.config;

import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        //获取请求的语言参数
        String language = httpServletRequest.getParameter("l");

        Locale locale = Locale.getDefault();
        if (language != null && language.length()>0){
            //zh_CN
            String[] split = language.split("_");
            //国际、地区
            locale = new Locale(split[0],split[1]);
            System.out.println("【国际化语言：】"+ language);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
