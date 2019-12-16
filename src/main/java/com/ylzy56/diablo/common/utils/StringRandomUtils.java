package com.ylzy56.diablo.common.utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StringRandomUtils {

    /**
     * 生成6位随机数
     * @return
     */
    public static String getRandomNum(){
        Random random = new Random();
        String result="";
        for (int i=0;i<6;i++)
        {
            result+=random.nextInt(10);
        }
        return result;
    }
}
