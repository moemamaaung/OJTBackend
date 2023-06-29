package com.hostmdy.hmi.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.hmi.domain.Program;
import com.hostmdy.hmi.domain.Time;
import com.hostmdy.hmi.repository.ProgramRepository;
import com.hostmdy.hmi.repository.TimeRepository;
import com.hostmdy.hmi.service.TimeService;

@Service
public class TimeServiceImpl implements TimeService{

	private final TimeRepository timeRepository;
	private final ProgramRepository programRepository;
	
	public TimeServiceImpl(TimeRepository timeRepository, ProgramRepository programRepository) {
		super();
		this.timeRepository = timeRepository;
		this.programRepository = programRepository;
	}

	@Override
	public Time createTime(Time time, Long programId) {
		// TODO Auto-generated method stub
		Optional<Program> programOpt = programRepository.findById(programId);
		if(programOpt.isPresent()) {
			Program program = programOpt.get();
			
			program.setTime(time);
			time.setProgram(program);
	
		}
		return timeRepository.save(time);
	}

	@Override
	public Time createTime(Time time) {
		// TODO Auto-generated method stub
		return timeRepository.save(time);
	}

	@Override
	public List<Time> findAll() {
		// TODO Auto-generated method stub
		return (List<Time>) timeRepository.findAll();
	}

	@Override
	public Optional<Time> findByTimeId(Long id) {
		// TODO Auto-generated method stub
		return timeRepository.findById(id);
	}

	@Override
	public Time updateTime(Time time, Long programId) {
		// TODO Auto-generated method stub
		Optional<Program> programOpt = programRepository.findById(programId);
		if(programOpt.isPresent()) {
			Program program = programOpt.get();
			
			program.setTime(time);
			time.setProgram(program);
	
		}
		return timeRepository.save(time);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
//		Optional<Time> timeOpt = timeRepository.findById(id);
		timeRepository.deleteById(id);
	}

}
