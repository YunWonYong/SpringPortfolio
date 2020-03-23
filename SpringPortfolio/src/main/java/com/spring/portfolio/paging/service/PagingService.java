package com.spring.portfolio.paging.service;

import java.util.Map;

import com.spring.portfolio.paging.model.PagingEntity;

public interface PagingService {
	public abstract PagingEntity recordSize(Map<String,Object> map) throws Exception;
}
