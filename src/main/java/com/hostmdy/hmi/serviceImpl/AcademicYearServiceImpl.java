package com.hostmdy.hmi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.AcademicYear;
import com.hostmdy.hmi.repository.AcademicYearRepository;
import com.hostmdy.hmi.service.AcademicYearService;

@Service
public class AcademicYearServiceImpl implements AcademicYearService{

	private final AcademicYearRepository academicYearRepository;
	
	
	public AcademicYearServiceImpl(AcademicYearRepository academicYearRepository) {
		super();
		this.academicYearRepository = academicYearRepository;
	}

	@Override
	public AcademicYear createAcademicYear(AcademicYear academicYear) {
		// TODO Auto-generated method stub
		return academicYearRepository.save(academicYear);
	}

	@Override
	public List<AcademicYear> findAll() {
		// TODO Auto-generated method stub
		return (List<AcademicYear>) academicYearRepository.findAll();
	}

	@Override
	public Optional<AcademicYear> findByAcademicYearId(Long id) {
		// TODO Auto-generated method stub
		return academicYearRepository.findById(id);
	}

	@Override
	public AcademicYear updateAcademicYear(AcademicYear academicYear) {
		// TODO Auto-generated method stub
		return academicYearRepository.save(academicYear);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<AcademicYear> academicOpt = academicYearRepository.findById(id);
		academicYearRepository.deleteById(academicOpt.get().getId());
		
	}

}
