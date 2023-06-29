package com.hostmdy.hmi.repository;

//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.hmi.domain.Course;

public interface CourseRepository extends CrudRepository<Course, Long>{
	
//	Optional<Course> findBySubjectName(String subjectName);

}
