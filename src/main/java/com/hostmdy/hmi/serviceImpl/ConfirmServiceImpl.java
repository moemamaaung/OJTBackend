package com.hostmdy.hmi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.Confirm;
import com.hostmdy.hmi.repository.ConfirmRepo;
import com.hostmdy.hmi.service.ConfirmService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ConfirmServiceImpl implements ConfirmService{
	
	private final ConfirmRepo confirmRepo;

	@Override
	public Confirm saveorUpdate(Confirm confirm) {
		// TODO Auto-generated method stub
		return confirmRepo.save(confirm);
	}

	@Override
	public List<Confirm> findAll() {
		// TODO Auto-generated method stub
		return (List<Confirm>) confirmRepo.findAll();
	}

	@Override
	public Optional<Confirm> findByConfirmId(Long id) {
		// TODO Auto-generated method stub
		return confirmRepo.findById(id);
	}

	@Override
	public void deleteByConfirmId(Long id) {
		confirmRepo.deleteById(id);
		
	}

}
