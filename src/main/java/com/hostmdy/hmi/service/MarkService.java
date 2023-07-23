package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.hmi.domain.Mark;


public interface MarkService {
	
	List<Mark> findAll();
	
	Mark create(Mark mark,Long courseId);
	
	Mark updateMark(Mark mark,Long courseId);
	
	Optional<Mark> findById(Long id);
	
	void deleteById(Long id);
	
	

}
