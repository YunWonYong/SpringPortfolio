package com.spring.portfolio.common.util.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import com.spring.portfolio.common.util.member.MemberUtility;

public class JsonParsing {
	private Object obj;
	private final StringBuffer JSON = new StringBuffer();

	private JsonParsing() {
	}

	public JsonParsing(Object obj) throws Exception {
		this.obj = obj;
		System.out.println(this.obj); 
		getType(this.obj.getClass()); 
	}

	public String parsing() throws Exception {
		return JSON.toString();
	}

	private void getType(Class<?> c) throws Exception {
			for (Field f : c.getDeclaredFields()) {
				typeSwith(typeExtract(f.getType().toString()),f);
			}
	}

	private void typeSwith(String type, Field f) throws Exception {
		switch (type) {
		case "char":
			charParsing(f);
		case "string":
			appendText(f);
			break;
		default:
			break;
		}
	}

	private void charParsing(Field f) throws Exception {
//		Method[] method = obj.getClass().getDeclaredMethods();
//		Parameter[] parameter = null;
//		for(Method m : method) {
//			System.out.println("method"+m.getName());
//			
//			parameter = m.getParameters();
//			for(Parameter p:parameter) {
//				System.out.println("param:"+p.getName());
//			}
//		}
		f.setAccessible(true);
		System.out.println(f.get(f.getName()));     
		JSON.append(f.getName());
	}

	private String typeExtract(String type) throws Exception {
		return type.contains(".") ? type.substring(type.toString().lastIndexOf('.') + 1) : type;
	}

	private void appendText(Field f) throws Exception {

	}

}
