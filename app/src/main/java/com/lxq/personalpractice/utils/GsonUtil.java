package com.lxq.personalpractice.utils;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lxf on 2016/6/16.
 */
public class GsonUtil {

	public static Gson gson;
	static {
		if (gson == null) {
			gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		}
	}

	/**
	 * 转成json
	 * 
	 * @param object
	 * @return
	 */
	public static String GsonToString(Object object) {
		String gsonString = null;
		if (gson != null) {
			gsonString = gson.toJson(object);
		}
		return gsonString;
	}

	/**
	 * 转成bean
	 * 
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> T GsonToBean(String gsonString, Class<T> cls) {
		T t = null;
		if (gson != null) {
			t = gson.fromJson(gsonString, cls);
		}
		return t;
	}
	
	/**
	 * 转成list
	 * @param <T>
	 * 
	 * @param gsonString
	 * @param cls
	 * @return 
	 */
	public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
//		List<T> list = null;
//		if (gson != null) {
//			list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
//			}.getType());
//		}
//		return list;
		ArrayList<T> mList = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(gsonString).getAsJsonArray();  
        for(final JsonElement elem : array){  
            mList.add(gson.fromJson(elem, cls));  
        }  
        return mList;  
	}

	/**
	 * 转成list中有map的
	 * 
	 * @param gsonString
	 * @return
	 */
	public static <T> List<Map<String, T>> GsonToListMaps(String gsonString) {
		List<Map<String, T>> list = null;
		if (gson != null) {
			list = gson.fromJson(gsonString,
					new TypeToken<List<Map<String, T>>>() {
					}.getType());
		}
		return list;
	}

	/**
	 * 转成map的
	 * 
	 * @param gsonString
	 * @return
	 */
	public static <T> Map<String, T> GsonToMaps(String gsonString) {
		Map<String, T> map = null;
		if (gson != null) {
			map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
			}.getType());
		}
		return map;
	}
}
