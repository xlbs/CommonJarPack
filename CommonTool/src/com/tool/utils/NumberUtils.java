package com.tool.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * @author xielbs
 * @create 2018-04-18 9:37
 * @desc 数字处理工具类
 **/
public class NumberUtils {

	/**
	 * 数字相加
	 * @param first 第一个数字
	 * @param second 第二个数字
	 * @return
	 */
	public static Number add(Number first, Number second) {
		if (first == null) {
			return second;
		} else if (second == null) {
			return first;
		}
		return FormatUtils.formatDouble(first.doubleValue() + second.doubleValue());
	}

	/**
	 * 小数相加
	 * @param first 第一个小数
	 * @param second 第二个小数
	 * @return
	 */
	public static Double add(Double first, Double second) {
		if (first == null) {
			return second;
		} else if (second == null) {
			return first;
		}
		return FormatUtils.formatDouble(first + second);
	}
	
	/**
	 * 整数相加
	 * @param first 第一个整数
	 * @param second 第二个整数
	 * @return
	 */
	public static Integer add(Integer first, Integer second) {
		if (first == null) {
			return second.intValue();
		} else if (second == null) {
			return first.intValue();
		}
		return first + second;
	}

	/**
	 * 对象相加
	 * @param first 第一个数
	 * @param second 第二个数
	 * @return
	 */
	public static Object add(Object first, Object second) {
		if (first == null || "".equals(first)) {
			return second;
		} else if (second == null || "".equals(second)) {
			return first;
		}
		return FormatUtils.formatDouble(Double.valueOf(first.toString()) + Double.valueOf(second.toString()));
	}

	/**
	 * 数字减法
	 * @param first 第一个数字
	 * @param second 第二个数字
	 * @return
	 */
	public static Number reduce(Number first, Number second) {
		if (first == null && second == null) {
			return null;
		} else if (first != null && second == null) {
			return first.doubleValue();
		} else if (first == null && second != null) {
			return -second.doubleValue();
		}
		return FormatUtils.formatDouble(first.doubleValue() - second.doubleValue());
	}

	/**
	 * 小数相减
	 * @param first 第一个小数
	 * @param second 第二个小数
	 * @return
	 */
	public static Double reduce(Double first, Double second) {
		if (first == null && second == null) {
			return null;
		} else if (first != null && second == null) {
			return first;
		} else if (first == null && second != null) {
			return -second;
		}
		return FormatUtils.formatDouble(first - second);
	}

	/**
	 * 整数相减
	 * @param first 第一个整数
	 * @param second 第二个整数
	 * @return
	 */
	public static Integer reduce(Integer first, Integer second) {
		if (first == null && second == null) {
			return null;
		} else if (first != null && second == null) {
			return first.intValue();
		} else if (first == null && second != null) {
			return -second.intValue();
		}
		return first - second;
	}

	/**
	 * 对象减法
	 * @param first 第一个数
	 * @param second 第二个数
	 * @return
	 */
	public static Object reduce(Object first, Object second) {
		if (first == null || second == null || "".equals(first) || "".equals(second)) {
			return null;
		}
		return FormatUtils.formatDouble(Double.valueOf(first.toString()) - Double.valueOf(second.toString()));
	}

	/**
	 * 数字乘法
	 * @param first 第一个数字
	 * @param second 第二个数字
	 * @return
	 */
	public static Number multiply(Number first, Number second) {
		if (first == null || second == null) {
			return null;
		}
		return FormatUtils.formatDouble(first.doubleValue() * second.doubleValue());
	}

	/**
	 * 小数乘法
	 * @param first 第一个小数
	 * @param second 第二个小数
	 * @return
	 */
	public static Double multiply(Double first, Double second) {
		if (first == null || second == null) {
			return null;
		}
		return FormatUtils.formatDouble(first * second);
	}

	/**
	 * 整数乘法
	 * @param first 第一个整数
	 * @param second 第二个整数
	 * @return
	 */
	public static Integer multiply(Integer first, Integer second) {
		if (first == null || second == null) {
			return null;
		}
		return first * second;
	}

	/**
	 * 对象乘法
	 * @param first 第一个数
	 * @param second 第二个数
	 * @return
	 */
	public static Object multiply(Object first, Object second) {
		if (first == null || second == null || "".equals(first) || "".equals(second)) {
			return null;
		}
		return FormatUtils.formatDouble(Double.valueOf(first.toString()) * Double.valueOf(second.toString()));
	}

	/**
	 * 数字除法
	 * @param first 第一个数字
	 * @param second 第二个数字
	 * @return
	 */
	public static Number divide(Number first, Number second) {
		if (first == null || second == null || second.doubleValue() == 0) {
			return null;
		}
		try{
			return FormatUtils.formatDouble(first.doubleValue() / second.doubleValue());
		}catch (Exception e) {
			return null;
		}
	}

	/**
	 * 小数除法
	 * @param first 第一个小数
	 * @param second 第二个小数
	 * @return
	 */
	public static Double divide(Double first, Double second) {
		if (first == null || second == null || second.doubleValue() == 0) {
			return null;
		}
		try{
			return FormatUtils.formatDouble(first.doubleValue() / second.doubleValue());
		}catch (Exception e) {
			return null;
		}
	}

	/**
	 * 整数除法
	 * @param first 第一个整数
	 * @param second 第二个整数
	 * @return
	 */
	public static Double divide(Integer first, Integer second) {
		if (first == null || second == null || second.doubleValue() == 0) {
			return null;
		}
		try{
			return FormatUtils.formatDouble(first.doubleValue() / second.doubleValue());
		}catch (Exception e) {
			return null;
		}
	}

	/**
	 * 对象除法
	 * @param first 第一个数
	 * @param second 第二个数
	 * @return
	 */
	public static Object divide(Object first, Object second) {
		if (first == null || second == null || "0".equals(second.toString()) || "".equals(first) || "".equals(second)) {
			return null;
		}
		try{
			return FormatUtils.formatDouble(Double.valueOf(first.toString()) / Double.valueOf(second.toString()));
		}catch (Exception e) {
			return null;
		}
	}

	/**
	 * 计算百分比
	 * @param first 被除数
	 * @param second 除数
	 * @param defaultVal 默认值
	 * @return
	 */
	public static Double getPercentage(Double first, Double second, Double defaultVal){
		if(first == null || second == null || second == 0d){
			return defaultVal;
		}
		return Double.parseDouble(FormatUtils.formatData((first*100+0d)/second, "0.00").toString());
	}

	/**
	 * 获取数组最大值
	 * @param values 数组
	 * @return
	 */
	public static Object getMax(Object[] values) {
		Double max = null;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null)
				continue;
			max = getMaxOrMin(true, max, Double.valueOf(values[i].toString()));
		}
		return max;
	}

	/**
	 * 获取数组最小值
	 * @param values 数组
	 * @return
	 */
	public static Object getMin(Object[] values) {
		Double min = null;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null)
				continue;
			min = getMaxOrMin(false, min, Double.valueOf(values[i].toString()));
		}
		return min;
	}

	/**
	 * 获取数组最大最小值
	 * @param values 数组
	 * @return Double数组(第一个为最大值，第二个为最小值)
	 */
	public static Double[] getMaxMin(Object[] values) {
		Double[] bRt = new Double[2];
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null)
				continue;
			bRt[0] = getMaxOrMin(true, bRt[0], Double.valueOf(values[i].toString()));
			bRt[1] = getMaxOrMin(false, bRt[1], Double.valueOf(values[i].toString()));
		}
		return bRt;
	}

	/**
	 * 获取数组最大最小平均值
	 * @param values 数组
	 * @return Double数组(第一个为最大值，第二个为最小值，第三个为平均值)
	 */
	public static Double[] getMaxMinAvg(Object[] values) {
		Double[] bRt = new Double[3];
		int count = 0;
		for (int i = 0; i < values.length; i++) {
			if (values[i] == null)
				continue;
			bRt[0] = getMaxOrMin(true, bRt[0], Double.valueOf(values[i].toString()));
			bRt[1] = getMaxOrMin(false, bRt[1], Double.valueOf(values[i].toString()));
			if (values[i] != null) {
				count++;
				bRt[2] = add(bRt[2], Double.valueOf(values[i].toString()));
			}
		}
		bRt[2] = divide(bRt[2], new Double(count));
		return bRt;
	}

	/**
	 * 获取list中最大值
	 * @param al List集合
	 * @return
	 */
	public static Object getMax(ArrayList<Double> al) {
		Double max = null;
		for (int i = 0; i < al.size(); i++) {
			Double obj = (Double) al.get(i);
			max = getMaxOrMin(true, max, obj);
		}
		return max;
	}

	/**
	 * 获取list中最小值
	 * @param al List集合
	 * @return
	 */
	public static Object getMin(ArrayList<Double> al) {
		Double min = null;
		for (int i = 0; i < al.size(); i++) {
			Double obj = (Double) al.get(i);
			min = getMaxOrMin(false, min, obj);
		}
		return min;
	}

	/**
	 * 获取list中最大最小值
	 * @param al List集合
	 * @return ArrayList<Double>(第一个最大值，第二个最小值)
	 */
	public static ArrayList<Double> getMaxMin(ArrayList<Double> al) {
		ArrayList<Double> arr = new ArrayList<Double>();
		Double max = null;
		Double min = null;
		for (int i = 0; i < al.size(); i++) {
			Double obj = (Double) al.get(i);
			max = getMaxOrMin(true, max, obj);
			min = getMaxOrMin(false, min, obj);
		}
		arr.add(max);
		arr.add(min);
		return arr;
	}

	/**
	 * 获取list中最大最小平均值
	 * @param al List集合
	 * @return ArrayList<Double>(第一个最大值，第二个最小值，第三个平均值)
	 */
	public static ArrayList<Double> getMaxMinAge(ArrayList<Double> al) {
		ArrayList<Double> arr = new ArrayList<Double>();
		Double max = null;
		Double min = null;
		Double avg = null;
		for (int i = 0; i < al.size(); i++) {
			Double obj = (Double) al.get(i);
			max = getMaxOrMin(true, max, obj);
			min = getMaxOrMin(false, min, obj);
			avg = (Double) add(avg, obj);
		}
		arr.add(max);
		arr.add(min);
		arr.add(divide(avg, Double.valueOf(al.size())));
		return arr;
	}

	/**
	 * 获取最大或者最小值
	 * @param isMax 是否取最大值
	 * @param value1 数据1
	 * @param value2 数据2
	 * @return
	 */
	public static Double getMaxOrMin(boolean isMax, Double value1, Double value2) {
		if (value1 == null) {
			return FormatUtils.formatDouble(value2);
		} else if (value2 == null) {
			return FormatUtils.formatDouble(value1);
		} else {
			if (isMax) {
				return FormatUtils.formatDouble(Double.valueOf(Math.max(value1.doubleValue(), value2.doubleValue())));
			} else {
				return FormatUtils.formatDouble(Double.valueOf(Math.min(value1.doubleValue(), value2.doubleValue())));
			}
		}
	}

	/**
	 * 将字节转换成整型
	 * @param value
	 * @return
	 */
	public static int byteToInt(byte value) {
		if (value < 0) {
			return value + 256;
		}
		return value;
	}

	/**
	 * 将char型数据转成字节数组
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(char value) {
		byte[] bt = new byte[2];
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (value >>> (i * 8));
		}
		return bt;
	}

	/**
	 * 将short型数据转成字节数组
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(short value) {
		byte[] bt = new byte[2];
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (value >>> (i * 8));
		}
		return bt;
	}

	/**
	 * 将int型数据转成字节数组
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(int value) {
		byte[] bt = new byte[4];
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (value >>> (i * 8));
		}
		return bt;
	}

	/**
	 * 将long型数据转成字节数组
	 * @param value
	 * @return
	 */
	public static byte[] toBytes(long value) {
		byte[] bt = new byte[8];
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (value >>> (i * 8));
		}
		return bt;
	}
	
	/**
	 * 转short
	 * @param obj
	 * @return
	 */
	public static Short toShort(Object obj){
		if(obj == null || "".equals(obj)){
			return null;
		}
		return Short.valueOf(obj.toString());
	}
	
	/**
	 * 转Float
	 * @param obj
	 * @return
	 */
	public static Float toFloat(Object obj){
		if(obj == null || "".equals(obj)){
			return null;
		}
		return Float.valueOf(obj.toString());
	}
	
	/**
	 * 转Integer
	 * @param obj
	 * @return
	 */
	public static Integer toInteger(Object obj){
		if(ObjectUtils.isNull(obj)){
			return null;
		}
		return Integer.valueOf(obj.toString());
	}
	
	/**
	 * 转Long
	 * @param obj
	 * @return
	 */
	public static Long toLong(Object obj){
		if(ObjectUtils.isNull(obj)){
			return null;
		}
		return Long.valueOf(obj.toString());
	}
	
	/**
	 * 转Double
	 * @param obj
	 * @return
	 */
	public static Double toDouble(Object obj){
		if(obj == null || "".equals(obj)){
			return null;
		}
		return Double.valueOf(obj.toString());
	}
	
	/**
	 * 转Byte
	 * @param obj
	 * @return
	 */
	public static Byte toByte(Object obj){
		if(obj == null || "".equals(obj)){
			return null;
		}
		return Byte.valueOf(obj.toString());
	}

}
