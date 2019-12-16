package com.ylzy56.diablo.common.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

public class StringTimeUtils {

    /**
     * (ForExample)当前时间：2019-07-01 20:51:05
     * @return
     */
    public static String getTimeStr(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(date);
    }

    public static String getTimeString(){
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        return sf.format(date);
    }

}
