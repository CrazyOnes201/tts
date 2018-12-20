package com.dbsd6th.util;

/**
 * *****************************************
 * **        Author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * ** Date: 星期四, 12/20 2018 11:07 UTC  **
 * *****************************************
 * *****************************************
 * **       用途:  字符串工具类           **
 * *****************************************
 */
public class StringUtil {

    /**
     * 判断字符串是否为无效值（null或空值）
     * @author CrazyWalker
     * @param var 需要进行判断的字符串
     * @return 若为空则返回true 否则返回false
     */
    public static boolean isEmpty(String var) {
        if(var == null || "".equals(var)) {
            return true;
        } else {
            return false;
        }
    }
}
