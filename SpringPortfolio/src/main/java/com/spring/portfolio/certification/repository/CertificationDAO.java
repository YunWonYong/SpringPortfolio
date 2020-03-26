package com.spring.portfolio.certification.repository;

import com.spring.portfolio.certification.model.CertificationDTO;

public interface CertificationDAO {

	public abstract Integer insert(CertificationDTO dto) throws Exception;

	public abstract CertificationDTO read(CertificationDTO dto) throws Exception;

	public abstract boolean check(CertificationDTO dto) throws Exception;

	public abstract void update(CertificationDTO dto)throws Exception;

	public abstract void delete()throws Exception;

}
