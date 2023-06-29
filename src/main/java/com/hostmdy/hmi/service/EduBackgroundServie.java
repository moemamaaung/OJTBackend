package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.hmi.domain.EduBackground;

public interface EduBackgroundServie {
	
	EduBackground saveorUpdate(EduBackground edubackground);
	
	List<EduBackground> findAll();
	
	Optional<EduBackground> findByEduBackgroundId(Long id);
	
	void deleteByEduBackgroundId(Long id);
	
	
	

}
