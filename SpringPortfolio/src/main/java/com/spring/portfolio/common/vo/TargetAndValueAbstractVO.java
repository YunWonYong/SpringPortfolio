package com.spring.portfolio.common.vo;

public abstract class TargetAndValueAbstractVO {
	private String target;
	private Object value;

	protected void valueInit(String target, Object value) {
		this.target = target;
		if (value instanceof String) {
			this.value = (String) value;
			return;
		}
		this.value = (Integer) value;
	}

	public String getTarget() {
		return target;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "TargetAndValueAbstractVO [target=" + target + ", value=" + value + "]";
	}

}
