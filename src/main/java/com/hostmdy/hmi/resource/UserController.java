package com.hostmdy.hmi.resource;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.hmi.config.JwtTokenProvider;
import com.hostmdy.hmi.domain.AcademicYear;
import com.hostmdy.hmi.domain.Program;
import com.hostmdy.hmi.domain.User;
import com.hostmdy.hmi.domain.security.Role;
import com.hostmdy.hmi.domain.security.UserRoles;
import com.hostmdy.hmi.payload.JwtLoginSuccessResponse;
import com.hostmdy.hmi.payload.LoginRequest;
import com.hostmdy.hmi.repository.ProgramRepository;
import com.hostmdy.hmi.service.MapValidationErrorService;
import com.hostmdy.hmi.service.RoleService;
import com.hostmdy.hmi.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	private static final String TOKEN_PREFIX = "Bearer ";
	
	private final UserService userService;
	private final RoleService roleService;
	private final AuthenticationManager authenticationManager;
	private final JwtTokenProvider tokenProvider;
	private final MapValidationErrorService mapErrorService;
	private final ProgramRepository programRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
	    System.out.println(loginRequest.getUsername());
	    System.out.println(loginRequest.getPassword());

	    ResponseEntity<?> errorResponse = mapErrorService.validate(result);
	    Optional<User> userOpt = userService.findByUsername(loginRequest.getUsername());
	    
	    if(userOpt.isEmpty())
	      return new ResponseEntity<String>("user not found",HttpStatus.NOT_FOUND);
	    
	    if(errorResponse != null)
	      return errorResponse;
	    
	    Authentication authentication = authenticationManager.authenticate(
	        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
	    System.out.println(authentication);
	    SecurityContextHolder.getContext().setAuthentication(authentication);

	    String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);

	    List<String> roleList = userOpt.get().getUserRoles().stream().map(ur -> ur.getRole().getName()).toList();
	    
	    return ResponseEntity.ok(new JwtLoginSuccessResponse(true, jwt, userOpt.get(), roleList));

	  
	  
	}
		

	@GetMapping("/all")
	public ResponseEntity<?> getAllUser(){
		System.out.println("333333333333333In the get all user functions");
		List<User> userList = userService.findAll();
		
		if(userList.isEmpty())
			return new ResponseEntity<String>("no user found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable Long id) {
		
		Optional<User> userOpt = userService.findById(id);
		if(userOpt.isEmpty()) {
			return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
	}
	
	@GetMapping("/username/{username}")
	public ResponseEntity<?> findByUserName(@PathVariable String username){
		Optional<User> userOpt = userService.findByUsername(username);
		
		if(userOpt.isEmpty())
			return new ResponseEntity<String>("User Name" + username +"not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<User>(userOpt.get(), HttpStatus.OK);
		
	}
	
	@PostMapping("/create/{programId}")
	public ResponseEntity<?> register(@Valid @RequestBody User user,@PathVariable Long programId) {
		Role role1 = new Role();
	     role1.setId(1L);
	     role1.setName("ROLE_STUDENT");
	    
	     Set<UserRoles> userRoles = new HashSet<>();
	     userRoles.add(new UserRoles(user, role1));
	   
	     return new ResponseEntity<User>(userService.createUser(user, userRoles, programId), HttpStatus.CREATED);
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> register(@Valid @RequestBody User user) {
		Role role1 = new Role();
	     role1.setId(1L);
	     role1.setName("ROLE_STUDENT");
	    
	     Set<UserRoles> userRoles = new HashSet<>();
	     userRoles.add(new UserRoles(user, role1));
	   
	     return new ResponseEntity<User>(userService.createUser(user, userRoles), HttpStatus.CREATED);
		
	}
	
	@PostMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return new ResponseEntity<User> (userService.saveUser(user),HttpStatus.CREATED);
		
	}
	@DeleteMapping("id/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		userService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}

}
