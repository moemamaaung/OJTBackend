package com.hostmdy.hmi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.AcademicYear;
import com.hostmdy.hmi.domain.Program;
import com.hostmdy.hmi.repository.AcademicYearRepository;
import com.hostmdy.hmi.repository.ProgramRepository;
import com.hostmdy.hmi.service.ProgramService;

@Service
public class ProgramServiceImpl implements ProgramService{
	private final ProgramRepository programRepository;
	private final AcademicYearRepository academicYearRepository;

	@Autowired
	public ProgramServiceImpl(ProgramRepository programRepository, AcademicYearRepository academicYearRepository) {
		super();
		this.programRepository = programRepository;
		this.academicYearRepository = academicYearRepository;
	}

	@Override
	public Program createProgram(Program program,Long academicId) {
		System.out.println("AcademicId"+academicId);
		// TODO Auto-generated method stub
		Optional<AcademicYear> academicOpt = academicYearRepository.findById(academicId);
		if(academicOpt.isPresent()) {
			AcademicYear academic = academicOpt.get();
			
			academic.setProgram(program);
			program.setAcademicyear(academic);
	
		}
		return programRepository.save(program);
	}

	@Override
	public List<Program> findAll() {
		// TODO Auto-generated method stub
		return (List<Program>) programRepository.findAll();
	}

	@Override
	public Optional<Program> findByProgramId(Long id) {
		// TODO Auto-generated method stub
		return programRepository.findById(id);
	}

	@Override
	public Optional<Program> findByProgramName(String programName) {
		// TODO Auto-generated method stub
		return programRepository.findByProgramName(programName);
	}

	@Override
	public Program updateProgram(Program program,Long academicId) {
		// TODO Auto-generated method stub
		
		Optional<AcademicYear> academicOpt = academicYearRepository.findById(academicId);
		if(academicOpt.isPresent()) {
			AcademicYear academic = academicOpt.get();
			
			academic.setProgram(program);
			program.setAcademicyear(academic);
	
		}
		return programRepository.save(program);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Program> programOpt = programRepository.findById(id);
		
		programRepository.deleteById(programOpt.get().getId());
		
	}

	
	
	

}
