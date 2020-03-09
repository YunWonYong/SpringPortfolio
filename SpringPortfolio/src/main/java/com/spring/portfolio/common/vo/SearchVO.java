package com.spring.portfolio.common.vo;

public class SearchVO extends TargetAndValueAbstractVO {

	@SuppressWarnings("unused")
	private SearchVO() {
	}

	public SearchVO(String target, Object value) {
		super.valueInit(target, value);
	}
}
