package com.spring.portfolio.common.namespace;

import org.springframework.beans.factory.annotation.Value;

public interface NameSpace {
	@Value("#{namespace['member.namespace']}")
	public static final String MEMBER = "";
	@Value("#{namespace['account.namespace']}")
	public static final String ACCOUNT = "";
}
