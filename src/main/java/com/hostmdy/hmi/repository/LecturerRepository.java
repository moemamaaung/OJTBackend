package com.hostmdy.hmi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.hmi.domain.Lecturer;

public interface LecturerRepository extends CrudRepository<Lecturer, Long>{
	
	Optional<Lecturer> findByName(String name);
}
