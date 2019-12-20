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

    /**
     * 方式二： 设定时间戳，倒计时
     */
    public static long getTime(long time) {
        while (time > 0) {
            time--;
            //long hh = time / 60 / 60 % 60;
            //long mm = time / 60 % 60;
            long ss = time % 60;
            System.out.println(/*"还剩" + hh + "小时" + mm + "分钟" + */ss + "秒");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return time;
    }

}
