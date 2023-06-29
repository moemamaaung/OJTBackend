package com.hostmdy.hmi.serviceImpl;

import java.util.List;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.Experience;
import com.hostmdy.hmi.repository.ExperienceRepo;
import com.hostmdy.hmi.service.ExperienceService;

@Service
public class ExperienceImpl implements ExperienceService{
	
	private final ExperienceRepo experienceRepo;
	
	public ExperienceImpl(ExperienceRepo experienceRepo) {
		super();
		this.experienceRepo = experienceRepo;
	}

	@Override
	public Experience saveorUpdate(Experience experience) {
		// TODO Auto-generated method stub
		return experienceRepo.save(experience);
	}

	@Override
	public List<Experience> findAll() {
		// TODO Auto-generated method stub
		return (List<Experience>) experienceRepo.findAll();
	}

	@Override
	public Optional<Experience> findByExperienceId(Long id) {
		// TODO Auto-generated method stub
		return experienceRepo.findById(id);
	}

	@Override
	public void deleteByExperienceId(Long id) {
		experienceRepo.deleteById(id);
		
	}
	
	

}
