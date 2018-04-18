package com.tool.utils;

import java.math.BigDecimal;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author xielbs
 * @create 2018-04-18 9:37
 * @desc 格式化工具类
 **/
public class FormatUtils {

    /**
     * 固定格式 格式化双精度数字(会四舍五入)
     * @param source Double数据
     * @return
     */
    public static Double formatDouble(Double source) {
        if (source == null)
            return null;
        DecimalFormat df = new DecimalFormat("0.0000");
        return new Double(df.format(source));
    }

    /**
     * 固定格式 格式化大数字(会四舍五入)
     * @param source BigDecimal数据
     * @return
     */
    public static BigDecimal formatBigDecimal(BigDecimal source) {
        if (source == null)
            return null;
        DecimalFormat df = new DecimalFormat("0.0000");
        return new BigDecimal(df.format(source));
    }

    /**
     * 按指定格式 格式化数字(会四舍五入)
     * @param source Number数据
     * @param pattern 指定格式(例如:0.00)
     * @return
     */
    public static Number formatData(Number source, String pattern) {
        if (source == null)
            return null;
        if (pattern != null || !"".equals(pattern)) {
            NumberFormat df = new DecimalFormat(pattern);
            String value = df.format(source);
            return new BigDecimal(value);
        }
        return source;
    }


    /**
     * 按指定格式格式 格式化对象(会四舍五入)
     * @param source 数据
     * @param pattern 指定格式(例如:0.00)
     * @return
     */
    public static Object formatData(Object source, String pattern) {
        if(source == null || "".equals(source)){
            return "";
        }
        if(!(source instanceof Number)){
            return source;
        }
        if(pattern != null && !"".equals(pattern)) {
            NumberFormat df = new DecimalFormat(pattern);
            df.setGroupingUsed(false);
            return df.format((Number) source);
        }
        return source;
    }

    /**
     * 按指定格式 格式化大数字(国际化)(会四舍五入)
     * @param source Number数据
     * @param pattern 指定格式(例如:0.00)
     * @param locale Locale标准
     * @return
     */
    public static String formatLocalNumber(Number source, String pattern, Locale locale) {
        if (source != null) {
            NumberFormat df = null;
            if (locale != null) {
                DecimalFormatSymbols symbols = new DecimalFormatSymbols(locale);
                df = new DecimalFormat(pattern, symbols);
            } else {
                df = new DecimalFormat(pattern);
            }
            df.setGroupingUsed(false);
            String value = df.format(source);
            return value;
        }
        return "";
    }

    /**
     * 按指定格式 格式化时间
     * @param date Calendar时间
     * @param pattern 指定格式(例如:yyyy-MM-dd HH:mm:ss)
     * @return
     */
    public static String formatCalendar(Calendar date, String pattern) {
        if (date == null){
            return "";
        }
        if (pattern != null || !"".equals(pattern)){
            DateFormat df = new SimpleDateFormat(pattern);
            return df.format(date.getTime());
        }
        return "";
    }

    /**
     * 按指定格式 格式化时间
     * @param date 时间
     * @param pattern 指定格式(例如:yyyy-MM-dd HH:mm:ss)
     * @return
     */
    public static String formatDate(Object date, String pattern) {
        if (date == null || "".equals(date)){
            return "";
        }
        if(!(date instanceof Date)){
            return date.toString();
        }
        if(pattern != null && !"".equals(pattern)){
            DateFormat df = new SimpleDateFormat(pattern);
            return df.format(((Date) date).getTime());
        }
        return date.toString();
    }









}
