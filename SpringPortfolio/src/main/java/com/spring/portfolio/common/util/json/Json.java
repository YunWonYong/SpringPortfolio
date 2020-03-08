package com.spring.portfolio.common.util.json;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import com.spring.portfolio.common.exception.json.JsonException;
import com.spring.portfolio.common.util.json.parsing.JsonArrayParsing;
import com.spring.portfolio.common.util.json.parsing.JsonStringParsing;

public abstract class Json {
	private static Parsing parsingInterface;
	protected static final StringBuffer JSON = new StringBuffer();

	public Json() {
	}

	public static String parsing(Object obj) throws JsonException {
		String json = null;
		Class<?> c = obj == null ? null : obj.getClass();
		String switchValue = c.getSimpleName().toLowerCase();
		switchValue = switchValue.contains("list") ? "list" : switchValue;
		switch (switchValue) {
		case "string":
			parsingInterface = new JsonStringParsing(String.valueOf(obj));
			json = parsingInterface.createJson();
			break;
		case "list":
			parsingInterface = new JsonArrayParsing((List<?>) obj);
			json = parsingInterface.createJson();
			//System.out.println("list front json:" + json);
			//System.out.println("list front JSON:" + JSON.toString());
			break;
		default:
			throw new JsonException("The parameter cannot be parsing.");
		}

		if (json == null) {
			throw new JsonException("JsonParsing Fail");
		}
		System.out.println("return json:" + json);
		return json;
	}

	public static Map<String, ?> unParsing(String str) {
		Map<String, ?> map = null;
		return map;
	}

	protected static String result(String json) {
		if (JSON.length() > 0) {
			JSON.append(json);
		}
		while (JSON.length() > 0) {
			json = JSON.toString();
			json = json.replaceAll("\\}\\]\\{", "\\}\\,\\{");
			json = json.replaceAll("\\}\\{", "\\}\\,\\{");
			if (!(json.contains("}{") && json.contains("}]{"))) {
				json += "]";
				break;
			}
		}
		if (JSON.length() == 0) {
			JSON.append(json.contains("[") ? "" : "[");
			JSON.append(json);
		}
		return json;
	}

	protected String addElement(final String[] keyAndValue) {
		return setQuotationMark(keyAndValue[0]) + ":" + setValue(keyAndValue[1]);
	}

	protected String setQuotationMark(final String key) {
		int j = 0;
		for (int i = 0; i < key.length(); i++) {
			j = key.charAt(i) == '\"' ? j + 1 : j;
		}
		return j == 0 ? "\"" + key + "\""
				: (j == 1 && key.lastIndexOf("\"") == 0) ? key + "\"" : j == 2 ? key : "\"" + key;
	}

	protected String setValue(final String value) {
		boolean typeCheck = value.equals("null") ? true
				: value.equals("true") ? true
						: value.equals("false") ? true : Pattern.matches("^[0-9]*$", value) ? true : false;
		return typeCheck ? value : setQuotationMark(value);
	}

	protected String end(final List<String> list) {
		StringBuffer result = new StringBuffer("{");
		for (int i = 0; i < list.size(); i++) {
			result.append(list.get(i));
			if (i != list.size() - 1) {
				result.append(",");
			}
		}
		result.append("}");
		return result.toString();
	}

	protected String keyValueExtract(final String[] elements) {
		final List<String> list = new ArrayList<String>();
		for (String element : elements) {
			String[] keyAndValue = element.split("\\:");
			list.add(addElement(keyAndValue));
		}
		return end(list);
	}
}
