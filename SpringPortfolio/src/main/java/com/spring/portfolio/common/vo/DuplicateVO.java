package com.spring.portfolio.common.vo;

public class DuplicateVO extends TargetAndValueAbstractVO{

	@SuppressWarnings("unused")
	private DuplicateVO() {
	}
	
	public DuplicateVO(String target, String value) {
		super.valueInit(target, value);
	}
}
