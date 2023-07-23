package com.hostmdy.hmi.serviceImpl;

import java.util.List;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.AcademicYear;
import com.hostmdy.hmi.domain.Applicant;
import com.hostmdy.hmi.domain.ApplicationConfirm;
import com.hostmdy.hmi.domain.EduBackground;
import com.hostmdy.hmi.domain.Experience;
import com.hostmdy.hmi.domain.Program;
import com.hostmdy.hmi.repository.ApplicantRepo;
import com.hostmdy.hmi.repository.EduBackgroundRepo;
import com.hostmdy.hmi.repository.ExperienceRepo;
import com.hostmdy.hmi.repository.ProgramRepository;
import com.hostmdy.hmi.service.ApplicantService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApplicantServiceImpl implements ApplicantService{

	
	private final ApplicantRepo applicantRepo;
	private final  ProgramRepository programRepository;
	private final EduBackgroundRepo eduBackgroundRepo;
	private final ExperienceRepo experienceRepo;
	

	@Override
	public List<Applicant> findAll() {
		
		return (List<Applicant>) applicantRepo.findAll();
	}

	@Override
	public Optional<Applicant> findByApplicantId(Long id) {
		// TODO Auto-generated method stub
		return applicantRepo.findById(id);
	}

	@Override
	public void deleteByApplicantId(Long id) {
		// TODO Auto-generated method stub
		applicantRepo.deleteById(id);
	
	}

	@Override
	public Applicant saveorUpdate(Applicant applicant,Long programId) {
		
		Optional<Program> programOpt = programRepository.findById(programId);
		if(programOpt.isPresent()) {
			Program program = programOpt.get();
			
			applicant.setProgram(program);
			program.getApplicants().add(applicant);
	
		}
		return applicantRepo.save(applicant);
	}

	@Override
	public Applicant update(Applicant applicant, Long programId, Long eduId, Long expId) {
		// TODO Auto-generated method stub
		Optional<Program> programOpt = programRepository.findById(programId);
	    Optional<EduBackground> eduOpt = eduBackgroundRepo.findById(eduId);
	    Optional<Experience> expOpt = experienceRepo.findById(expId);
	        if(programOpt.isPresent()&& eduOpt.isPresent()&& expOpt.isPresent()) {
	          Experience exp = expOpt.get();
	          exp.setApplicant(applicant);
	          applicant.setExp(exp);
	          EduBackground edu = eduOpt.get();
	          edu.setApplicant(applicant);
	          applicant.setEdu(edu);
	          Program program = programOpt.get();
	          applicant.setProgram(program);
	          program.getApplicants().add(applicant);
	          
	        }
	      
	      applicant.setStatus(ApplicationConfirm.Confirmed);
	  
	    
	    return applicantRepo.save(applicant);
	}

	
	
}
