package com.hostmdy.hmi.service;

import java.util.List;

import java.util.Optional;
import com.hostmdy.hmi.domain.Applicant;


public interface ApplicantService {
	
	Applicant saveorUpdate(Applicant applicant);
	
	List<Applicant> findAll();
	
	Optional<Applicant> findByApplicantId(Long id);
	
	void deleteByApplicantId(Long id);

}
