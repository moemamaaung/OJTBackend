package com.hostmdy.hmi.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.hmi.domain.User;



public interface UserRepo extends CrudRepository<User, Long>{

	Optional<User> findByUsername(String username);
}
