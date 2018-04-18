package com.tool.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author xielbs
 * @create 2018-04-18 9:37
 * @desc 日期处理工具类
 **/
public class CalendarUtils {
	/**
	 * 标准 时间格式
	 */
	public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 年月日 时间格式
	 */
	public static final String yyyyMMdd = "yyyy-MM-dd";

	/**
	 * 年月 时间格式
	 */
	public static final String yyyyMM = "yyyy-MM";

	/**
	 * 字符串时间按指定格式转换成Calendar
	 * @param sTime  字符串时间
	 * @param pattern 指定格式(默认:yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static Calendar strTimeToCalendar(String sTime, String pattern) {
		if(sTime == null || "".equals(sTime)){
			return null;
		}
		if (pattern == null || "".equals(pattern)) {
			pattern = yyyyMMddHHmmss;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = new Date();
		try {
			date = sdf.parse(sTime);
		} catch (java.text.ParseException ex) {
			return null;
		}
		Calendar cRt = Calendar.getInstance();
		cRt.setTime(date);
		return cRt;
	}

	/**
	 * Date转换成Calendar
	 * @param date Date格式时间
	 * @return
	 */
	public static Calendar dateToCalendar(Date date) {
		Calendar cRt = Calendar.getInstance();
		cRt.setTime(date);
		return cRt;
	}

	/**
	 * Calendar转换成Date
	 * @param cal Calendar格式时间
	 * @return
	 */
	public static Date dateToCalendar(Calendar cal) {
		return cal.getTime();
	}

	/**
	 * 字符串时间转换成Date
	 * @param sTime 字符串时间
	 * @param pattern 指定格式(默认:yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static Date strTimeToDate(String sTime, String pattern) {
		if(sTime == null || "".equals(sTime)){
			return null;
		}
		if (pattern == null || "".equals(pattern)) {
			pattern = yyyyMMddHHmmss;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = new Date();
		try {
			date = sdf.parse(sTime);
		} catch (ParseException ex) {
			return null;
		}
		return date;
	}

	/**
	 * 时间戳转换成指定格式的字符串时间
	 * @param str 时间戳
	 * @param pattern 格式(默认:yyyy-MM-dd HH:mm:ss)
	 * @return
	 */
	public static String stampToStrTime(String str, String pattern){
		if (str == null || "".equals(str)) {
			return "";
		}
		if (pattern == null || "".equals(pattern)) {
			pattern = yyyyMMddHHmmss;
		}
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		long lt = new Long(str);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/**
	 * 字符串时间转换成时间戳
	 * @param sTime 字符串时间
	 * @return
	 */
	public static String strTimeToStamp(String sTime) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(yyyyMMddHHmmss);
		Date date = new Date();
		try {
			date = simpleDateFormat.parse(sTime);
		}catch (ParseException ex){
			return null;
		}
		long ts = date.getTime();
		String res = String.valueOf(ts);
		return res;
	}

	/**
	 * 字符串时间转换成数据库日期类型
	 * @param strTime 字符串时间
	 * @return
	 * @throws Exception
	 */
	public static java.sql.Date toSqlDate(String strTime) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat(yyyyMMddHHmmss);
		Date Date = null;
		try {
			Date = df.parse(strTime);
		} catch (Exception e) {
			throw new Exception("日期转换出错!");
		}
		return new java.sql.Date(Date.getTime());
	}

	/**
	 * 清除时间的时分秒毫秒
	 * @param time Calendar时间
	 * @return
	 */
	public static void clearHMSCalendar(Calendar time) {
		if (time == null)
			return;
		cleanCalendar(time, Calendar.DAY_OF_MONTH);
	}

	/***
	 * 清除时间中时分秒， 根据参数设置年/月/日的开始时间
	 * 例如：参数为Calendar.DAY_OF_MONTH，将设置日期为此天零点；
	 * 		 参数为Calendar.MONTH 将设置日期为此月第一天零点；
	 * 		 参数为Calendar.YEAR，将设置日期为此年份1月1日零点
	 * @param timetag Calendar时间
	 * @param cycleType 类型
	 */
	public static void cleanCalendar(Calendar timetag, int cycleType) {
		switch (cycleType) {
			case Calendar.HOUR_OF_DAY:
				break;
			case Calendar.DAY_OF_MONTH:
				timetag.set(Calendar.HOUR_OF_DAY, 0);
				break;
			case Calendar.MONTH:
				timetag.set(Calendar.DAY_OF_MONTH, 1);
				timetag.set(Calendar.HOUR_OF_DAY, 0);
				break;
			case Calendar.YEAR:
				timetag.set(Calendar.MONTH, 1);
				timetag.set(Calendar.DAY_OF_MONTH, 1);
				timetag.set(Calendar.HOUR_OF_DAY, 0);
				break;
		}
		timetag.set(Calendar.MINUTE, 0);
		timetag.set(Calendar.SECOND, 0);
		timetag.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * 计算两个时间的差值
	 * @param time1 Calendar时间
	 * @param time2 Calendar时间
	 * @param field 计算类型(例如:Calendar.SECOND)
	 * @return
	 */
	public static int compareTime(Calendar time1, Calendar time2, int field) {
		int ret = 0;
		switch (field) {
			case Calendar.YEAR:
				ret = time1.get(Calendar.YEAR) - time2.get(Calendar.YEAR);
				break;
			case Calendar.MONTH:
				while (time1.get(Calendar.YEAR) > time2.get(Calendar.YEAR)) {
					time2.add(time1.get(Calendar.YEAR), 1);
					ret += 12;
				}
				ret -= time2.get(Calendar.MONTH);
				ret += time1.get(Calendar.MONTH);
				break;
			case Calendar.DAY_OF_MONTH:
				ret = (int) ((time1.getTimeInMillis() - time2.getTimeInMillis()) / (24 * 60 * 60 * 1000));
				break;
			case Calendar.HOUR_OF_DAY:
				ret = (int) ((time1.getTimeInMillis() - time2.getTimeInMillis()) / (60 * 60 * 1000));
				break;
			case Calendar.MINUTE:
				ret = (int) ((time1.getTimeInMillis() - time2.getTimeInMillis()) / (60 * 1000));
				break;
			case Calendar.SECOND:
				ret = (int) ((time1.getTimeInMillis() - time2.getTimeInMillis()) / (1000));
				break;
		}
		return ret;
	}

	/**
	 * 获取某日期，当天传入0，前一天传入-1，后一天传1依次类推
	 * @param days 距离当前时间的天数
	 * @return
	 */
	public static String getDateString(int days) {
		Calendar today = Calendar.getInstance();
		today.add(Calendar.DAY_OF_MONTH, days);
		return FormatUtils.formatCalendar(today, CalendarUtils.yyyyMMdd);
	}

	/**
	 * 获取某月1号，当月传入0，前一月传入-1，后一月传1依次类推
	 * @param mons 距离当前时间的月数
	 * @return
	 */
	public static String getMonString(int mons) {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.DAY_OF_MONTH, 1);
		today.add(Calendar.MONTH, mons);
		return FormatUtils.formatCalendar(today, CalendarUtils.yyyyMMdd);
	}

	/**
	 * 获取某年某月有多少天
	 * @param year 年份
	 * @param month 月份
	 * @return
	 */
	public int getDayOfMonth(int year,int month){
		Calendar c = Calendar.getInstance();
		c.set(year, month, 0); //输入类型为int类型
		return c.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 获取年份
	 * @param cal Calendar时间
	 * @return
	 */
	public static String getYear(Calendar cal) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		return cal.get(Calendar.YEAR) + "";
	}

	/**
	 * 获取月份
	 * @param cal Calendar时间
	 * @return
	 */
	public static String getMonth(Calendar cal) {
		if (cal == null) {
			cal = Calendar.getInstance();
		}
		return (cal.get(Calendar.MONTH) + 1) + "";
	}

	/**
	 * 判断字符串时间是否合法
	 * @param sTime 字符串时间
	 * @return
	 */
	public static boolean isValidTime(String sTime) {
		int spaceIndex = sTime.indexOf(" ");
		if (spaceIndex == -1) {
			return false;
		}
		String date = sTime.substring(0, spaceIndex);
		String hms = sTime.substring(spaceIndex + 1, sTime.length());
		if (!isValidDate(date)) {
			return false;
		}
		int first = hms.indexOf(':');
		int second = hms.lastIndexOf(':');
		if (first == second) {
			// System.out.println("您输入的日期缺少\":\"符号");
			return false;
		}
		String hh = hms.substring(0, first);
		String mm = hms.substring(first + 1, second);
		String ss = hms.substring(second + 1, hms.length());
		if (isNumber(hh) == false || isNumber(mm) == false
				|| isNumber(ss) == false) {
			// System.out.println("您输入的日期包含不可用字符");
			return false;
		}
		int h = Integer.parseInt(hh);
		int m = Integer.parseInt(mm);
		int s = Integer.parseInt(ss);
		if (h < 0 || h > 23) {
			return false;
		}
		if (m < 0 || m >= 60) {
			return false;
		}
		if (s < 0 || s >= 60) {
			return false;
		}
		return true;
	}

	/**
	 * 判断字符串日期是否合法
	 * @param sDate 字符串日期
	 * @return
	 */
	public static boolean isValidDate(String sDate) {
		int first = sDate.indexOf('-');
		int second = sDate.lastIndexOf('-');

		if (first == second) {
			// System.out.println("您输入的日期缺少\"-\"符号");
			return false;
		} else {
			String year = sDate.substring(0, first);
			String month = sDate.substring(first + 1, second);
			String day = sDate.substring(second + 1, sDate.length());
			int maxDays = 31;
			if (isNumber(year) == false || isNumber(month) == false
					|| isNumber(day) == false) {
				// System.out.println("您输入的日期包含不可用字符");
				return false;
			} else if (year.length() < 4) {
				// System.out.println("您输入的年份少于四位");
				return false;
			}
			int y = Integer.parseInt(year);
			int m = Integer.parseInt(month);
			int d = Integer.parseInt(day);
			if (m > 12 || m < 1) {
				// System.out.println("您输入的月份不在规定范围内");
				return false;
			} else if (m == 4 || m == 6 || m == 9 || m == 11) {
				maxDays = 30;
			} else if (m == 2) {
				if (y % 4 > 0)
					maxDays = 28;
				else if (y % 100 == 0 && y % 400 > 0)
					maxDays = 28;
				else
					maxDays = 29;
			}
			if (d < 1 || d > maxDays) {
				// System.out.println("您输入的日期不在规定范围内");
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否全为数字
	 * @param num 字符串
	 * @return
	 */
	private static boolean isNumber(String num) {
		return num.matches("[0-9]+");
	}


}
