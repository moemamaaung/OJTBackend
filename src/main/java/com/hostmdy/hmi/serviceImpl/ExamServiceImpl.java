package com.hostmdy.hmi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.Exam;
import com.hostmdy.hmi.repository.ExamRepository;
import com.hostmdy.hmi.service.ExamSercice;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamSercice{
	
	private final ExamRepository examRepository;

	@Override
	public List<Exam> findAll() {
		// TODO Auto-generated method stub
		return (List<Exam>) examRepository.findAll();
	}

	@Override
	public Exam createOrUpdate(Exam exam) {
		// TODO Auto-generated method stub
		return examRepository.save(exam);
	}

	@Override
	public Optional<Exam> findById(Long id) {
		// TODO Auto-generated method stub
		return examRepository.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		examRepository.deleteById(id);
	}

}
