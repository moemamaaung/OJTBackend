package com.hostmdy.hmi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
@Table(name="Confirm")
public class Confirm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@NotBlank(message = "Your name should not be blank")
	private String name;
	
	@NotBlank(message = "Email should not be blank")
	private String email;
	
	@NotBlank(message = "Phno should not be blank")
	private String phno;
	
	private String street;
	private String township;
	private String city;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

}
