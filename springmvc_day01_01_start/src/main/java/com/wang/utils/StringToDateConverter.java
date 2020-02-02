package com.wang.utils;

import org.springframework.core.convert.converter.Converter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 把字符串转换成日期
 */
public class StringToDateConverter implements Converter<String, Date> {
    /**
     * String source
     * 传入进来的字符串
     * @param source
     * @return
     */
    @Override
    public Date convert(String source) {
        //判断
        if(source == null){
            throw new RuntimeException("请您传入数据");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //把日期转换成字符串
            return dateFormat.parse(source);
        } catch (Exception e) {
            throw new RuntimeException("数据类型转化出错");
        }
    }
}
