package com.hostmdy.hmi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.Lecturer;
import com.hostmdy.hmi.repository.LecturerRepository;
import com.hostmdy.hmi.service.LecturerService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService{

	private final LecturerRepository lecturerRepository;
	
	@Override
	public Lecturer createOrUpdateLecturer(Lecturer lecturer) {
		// TODO Auto-generated method stub
		return lecturerRepository.save(lecturer);
	}

	@Override
	public List<Lecturer> fillAllLecturers() {
		// TODO Auto-generated method stub
		return (List<Lecturer>) lecturerRepository.findAll();
	}

	@Override
	public Optional<Lecturer> findById(Long id) {
		// TODO Auto-generated method stub
		return lecturerRepository.findById(id);
	}

	@Override
	public Optional<Lecturer> findByName(String name) {
		// TODO Auto-generated method stub
		return lecturerRepository.findByName(name);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		lecturerRepository.deleteById(id);
		
	}

}
