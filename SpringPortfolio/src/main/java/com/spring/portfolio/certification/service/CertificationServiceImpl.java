package com.spring.portfolio.certification.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.portfolio.certification.model.CertificationDTO;
import com.spring.portfolio.certification.repository.CertificationDAO;
import com.spring.portfolio.common.namespaces.RepositoryNameSpaces;
import com.spring.portfolio.common.namespaces.ServiceNameSpaces;

@Service(ServiceNameSpaces.CERTIFICATION)
public class CertificationServiceImpl implements CertificationService{
	@Resource(name=RepositoryNameSpaces.CERTIFICATION)
	private CertificationDAO dao; 
	
	public CertificationServiceImpl(){
		// TODO Auto-generated constructor stub
	}

	@Override
	public void register(CertificationDTO dto) throws Exception {
		dao.insert(dto);
	}

	@Override
	public CertificationDTO getOne(CertificationDTO dto) throws Exception {
		return dao.read(dto);
	}

	@Override
	public boolean inspectionCheck(CertificationDTO dto) throws Exception {
		return dao.check(dto);
	}

}
