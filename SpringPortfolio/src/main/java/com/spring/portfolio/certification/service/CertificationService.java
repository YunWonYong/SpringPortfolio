package com.spring.portfolio.certification.service;

import com.spring.portfolio.certification.model.CertificationDTO;

public interface CertificationService {

	public abstract Integer register(CertificationDTO dto) throws Exception;

	public abstract CertificationDTO getOne(CertificationDTO dto) throws Exception;

	public abstract boolean inspectionCheck(CertificationDTO dto) throws Exception;

	public abstract void modify(CertificationDTO dto) throws Exception;

	public abstract void remove() throws Exception;

}
