package com.wang.ssmtest.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static String getLongByDate(Date date){
        return date.getTime()+"";
    }
    public static Date getDateByString(String date,String forma) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(forma);
        return f.parse(date);
    }
    public static String getStringByDate(Date date,String forma) throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat(forma);
        return f.format(date);
    }
    public static String getTimeDifference(Date date) throws ParseException {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date);   //设置为另一个时间

        int year = c1.get(Calendar.YEAR);
        int oldYear = c2.get(Calendar.YEAR);
        String time = getStringByDate(date,"yyyy-MM-dd");
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

}
