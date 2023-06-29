package com.hostmdy.hmi.service;

import com.hostmdy.hmi.domain.Program;

import java.util.List;
import java.util.Optional;

public interface ProgramService {
	Program createProgram(Program program,Long academicId); //method build (object 1 ku build)
	
	List<Program> findAll();
	
	Optional<Program> findByProgramId(Long id);
	
	Optional<Program> findByProgramName(String programName);
	
	Program updateProgram(Program program,Long academicId);
	
	void deleteById(Long id);
	

}
