package com.hostmdy.hmi.domain;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Lecturer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String phoneNo;
	private String address;
	private String gender;
	private Integer age;
	private String qualification;
	
	
	
//	@OneToMany(mappedBy = "lecturer",fetch = FetchType.EAGER)
//	@JsonIgnore
//	private List<LecturerCourse> lecturerCourse;

}
