package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.hmi.domain.Course;

public interface CourseService {
	Course createCourse(Course course,Long programId);
	
	Course updateCourse(Course course,Long programId);
	
	List<Course> findAll();
	
	Optional<Course> findById(Long id);
	
//	Optional<Course> findBySubjectName(String subjectName);
	
	void deleteById(Long id);
	

}
