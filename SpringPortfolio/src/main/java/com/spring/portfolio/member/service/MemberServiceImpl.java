package com.spring.portfolio.member.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.spring.portfolio.account.model.AccountDTO;
import com.spring.portfolio.common.namespaces.RepositoryNameSpaces;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;
import com.spring.portfolio.common.util.sql.SqlMultiObject;
import com.spring.portfolio.common.vo.DuplicateVO;
import com.spring.portfolio.member.model.MemberDTO;
import com.spring.portfolio.member.repository.MemberDAO;
import com.spring.portfolio.paging.model.PagingEntity;
import com.spring.portfolio.paging.service.PagingService;

@Service(value = ServiceNameSpaces.MEMBER)
public class MemberServiceImpl implements MemberService {
	@Resource(name = RepositoryNameSpaces.MEMBER)
	private MemberDAO memberDAO;
	@Resource(name = ServiceNameSpaces.PAGING)
	private PagingService pagingService;

	public MemberServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void transaction() throws Exception {
	}

	@Override
	public boolean register(MemberDTO dto) throws Exception {
		return memberDAO.insert(dto);
	}

	@Override
	public MemberDTO getOne(String id) throws Exception {
		return memberDAO.read(id);
	}

	@Override
	public boolean modify(MemberDTO dto) throws Exception {
		return memberDAO.update(dto);
	}

	@Override
	public List<Object> allList(Map<String, Object> map) throws Exception {
		PagingEntity entity = pagingService.recordSize(map);
		map = SqlMultiObject.add(entity, map.get("searchvo"));
		List<Object> list = memberDAO.list(map);
		list.add(entity);
		return list;
	}

	@Override
	public String checkDuplicate(DuplicateVO vo) throws Exception {
		return memberDAO.duplicate(vo) == null ? "true" : "false";
	}

	@Override
	public boolean remove(AccountDTO dto) throws Exception {
		return memberDAO.delete(dto);
	}
}
