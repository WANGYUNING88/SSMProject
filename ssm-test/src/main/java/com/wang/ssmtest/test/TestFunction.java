package com.wang.ssmtest.test;

import com.wang.ssmtest.utils.DateUtil;
import com.wang.ssmtest.utils.PasswordUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestFunction {
    @Test
    public void run1() {
        char s1 = 'a';
        char s2 = 'b';
        int q = 102;
        int i = s1 ^ s2 ^ s2;
        String w = "";
        w += (char) q;
        System.out.println(w);
    }

    @Test
    public void run3() {
        String s = "wangyuning";
        String encrypt = PasswordUtils.encrypt(s);
        System.out.println(encrypt);
        String dencrypt = PasswordUtils.dencrypt("EwQIBgwZGg0LAQ==");
        System.out.println(dencrypt);
    }

    @Test
    public void run2() {
        String sw = "http://localhost:8080/ssmtest_war_exploded/code?timestamp=";
        String s = "1231312312";
        System.out.println(sw.length());
        sw += s;
        System.out.println(sw.substring(sw.indexOf("=") + 1));
    }

    @Test
    public void run4() {
        String s = "default";
        byte[] bytes = s.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
    }

    @Test
    public void run5() throws InterruptedException, ParseException {
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s2 = "2020-01-13 11:01:01";
        Date date2 = format2.parse(s2);
        System.out.println(getTime(date2));
    }
    public String getTime(Date date){
        Calendar c1 = Calendar.getInstance();   //当前日期
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);   //设置为另一个时间

        int year = c1.get(Calendar.YEAR);
        int oldYear = c2.get(Calendar.YEAR);
        DateFormat format2 = new SimpleDateFormat("yyyyMMdd");
        String time = format2.format(date);
        if((year - oldYear)!=0){
            return time;
        }
        int month = c1.get(Calendar.MONTH);
        int oldmonth = c2.get(Calendar.MONTH);
        if((month-oldmonth)!=0){
            return time;
        }
        int day = c1.get(Calendar.DAY_OF_MONTH);
        int oldDay = c2.get(Calendar.DAY_OF_MONTH);
        if((day-oldDay)!=0){
            return day-oldDay+" days ago";
        }
        int hour = c1.get(Calendar.HOUR_OF_DAY);
        int oldHour = c2.get(Calendar.HOUR_OF_DAY);
        if((hour-oldHour)!=0){
            return hour-oldHour+" hours age";
        }
        int minute = c1.get(Calendar.MINUTE);
        int oldMinute = c2.get(Calendar.MINUTE);
        if((minute-oldMinute)!=0){
            return minute-oldMinute+" minutes ago";
        }
        return "just now";
    }
    @Test
    public void run12(){

        /*new Timestamp()

        System.out.println(date);*/
    }

}
