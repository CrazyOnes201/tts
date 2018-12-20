package com.dbsd6th.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * *****************************************
 * **        Author : CrazyWalker         **
 * *****************************************
 * *****************************************
 * ** Date: 星期四, 12/20 2018 11:14 UTC  **
 * *****************************************
 * *****************************************
 * **     用途:  时间类操作工具类         **
 * *****************************************
 */
public class DateUtil {

    /**
     * 转换前端传来的字符串日期数据为Date类
     * @author CrazyWalker
     * @param formDate 需要处理的字符串日期数据
     * @return 转换后的Date类，若处理失败则返回null
     */
    public static Date transFormDateToDate(String formDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date result = null;
        try {
            result = simpleDateFormat.parse(formDate);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return result;
    }
}
