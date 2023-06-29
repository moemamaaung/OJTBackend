package com.hostmdy.hmi.resource;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.hmi.domain.security.Role;
import com.hostmdy.hmi.service.RoleService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/role")
@RequiredArgsConstructor
public class RoleController {
	
	private  final RoleService roleService;
	
	@GetMapping("/all")
	public List<Role> getAllRole(){
		return roleService.findAll();
		
	}

}
