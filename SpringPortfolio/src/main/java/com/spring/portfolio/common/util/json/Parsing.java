package com.spring.portfolio.common.util.json;

import com.spring.portfolio.common.exception.json.JsonException;

public interface Parsing {
	public abstract String createJson() throws JsonException;
}
