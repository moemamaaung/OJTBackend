package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;


import com.hostmdy.hmi.domain.Exam;

public interface ExamSercice {

	List<Exam> findAll();
	
	Exam createOrUpdate(Exam exam);
	
	Optional<Exam> findById(Long id);
	
	void deleteById(Long id);
	
	
	
}
