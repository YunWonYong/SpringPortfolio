package com.spring.portfolio.common.util.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUnParsing {
	private final Map<String, Map<String, String>> MAP;
	private final Map<String,List<String>> ARRAYMAP;
	private Map<String,String> elementMAP;
	private List<String> targetList;
	private List<String> elementArr;
	private int index=0;
	public JsonUnParsing() {
		MAP = new HashMap<String, Map<String, String>>();
		ARRAYMAP = new HashMap<String,List<String>>();
	}

	public Map<?,?>  unParsing(final String json) throws Exception {
		targetList = new ArrayList<String>();
		elementArr = new ArrayList<String>();
		if(json.contains("},{")) {
			arrSplit(json);
			return ARRAYMAP; 
		}
		targetSplit(json); 
		return MAP;
	}
	
	private void arrSplit(String json) {
		json = json.replaceAll("\\}\\,\\{","\\}\\#\\{");
		String[] arr = json.split("\\]\\,");
		List<String> jsonExtract = new ArrayList<String>();
		jsonExtract:for(int i =0; i < arr.length;i++) {
			if(i!=arr.length-1) {
				jsonExtract.add(arr[i]+"]");
				continue jsonExtract;
			}
			jsonExtract.add(arr[i]);
		}
		arrSet(jsonExtract);
		
	}
	private void arrSet(final List<String> jsonExtract) {
		jsonSet:for(int i = 0; i < jsonExtract.size(); i++) {
			if(!(i==0||i==jsonExtract.size()-1))continue jsonSet;
			String chang =jsonExtract.get(i).replaceFirst(i==0?"\\{":"\\]\\}", i==0?"":"\\]");
			jsonExtract.set(jsonExtract.indexOf(jsonExtract.get(i)),chang);
		}
	getArrElement(jsonExtract);
	}
	private void getArrElement(final List<String> jsonExtract) {
		for(int i =0; i<jsonExtract.size();i++) {
			String json  = jsonExtract.get(i);
			ARRAYMAP.put(getKey(json),getElementhList(json));
		}
	}
	private List<String> getElementhList(String json) {
		List<String> elementList = new ArrayList<String>();
		json = json.split("\\:\\[")[1].split("\\]")[0];
		String[] element = json.split("\\#");
		for(int i =0; i < element.length;i++) {
//			String addValue = element[i];
//			if(i<element.length-1) {
//				addValue+=",";
//			}
			elementList.add(element[i]);
		}
		return elementList ;
	}
	private String getKey(String json) {
		String key = json.split("\\:")[0];
		return key.replaceAll("\"", "");
	}
	private String firstTarget(String[] targets) {
		return targets[0].split("\\{")[1].replace("\"","");
	}
	private void targetSplit(final String json) throws Exception {
		String[] targets = json.split("\\:\\[");
		targetList.add(firstTarget(targets));
		List<String> element = new ArrayList<String>();
		getTarget: for (String target : targets) {
			if (target.contains("],")) {
				String[] split = target.split("\\]\\,");
				String addTarget = split[1];
				targetList.add(addTarget.replace("\"",""));
				element.add(split[0]);
				continue getTarget;
			}
			element.add(target);
		}
		elementSplit(element);
	}

	private void elementSplit(final List<String> element) throws Exception {
		for (int i = 1; i < element.size(); i++) {
			String value = element.get(i);
			String addValue = value.contains("]}") ? value.split("\\]\\}")[0] : value;
			elementArr.add(addValue);
		}
		extractElement();
	}

	private void extractElement() throws Exception {
		for (int i = 0; i < elementArr.size(); i++) {
			keyAndvalue(elementArr.get(i).split("\\{")[1].split("\\}")[0]);
			
		}
	}
	private void keyAndvalue(String extractValue) {
		String[] elements = extractValue.split("\\,");
		elementMAP = new HashMap<String, String>();
		for(String element:elements) {
			String[] split = element.split("\\:");
			elementMAP.put(split[0],split[1]);
		}
		mapPut();
	}
	private void mapPut() {
		MAP.put(targetList.get(index),elementMAP);
		index++;
	}
}