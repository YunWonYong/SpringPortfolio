package com.spring.portfolio.member.service;

import java.util.List;
import java.util.Map;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.service.MainService;

public interface MemberService extends MainService {
	public abstract boolean register(MemberDTO dto) throws Exception;

	public abstract MemberDTO getOne(String id) throws Exception;

	public abstract boolean modify(MemberDTO dto) throws Exception;

	public abstract List<Object> allList(Map<String, Object> map) throws Exception;

	public abstract String checkDuplicate(DuplicateVO vo) throws Exception;

	public abstract boolean remove(AccountDTO dto) throws Exception;
}
