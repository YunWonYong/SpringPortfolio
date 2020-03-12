package com.spring.portfolio.common.util.sql;

import java.util.HashMap;
import java.util.Map;

public abstract class SqlMultiObject {
	
	private SqlMultiObject() {
		
	}
	public static Map<String, Object> add(Object... obj) {
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < obj.length; i++) {
			map.put(obj[i].getClass().getSimpleName().toLowerCase(), obj[i]);
		}
		return map;
	}

}
