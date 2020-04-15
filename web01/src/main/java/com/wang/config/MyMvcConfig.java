package com.wang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//扩展 springmvc 配置 dispatcherServlet
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //public intetface ViewResolver 实现了视图解析器接口的类。我们
//    就可以把他看作视图解析器

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewReslover();
    }

    //定义了一个自己的视图解析器MyViewResolver
    public static class MyViewReslover implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

}
