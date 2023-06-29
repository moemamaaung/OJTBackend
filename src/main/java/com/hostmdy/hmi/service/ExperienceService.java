package com.hostmdy.hmi.service;

import java.util.List;

import java.util.Optional;

import com.hostmdy.hmi.domain.Experience;

public interface ExperienceService {
	
	Experience saveorUpdate(Experience experience);
	
	List<Experience> findAll();
	
	Optional<Experience> findByExperienceId(Long id);
	
	void deleteByExperienceId(Long id);
	
	

}
