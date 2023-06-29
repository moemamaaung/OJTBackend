package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.hmi.domain.security.Role;

public interface RoleService {
	Optional<Role> findById(Long id);
	
	List<Role> findAll();

}
