package com.ylzy56.diablo.common.utils;

import java.util.Random;

/**
 * @program: simple_tools
 * @description: 随机数字符串工具类
 * @author: ChenWenLong
 * @create: 2019-06-04 16:00
 **/
public class RandomStringUtils {

    private static final Random RANDOM = new Random();

    public RandomStringUtils() {
        super();
    }

    /**
     * 功能描述:
     * 〈创建指定位数的随机数字符串,指定位数为count〉
     *
     * @params : [count]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:01
     */
    public static String random(int count) {
        return random(count, false, false);
    }

    /**
     * 功能描述:
     * 〈生产一个ASCII码表当中可显示字符的指定长度count的随机字符串〉
     *
     * @params : [count]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:02
     */
    public static String randomAscii(int count) {
        return random(count, 32, 127, false, false);
    }

    /**
     * 功能描述:
     * 〈创建一个只是由字母组成的指定长度count的字符串〉
     *
     * @params : [count]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:03
     */
    public static String randomAlphabetic(int count) {
        return random(count, true, false);
    }

    /**
     * 功能描述:
     * 〈创建一个包含字母和数字,指定长度count的字符串〉
     *
     * @params : [count]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:04
     */
    public static String randomAlphanumeric(int count) {
        return random(count, true, true);
    }

    /**
     * 功能描述:
     * 〈创建一个只是由数字组成的,指定count长度的随机数字符串〉
     *
     * @params : [count]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:05
     */
    public static String randomNumeric(int count) {
        return random(count, false, true);
    }

    /**
     * 功能描述:
     * 〈创建一个随机数字符串,count为长度,letters为是否包含字母,numbers为是否包含数字〉
     *
     * @params : [count, letters, numbers]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:07
     */
    public static String random(int count, boolean letters, boolean numbers) {
        return random(count, 0, 0, letters, numbers);
    }

    /**
     * 功能描述:
     * 〈创建一个随机数字符串,count为长度,start为开始位置,end为结束位置,letters为是否包含字母,numbers为是否包含数字〉
     *
     * @params : [count, start, end, letters, numbers]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:08
     */
    public static String random(int count, int start, int end, boolean letters, boolean numbers) {
        return random(count, start, end, letters, numbers, null, RANDOM);
    }

    /**
     * 功能描述:
     * 〈创建一个随机数字符串,count为长度,start为开始位置,end为结束位置,letters为是否包含字母,numbers为是否包含数字.
     *  chars为从这组字符当中选取字符用于组成随机数〉
     *
     * @params : [count, start, end, letters, numbers, chars]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:10
     */
    public static String random(int count, int start, int end, boolean letters, boolean numbers, char[] chars) {
        return random(count, start, end, letters, numbers, chars, RANDOM);
    }

    /**
     * 功能描述:
     * 〈创建一个随机数字符串,count为长度,start为开始位置,end为结束位置,letters为是否包含字母,numbers为是否包含数字.
     *      *  chars为从这组字符当中选取字符用于组成随机数,random可以自定义创建〉
     *
     * @params : [count, start, end, letters, numbers, chars, random]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:12
     */
    public static String random(int count, int start, int end, boolean letters, boolean numbers,
                                char[] chars, Random random) {
        if (count == 0) {
            return "";
        } else if (count < 0) {
            throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
        }
        if ((start == 0) && (end == 0)) {
            end = 'z' + 1;
            start = ' ';
            if (!letters && !numbers) {
                start = 0;
                end = Integer.MAX_VALUE;
            }
        }

        char[] buffer = new char[count];
        int gap = end - start;

        while (count-- != 0) {
            char ch;
            if (chars == null) {
                ch = (char) (random.nextInt(gap) + start);
            } else {
                ch = chars[random.nextInt(gap) + start];
            }
            if ((letters && Character.isLetter(ch))
                    || (numbers && Character.isDigit(ch))
                    || (!letters && !numbers))
            {
                if(ch >= 56320 && ch <= 57343) {
                    if(count == 0) {
                        count++;
                    } else {
                        // low surrogate, insert high surrogate after putting it in
                        buffer[count] = ch;
                        count--;
                        buffer[count] = (char) (55296 + random.nextInt(128));
                    }
                } else if(ch >= 55296 && ch <= 56191) {
                    if(count == 0) {
                        count++;
                    } else {
                        // high surrogate, insert low surrogate before putting it in
                        buffer[count] = (char) (56320 + random.nextInt(128));
                        count--;
                        buffer[count] = ch;
                    }
                } else if(ch >= 56192 && ch <= 56319) {
                    // private high surrogate, no effing clue, so skip it
                    count++;
                } else {
                    buffer[count] = ch;
                }
            } else {
                count++;
            }
        }
        return new String(buffer);
    }

    /**
     * 功能描述:
     * 〈创建一个指定长度为count的随机数字符串,字符来源从chars中获取〉
     *
     * @params : [count, chars]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:13
     */
    public static String random(int count, String chars) {
        if (chars == null) {
            return random(count, 0, 0, false, false, null, RANDOM);
        }
        return random(count, chars.toCharArray());
    }

    /**
     * 功能描述:
     * 〈创建一个指定长度为count的随机数字符串,字符来源从chars中获取〉
     *
     * @params : [count, chars]
     * @return : java.lang.String
     * @author : cwl
     * @date : 2019/6/4 16:14
     */
    public static String random(int count, char[] chars) {
        if (chars == null) {
            return random(count, 0, 0, false, false, null, RANDOM);
        }
        return random(count, 0, chars.length, false, false, chars, RANDOM);
    }
}
