package com.hostmdy.hmi.resource;

import java.util.List;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.hmi.domain.Applicant;
import com.hostmdy.hmi.domain.Experience;
import com.hostmdy.hmi.service.ApplicantService;
import com.hostmdy.hmi.service.ExperienceService;
import com.hostmdy.hmi.service.MapValidationErrorService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/exp")
@CrossOrigin(origins = "http://localhost:3000")
public class ExperienceController {
	
	private ExperienceService experienceService;
	private MapValidationErrorService mapErrorService;
	private ApplicantService appService;
	
	public ExperienceController(ExperienceService experienceService, MapValidationErrorService mapErrorService,ApplicantService applicantService) {
		super();
		this.experienceService = experienceService;
		this.mapErrorService = mapErrorService;
		this.appService = applicantService;
	}
	
	@PostMapping("/create/{applicantId}")
	public ResponseEntity<?> createExperience(@Valid @RequestBody Experience experience,@PathVariable String applicantId,BindingResult result){
		Long appId = Long.parseLong(applicantId);
		System.out.println("Applicant Id is "+appId);
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		System.out.println(experience);
	
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		
		
		Applicant applicant=appService.findByApplicantId(appId).get();
		Experience createdExperience = experienceService.saveorUpdate(experience);
		applicant.setExp(createdExperience);
		
		Applicant createdApplicant = appService.saveorUpdate(applicant, appId);
		return new ResponseEntity<Applicant>(createdApplicant,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public List<Experience> findAll(){
		return experienceService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Experience> expOptional = experienceService.findByExperienceId(id);
		
		if(expOptional.isEmpty())
			return new ResponseEntity<String>("Experience with id = "+id+" is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Experience>(expOptional.get(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		
		experienceService.deleteByExperienceId(id);
		return new ResponseEntity<String>("Delete id = "+id,HttpStatus.OK);
	}
	
	

}
