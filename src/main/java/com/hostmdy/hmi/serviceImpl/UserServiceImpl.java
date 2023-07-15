package com.hostmdy.hmi.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostmdy.hmi.domain.AcademicYear;
import com.hostmdy.hmi.domain.Program;
import com.hostmdy.hmi.domain.User;
import com.hostmdy.hmi.domain.security.UserRoles;
import com.hostmdy.hmi.exception.UsernameAlreadyExistsException;
import com.hostmdy.hmi.repository.ProgramRepository;
import com.hostmdy.hmi.repository.RoleRepository;
import com.hostmdy.hmi.repository.UserRepo;
import com.hostmdy.hmi.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	
	private final UserRepo userRepo;
	private final RoleRepository roleRepository;
	private final ProgramRepository programRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Optional<User> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByUsername(username);
	}
	
	

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		
		return userRepo.save(user);
	}

	
	@Override
//	@Transactional
	public User createUser(User user,Set<UserRoles> userRoles,Long programId) throws UsernameAlreadyExistsException{
		// TODO Auto-generated method stub
		System.out.println("ProgramId"+ programId);
		
		Optional<User> userOpt = findByUsername(user.getUsername());
		

		 Optional<Program> programOpt = programRepository.findById(programId);
			if(programOpt.isPresent()) {
				Program program = programOpt.get();
				
				program.getUsers().add(user);
				user.setProgram(program);
		
			}
		
		
		if(userOpt.isPresent()) {
			throw new UsernameAlreadyExistsException("Username already exists!");
		}
		userRoles.forEach(ur -> roleRepository.save(ur.getRole()));
		
		user.getUserRoles().addAll(userRoles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
	
		return saveUser(user);
	}

	@Override
	public Optional<User> findById(Long id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public User updateUser(User user,Long programId) {
		// TODO Auto-generated method stub
		Optional<Program> programOpt = programRepository.findById(programId);
		if(programOpt.isPresent()) {
			Program program = programOpt.get();
			
			program.getUsers().add(user);
			user.setProgram(program);
	
		}
		return userRepo.save(user);
	}

	@Override
	public void deleteById(Long id) {
		
		Optional<User> userOpt = userRepo.findById(id);
		
		userRepo.deleteById(userOpt.get().getId());
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return (List<User>) userRepo.findAll();
	}



	@Override
	public Optional<Program> findByProgramName(String programName) {
		// TODO Auto-generated method stub
		return programRepository.findByProgramName(programName);
	}



	@Override
	public User createUser(User user, Set<UserRoles> userRoles) {
		// TODO Auto-generated method stub
		Optional<User> userOpt = findByUsername(user.getUsername());
		if(userOpt.isPresent()) {
			throw new UsernameAlreadyExistsException("Username already exists!");
		}
		userRoles.forEach(ur -> roleRepository.save(ur.getRole()));
		
		user.getUserRoles().addAll(userRoles);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		user.setPassword(user.getPassword());
	
		return saveUser(user);
	}



	@Override
	public User updatePassword(User user,Long programId) {
		Optional<Program> programOpt = programRepository.findById(programId);
		if(programOpt.isPresent()) {
			Program program = programOpt.get();
			
			program.getUsers().add(user);
			user.setProgram(program);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
	
		}
		 
		 return saveUser(user);
	}

	

}
