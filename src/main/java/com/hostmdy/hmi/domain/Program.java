package com.hostmdy.hmi.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter @Setter
@NoArgsConstructor
public class Program {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "programName is required")
	private String programName;
	
	private String programFee;

	@OneToMany(mappedBy = "program")
	@JsonIgnore
	private Set<Applicant> applicants = new HashSet<>();
	
	@OneToOne(mappedBy = "program")
	@JsonIgnore
	private Time time;
	
	@OneToMany(mappedBy = "program")
	 @JsonIgnore
	 private Set<User> users = new HashSet<>();
	
	@OneToOne(fetch = FetchType.EAGER)
	private AcademicYear academicyear;
	
	@OneToMany(mappedBy = "program")
	@JsonIgnore
	private List<Course> course;



	
	
	

	


	

	
	

	

	
	


	
	
	
}
