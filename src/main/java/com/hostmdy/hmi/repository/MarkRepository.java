package com.hostmdy.hmi.repository;



import org.springframework.data.repository.CrudRepository;


import com.hostmdy.hmi.domain.Mark;

public interface MarkRepository extends CrudRepository<Mark, Long>{

	//List<Mark> findByCourseId(Course course);
}
