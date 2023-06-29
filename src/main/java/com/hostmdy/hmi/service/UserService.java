package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.hostmdy.hmi.domain.Program;
import com.hostmdy.hmi.domain.User;
import com.hostmdy.hmi.domain.security.UserRoles;

public interface UserService {
	
	Optional<User> findByUsername(String username);
	
	User saveUser(User user);
	
	User createUser(User user,Set<UserRoles> userRoles);
	
	User createUser(User user,Set<UserRoles> userRoles,Long programId);
	
	User updateUser(User user);
	
	Optional<User> findById(Long id);
	
	void deleteById(Long id);
	
	Optional<Program> findByProgramName(String programName);
	
	List<User> findAll();
	

}
