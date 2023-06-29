package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.hmi.domain.Time;


public interface TimeService {
	Time createTime(Time time,Long programId); //method build (object 1 ku build)
	
	Time createTime(Time time);
	
	List<Time> findAll();
	
	Optional<Time> findByTimeId(Long id);
	
	Time updateTime(Time time,Long programId);
	
	void deleteById(Long id);

}
