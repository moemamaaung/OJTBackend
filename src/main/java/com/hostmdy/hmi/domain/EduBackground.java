package com.hostmdy.hmi.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EduBackground")
public class EduBackground {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Your Education should not be blank")
	private String education;
	
	private String degree;
	private String university;
	private String startDate;
	private String endDate;
	
	@OneToOne(mappedBy="edu")
	@JsonIgnore
	private Applicant applicant;
	

}
