package com.spring.portfolio.paging.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.portfolio.common.namespaces.RepositoryNameSpaces;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;
import com.spring.portfolio.common.vo.PagingVO;
import com.spring.portfolio.paging.model.PagingEntity;
import com.spring.portfolio.paging.repository.PagingDAO;

@Service(value = ServiceNameSpaces.PGING)
public class PagingServiceImpl implements PagingService {
	@Resource(name = RepositoryNameSpaces.PGING)
	private PagingDAO dao;

	public PagingServiceImpl() {
	}

	@Override
	public PagingEntity recordSize(Map<String, Object> map) throws Exception {
		PagingEntity entity = new PagingEntity();
		int amount = dao.getAmmount(map);
		PagingVO paginVO = null;
		if (map.get("pagingvo") != null) {
			paginVO = (PagingVO) map.get("pagingvo");
		}
		entity.setAmount(amount, paginVO);
		return entity;
	}

}
