package com.spring.portfolio.common.util.json.parsing;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.spring.portfolio.common.exception.json.JsonException;
import com.spring.portfolio.common.exception.json.JsonListException;
import com.spring.portfolio.common.util.json.Json;
import com.spring.portfolio.common.util.json.Parsing;

public final class JsonArrayParsing extends Json implements Parsing {
	private final List<?> dataList;
	private String temp;
	private String className;
	// private final List<String> accessKey = new ArrayList<String>();
	private List<String> elementDataList = new ArrayList<String>();
	private List<String> stringDataList = new ArrayList<String>();
	private Object obj;

	@SuppressWarnings("unused")
	private JsonArrayParsing() {
		this.dataList = null;
	}

	public JsonArrayParsing(final List<?> list) {
		this.dataList = list;
	}

	@Override
	public String createJson() throws JsonException {
		stringContinue: for (int i = 0; i < dataList.size(); i++) {
			obj = dataList.get(i);
			className = obj.getClass().getSimpleName();
			if (className.equals("String")) {
				stringDataList.add(new JsonStringParsing(String.valueOf(obj)).createJson());
				continue stringContinue;
			}
			elementDataList.add(dataAdd(elementExtract()));
		}
		String result = null;
		JSON.delete(0, JSON.length());
		temp = dataMerge();
		result = dataMerge();
		//JSON.delete(0, JSON.length());
		return temp == null ? result : result == null ? temp :temp + result /*result(temp + result)*/;
	}

	private String dataMerge() {
		String merge = null;
		boolean swap = elementDataList != null ? true : false;
		resultSet: for (String str : swap ? elementDataList : stringDataList) {
			if (elementDataList != null) {
				merge = result(str);
				continue resultSet;
			}
			merge = str;
		}
		elementDataList = null; 
		return merge;
	}

	private String dataAdd(String element) {
		StringBuffer data = new StringBuffer();
		data.append(setQuotationMark(className.toLowerCase()));
		data.append("#");
		data.append(element);
		return data.toString();
	}

	private String arrayResult() {
		StringBuffer data = new StringBuffer();
		List<String> dataDuplicate = new ArrayList<String>();
		String[] arr = new String[2];
		duplicateCheck: for (int i = 0; i < elementDataList.size(); i++) {
			String[] split = elementDataList.get(i).split("\\#");
			if (i == 0) {
				arr = split;
				continue duplicateCheck;
			}
			String key = split[0];
			String value = split[1];
			if (arr[0].equals(key)) {
				data.append(data.length() == 0 ? arr[0] + ":[" + value : value);
				System.out.println("중복!!!");
			}
		}
		System.out.println(data.toString());
		// duplicateMerge(dataDuplicate);
		return "";
	}

	private String duplicateMerge(final List<String[]> dataList) {
		for (int i = 0; i < dataList.size(); i++) {
			String key = dataList.get(i)[0];
			String value = dataList.get(i)[1];

		}
		return null;
	}

	private String elementExtract() {
		Class<?> data = obj.getClass();
		Field[] fields = data.getDeclaredFields();
		List<String> result = new ArrayList<String>();
		serialversionContinue: for (Field f : fields) {
			if (f.getName().equalsIgnoreCase("serialversionuid")) {
				continue serialversionContinue;
			}
			result.add(elementSetting(f));
		}
		return end(result);
	}

	private String elementSetting(Field field) {
		String value = null;
		String fieldName = null;
		String element = null;
		try {
			field.setAccessible(true);
			value = field.get(obj) == null ? "null" : String.valueOf(field.get(obj));
			fieldName = field.getName();
			element = addElement(new String[] { fieldName, value });
		} catch (Exception e) {
			e.printStackTrace();
		}

		return element;
	}
}
