package com.hostmdy.hmi.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Applicant")
public class Applicant {

	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long Id;
	  
	  @NotBlank(message = "Your name should not be blank")
	  private String fullname;
	  
	  @NotBlank(message = "Email should not be blank")
	  private String username;
	  
	  @NotBlank(message = "Phno should not be blank")
	  private String phno;
	  
	  private String street;
	  private String township;
	  private String city;
	  
//	  private Boolean confirm;
	  
	  @Enumerated(EnumType.STRING)
	  private ApplicationConfirm status;
	  
	  @Enumerated(EnumType.STRING)
	  private Gender gender;
	  
	  @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	  private EduBackground edu;
	  
	  @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	  private Experience exp;
	  
//	  @PrePersist
//	  public void beforeObjectCreate()
//	  {
//	    this.confirm=false;
//	  }
	
	@ManyToOne(fetch = FetchType.EAGER)
	//@JsonIgnore
	private Program program;
	
	

}
