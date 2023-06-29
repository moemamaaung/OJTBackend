package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.hmi.domain.AcademicYear;


public interface AcademicYearService {

	AcademicYear createAcademicYear(AcademicYear academicYear); //method build (object 1 ku build)
	
	List<AcademicYear> findAll();
	
	Optional<AcademicYear> findByAcademicYearId(Long id);
	
	AcademicYear updateAcademicYear(AcademicYear academicYear);
	
	void deleteById(Long id);
}
