package com.libgdx.fighter.utils;

import java.util.HashMap;

public class CacheManager {
	private final static HashMap<Integer, Object> objects = new HashMap<Integer, Object>();
	
	public static void put(Integer key, Object o){
		objects.put(key, o);
	}
	
	public static Object get(Integer key){
		return objects.get(key);
	}
}
