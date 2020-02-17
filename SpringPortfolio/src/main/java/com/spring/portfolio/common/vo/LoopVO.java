package com.spring.portfolio.common.vo;

import java.util.ArrayList;
import java.util.List;

public class LoopVO {
	private int start, end, operator;
	private  List<String> returnList = new ArrayList<String>();

	public LoopVO() {
	}

	public LoopVO(int start, int end, int operator) {
		this.start = start;
		this.end = end;
		this.operator = operator;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getOperator() {
		return operator;
	}

	public void setOperator(int operator) {
		this.operator = operator;
	}
	
	public List<String> getReturnList() {
		return returnList;
	}

	public void setReturnList(List<String> returnList) {
		this.returnList = returnList;
	}

	public void addArrayList(String value) {
		returnList.add(value);
	}
}
