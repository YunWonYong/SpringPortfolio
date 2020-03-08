package com.spring.portfolio.common.exception.json;

public final class JsonStringException extends JsonException {

	private static final long serialVersionUID = 1L;
	
	public JsonStringException() {
		super("not String Type"); 
	}
	public JsonStringException(String message) {
		super(message);
	} 
}
