package com.tool.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

/**
 * @author xielbs
 * @create 2018-04-18 9:37
 * @desc JSON处理工具类
 **/
public class JSONUtils {
	/**
	 * 利用GSON工具包
	 */
	private final static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	private final static Gson gsonUpCase = new GsonBuilder().disableHtmlEscaping().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

	/**
	 * 解析对象成json字符串
	 * @param obj 对象
	 * @return
	 */
	public static String serialize(Object obj) throws JSONException {
		try {
			return gson.toJson(obj);
		} catch (Exception e) {
			throw new JSONException("json解析出错" + e.getMessage());
		}

	}
	
	/**
	 * 解析对象成json字符串，属性名大写
	 * @param obj 对象
	 * @return
	 */
	public static String serializeUpCase(Object obj) throws JSONException {
		try {
			return gsonUpCase.toJson(obj);
		} catch (Exception e) {
			throw new JSONException("json解析出错" + e.getMessage());
		}

	}

	/**
	 * 解析json成指定对象类型
	 * @param json json字符串
	 * @param className 对象类型
	 * @return
	 */
	public static Object deserialize(String json, Class<?> className)
			throws JSONException {
		try {
			return gson.fromJson(json, className);
		} catch (Exception e) {
			throw new JSONException("json解析出错" + e.getMessage());
		}
	}
	
	/**
	 * 解析json成指定对象类型，属性名大写
	 * @param json json字符串
	 * @param className 对象类型
	 * @return
	 */
	public static Object deserializeUpCase(String json, Class<?> className)
			throws JSONException {
		try {
			return gsonUpCase.fromJson(json, className);
		} catch (Exception e) {
			throw new JSONException("json解析出错" + e.getMessage());
		}
	}
	
	/**
	 * 解析json成指定对象类型
	 * @param json
	 * @param className
	 * @return
	 */
	public static <T> T deserializeObj(String json, Class<T> className)
			throws JSONException {
		try {
			return gson.fromJson(json, className);
		} catch (Exception e) {
			throw new JSONException("json解析出错" + e.getMessage());
		}
	}
	
	/**
	 * 解析json成指定对象类型 json属性民首字母大写
	 * 
	 * @param json
	 * @param className
	 * @return
	 */
	public static <T> T deserializeObjUpCase(String json, Class<T> className)
			throws JSONException {
		try {
			return gsonUpCase.fromJson(json, className);
		} catch (Exception e) {
			throw new JSONException("json解析出错" + e.getMessage());
		}
	}
	
	/**
	 * 解析json成指定对象类型
	 * 
	 * @param json
	 * @param cla 要转对象的CLASS
	 * @return
	 */
	public static <T> List<T> deserializeList(String json,Class<T> cla)
			throws JSONException {
		Type type = new TypeToken<ArrayList<JsonObject>>(){}.getType();
		  ArrayList<JsonObject> jsonObjs = gson.fromJson(json, type);
		  ArrayList<T> listOfT = new ArrayList();
		  for (JsonObject jsonObj : jsonObjs) {
		      listOfT.add(gson.fromJson(jsonObj, cla));
		  }
		  return listOfT;
	}
	
	/**
	 * 解析json
	 * 
	 * @param json
	 * @param t 对象类型转换标示类
	 * @return
	 * @throws JSONException
	 */
	public static <T> T deserialize(String json,ObjectToken<T> t)
			throws JSONException {
		try {
			return gson.fromJson(json, t.getType());
		} catch (Exception e) {
			throw new JSONException("json解析出错" + e.getMessage());
		}
	}
	
	/**
	 * 解析json
	 * 
	 * @param json
	 * @param t 对象类型转换标示类
	 * @return
	 * @throws JSONException
	 */
	public static <T> T deserializeUpCase(String json,ObjectToken<T> t)
			throws JSONException {
		try {
			return gsonUpCase.fromJson(json, t.getType());
		} catch (Exception e) {
			throw new JSONException("json解析出错" + e.getMessage());
		}
	}
	/**
	 * 对象类型转换标示类
	 * @author Administrator
	 * @param <T> 具体类型
	 */
	public static class ObjectToken<T> extends TypeToken<T>{
		
	}
	
	public static void main(String[] args){
		String json = "{stationIDs=[10, 4, 5, 2]}";
		try {
			Map<String,List<Integer>> obj = deserialize(json, new ObjectToken<Map<String,List<Integer>>>(){});
			System.out.println(obj);
			System.out.println(obj.get("stationIDs"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		json = "{s=1,a=2,c=3}";
		try {
			Map<String,Integer> obj = deserialize(json, new ObjectToken<Map<String,Integer>>(){});
			System.out.println(obj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		json = "[1,2,3]";
		try {
			List<Integer> obj = deserialize(json, new ObjectToken<List<Integer>>(){});
			System.out.println(obj);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		CCons cons = new CCons();
//		json = "{ConsId:1,ConsNo:122}";
//		try {
//			cons = (CCons) deserializeUpCase(json, CCons.class);
//			System.out.println(serializeUpase(cons));
//		} catch (JSONException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
	}

}
