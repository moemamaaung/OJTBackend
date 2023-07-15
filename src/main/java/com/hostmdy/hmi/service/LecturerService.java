package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.hmi.domain.Lecturer;

public interface LecturerService {
	
	Lecturer createOrUpdateLecturer(Lecturer lecturer);
	
	List<Lecturer> fillAllLecturers();
	
	Optional<Lecturer> findById(Long id);
	
	Optional<Lecturer> findByName(String name);
	
	void deleteById(Long id);

}
