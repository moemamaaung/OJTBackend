package com.hostmdy.hmi;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hostmdy.hmi.domain.Program;
import com.hostmdy.hmi.domain.User;
import com.hostmdy.hmi.domain.security.Role;
import com.hostmdy.hmi.domain.security.UserRoles;
import com.hostmdy.hmi.service.ProgramService;
import com.hostmdy.hmi.service.RoleService;
import com.hostmdy.hmi.service.UserService;

@SpringBootApplication
public class HostMyanmarInstituteApplication {

	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	ProgramService programService;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(HostMyanmarInstituteApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		Role role1 = new Role();
//		role1.setId(1L);
//		role1.setName("ROLE_USER");
//		
//		User user1 = new User();
//	
//		user1.setFullname("Aung Htet");
//		user1.setUsername("aah@gmail.com");
//		user1.setPassword(passwordEncoder.encode("1234") );
//	
//		
//		Set<UserRoles> userRoles1 = new HashSet<>();
//		userRoles1.add(new UserRoles(user1, role1));
//		
//		userService.createUser(user1, userRoles1, null);
//		
//		Role role2 = new Role();
//		role2.setId(2L);
//		role2.setName("ROLE_ADMIN");
//		
//		User user2 = new User();
//	
//		user2.setFullname("Mya Mya");
//		user2.setUsername("myamya@gmail.com");
//		user2.setPassword(passwordEncoder.encode("1234"));
//		
//		
//		
//		Set<UserRoles> userRoles2 = new HashSet<>();
//		userRoles2.add(new UserRoles(user2, role2));
//		
//		userService.createUser(user2,userRoles2,null);
		
	


}
