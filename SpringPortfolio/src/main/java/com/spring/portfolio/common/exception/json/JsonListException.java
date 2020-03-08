package com.spring.portfolio.common.exception.json;

public final class JsonListException extends JsonException {
	
	private static final long serialVersionUID = 1L;
	
	public JsonListException() {
		super("not List Type");
	}
	public JsonListException(String message) {
		super(message);
	}
}
