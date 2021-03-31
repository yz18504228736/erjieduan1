package com.canguanwang.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间转换工具类
 * @author ghy
 * @version 1.0
 */
public class DateUtils {

    /**
     * 时间转字符串
     * @param date
     * @param pattern 要转换的格式
     * @return
     */
    public static String dateToStr(Date date, String pattern){
        return new SimpleDateFormat(pattern).format(date);
    }


    /**
     * 字符串转时间
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date strToDate(String dateStr, String pattern){
        try {
            return new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
