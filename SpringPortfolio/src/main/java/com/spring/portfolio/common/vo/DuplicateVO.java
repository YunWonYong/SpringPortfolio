package com.spring.portfolio.common.vo;


public class DuplicateVO {

	/**
	 * 
	 */
	private String target;
	private Object value;

	public DuplicateVO() {
	}

	
	public DuplicateVO(String target, Object value) {
		this.target = target;
		this.value = value;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public Object getValue() {
		return value;
	}


	public void setValue(Object value) {
		this.value = value;
	}
	
}
