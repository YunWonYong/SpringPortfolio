package com.spring.portfolio.common.util.json.parsing;
import com.spring.portfolio.common.exception.json.JsonStringException;
import com.spring.portfolio.common.util.json.Json;
import com.spring.portfolio.common.util.json.Parsing;

public final class JsonStringParsing extends Json implements Parsing {
	public final String DATA;

	@SuppressWarnings("unused")
	private JsonStringParsing() {
		DATA = null;
	}

	public JsonStringParsing(final String data) throws JsonStringException {
		this.DATA = data;
	}

	public String createJson() throws JsonStringException {
		
		String exceptionMessage = dataCheck();
		if (exceptionMessage != null) {
			throw new JsonStringException(exceptionMessage);
		}
		return result(getJson()); 
	}

	private String dataCheck() {
		return DATA.indexOf(":") < 0 ? "Without clones, you can't distinguish between keys and values." 
				:(DATA.indexOf(":")!=DATA.lastIndexOf(":"))&&(DATA.indexOf(","))<0? "Without commas, the elements cannot be distinguished."
						:null;
	}

	private String getJson() {
		return elementExtract();
	}

	private String elementExtract() {
		return keyValueExtract(curlyBracket(DATA).split("\\,"));
	}
	private String curlyBracket(final String data) {
		return data.indexOf("}")>=0||data.indexOf("{")>=0 
				?data.replaceAll("\\{", "").replaceAll("\\}", "")
						:data;
	}
}
