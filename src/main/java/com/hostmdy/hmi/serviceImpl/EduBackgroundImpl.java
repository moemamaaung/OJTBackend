package com.hostmdy.hmi.serviceImpl;

import java.util.List;


import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.EduBackground;

import com.hostmdy.hmi.repository.EduBackgroundRepo;
import com.hostmdy.hmi.service.EduBackgroundServie;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EduBackgroundImpl implements EduBackgroundServie{
	
	private final EduBackgroundRepo eduRepo;
	
	



	@Override
	public EduBackground saveorUpdate(EduBackground edubackground) {
		
		
//		Applicant applicant = applicantRepo.findById(id).get();
//		
//		applicant.setEdu(edubackground);
//		edubackground.setApplicant(applicant);
//		applicant.getEdu().getApplicant();
		return eduRepo.save(edubackground);
	}

	@Override
	public List<EduBackground> findAll() {
		// TODO Auto-generated method stub
		return (List<EduBackground>) eduRepo.findAll();
	}

	@Override
	public Optional<EduBackground> findByEduBackgroundId(Long id) {
		// TODO Auto-generated method stub
		return eduRepo.findById(id);
	}

	@Override
	public void deleteByEduBackgroundId(Long id) {
		// TODO Auto-generated method stub
		eduRepo.deleteById(id);
		
	}

}
