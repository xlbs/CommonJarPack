package com.tool.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xielbs
 * @create 2018-04-18 9:37
 * @desc 对象反射工具类
 **/
public abstract class ObjectUtils {
	
	/**
	 * 设置对象属性值
	 * @param object 对象
	 * @param methodName 方法名称
	 * @param cls 参数类型
	 * @param value 参数值
	 * @throws Exception
	 */
	public static void setValue(Object object,String methodName,Class cls,Object value) throws Exception {
		object.getClass().getMethod(methodName, new Class[]{cls}).invoke(object, new Object[]{value});
	}

	/**
	 * 默认参数类型设置对象属性
	 * @param object 对象
	 * @param methodName 方法名称
	 * @param value 参数值
	 * @throws Exception
	 */
	public static void setValue(Object object,String methodName,Object value) throws Exception {
		setValue(object, methodName, value.getClass(), value);
	}

	/**
	 * 获取对象属性值
	 * @param object 对象
	 * @param methodName 方法名称
	 * @return
	 * @throws Exception
	 */
	public static Object getValue(Object object,String methodName) throws Exception {
		return object.getClass().getMethod(methodName, (Class[])null).invoke(object, (Object[])null);
	}

	/**
	 * 将对象集合中每个对象按照指定的属性，与格式取值，然后转换成Map键值对
	 * @param objs 对象
	 * @param properties 单个对象的属性名称集合，需满足javabean条件
	 * @param patterns 可能需要的格式化
	 * @return
	 */
	public static List<Map> parseObjectsToMaps(List<?> objs,List<String> properties,String[] patterns){
		List<Map> list = new ArrayList<Map>();
		if(objs==null||objs.size()==0)return list;
		for(int i=0;i<objs.size();i++){
			list.add(parserObjectToMap(objs.get(i), properties,patterns));
		}
		return list;
	}
	
	/**
	 * 解析嵌套对象属性为map,以备gt-grid显示数据用
	 * 比如属性名称为a.b将依次取a属性值，然后再取a属性值中的b属性值
	 * @param obj 对象
	 * @param properties 属性集合
	 * @param patterns 指定格式集合
	 * @return
	 */
	public static Map parserObjectToMap(Object obj,List<String> properties,String[] patterns){
		Map result = new HashMap();
		for(int i = 0;i<properties.size();i++){
			String[] prop_s = properties.get(i).split("\\.");
			Object value = obj;
			for(int j=0;j<prop_s.length;j++){
				value = getPropertyofObject(prop_s[j], value, patterns!=null?patterns[j]:null);
			}
			result.put(prop_s[prop_s.length-1], value);
		}
		return result;
	}
	
	/**
	 * 对象直接属性取值
	 * @param propertyName 属性名
	 * @param obj 对象
	 * @param pattern 指定格式
	 * @return
	 */
	public static Object getPropertyofObject(String propertyName, Object obj,String pattern) {
		if(obj==null)return "";
		try {
			Method method = obj.getClass().getMethod(
					"get" + StringUtils.firstUpperCase(propertyName), (Class[]) null);
			Object objs = method.invoke(obj, (Object[]) null);
			if (pattern != null && objs != null) {
				if (objs instanceof Number) {
					return FormatUtils.formatData(((Number) objs), pattern);
				} else if (objs instanceof Calendar) {
					return FormatUtils.formatCalendar((Calendar) objs, pattern);
				}
			}
			return objs;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 将一段日期按指定时间间隔分割
	 * @param maps
	 * @param classType
	 * @param start
	 * @param end
	 * @param field
	 * @param amount
	 */
	public static void sliceCalendar(LinkedHashMap<Calendar, Object> maps, Class classType, Calendar start, Calendar end, int field, int amount) {
		Calendar _start = (Calendar) start.clone();
		while (_start.before(end)) {
			try {
				maps.put((Calendar) _start.clone(), classType.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			_start.add(field, amount);
		}
	}
	
	/**
	 * 反射执行对象方法
	 * @param obj 目标对象
	 * @param methodName 方法名称
	 * @param argsType 参数类型
	 * @param args 方法参数
	 * @return
	 */
	public static Object invokeMethodByClass(Object obj, String methodName, Class[] argsType, Object[] args) {
		if(obj == null){
			return null;
		}
		try {
			Method mh = obj.getClass().getDeclaredMethod(methodName, argsType);
			return mh.invoke(obj, args);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断字符是否为空
	 * @param str 字符串
	 * @return
	 */
	public static boolean isNull(Object str){
		return (str == null || "".equals(str) || "null".equalsIgnoreCase(str.toString()) || "undefined".equalsIgnoreCase(str.toString()));
	}

	/**
	 * 对象数组非空判断
	 * @param array 数组
	 * @return
	 */
	public static boolean isEmpty(Object[] array) {
		return (array == null || array.length == 0);
	}
	
	/**
	 * 转整型数组
	 * @param str 字符串
	 * @param regex 分割符
	 * @return
	 */
	public static Integer[] toIntArray(String str, String regex){
		if(isNull(str)){
			return new Integer[0];
		}
		String[] strArray = str.split(regex);
		Integer[] intArry = new Integer[strArray.length];
		for(int i=0;i<strArray.length;i++){
			intArry[i]=Integer.valueOf(strArray[i]) ;
		}
		return intArry;
	}
	
	/**
	 * 转字符型数组
	 * @param str 字符串
	 * @param regex 分割符
	 * @return
	 */
	public static String[] toStrArray(String str, String regex){
		if(isNull(str)){
			return new String[0];
		}
		return str.split(regex);
	}
	
	/**
	 * 转Short数组
	 * @param str 字符串
	 * @param regex 分割符
	 * @return
	 */
	public static Short[] toShtArray(String str, String regex){
		if(isNull(str)){
			return new Short[0];
		}
		String[] strArray = str.split(regex);
		Short[] shtArry = new Short[strArray.length];
		for(int i=0;i<strArray.length;i++){
			shtArry[i]=Short.valueOf(strArray[i]) ;
		}
		return shtArry;
	}
	
}
