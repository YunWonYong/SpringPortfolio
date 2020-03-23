package com.spring.portfolio.certification.service;

import com.spring.portfolio.certification.model.CertificationDTO;

public interface CertificationService {

	public abstract void register(CertificationDTO dto) throws Exception;

	public abstract CertificationDTO getOne(CertificationDTO dto) throws Exception;

	public abstract boolean inspectionCheck(CertificationDTO dto) throws Exception;

}
