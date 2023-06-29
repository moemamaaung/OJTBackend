package com.hostmdy.hmi.repository;



import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.hmi.domain.Program;

public interface ProgramRepository extends CrudRepository<Program, Long>{
	 Optional<Program> findByProgramName(String programName);
	 
	

}
