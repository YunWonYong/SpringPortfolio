package com.spring.portfolio.common.exception.json;

public class JsonException extends Exception {

	private static final long serialVersionUID = 1L;

	public JsonException() {
		super("The data cannot be parsing.");
	}

	public JsonException(String message) {
		super(message);
	}
}
