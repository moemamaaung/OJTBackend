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
import com.hostmdy.hmi.domain.EduBackground;
import com.hostmdy.hmi.service.ApplicantService;
import com.hostmdy.hmi.service.EduBackgroundServie;
import com.hostmdy.hmi.service.MapValidationErrorService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/api/edu")
@CrossOrigin(origins = "http://localhost:3000")
public class EduBackgroundController {
	
	private EduBackgroundServie eduService;
	private MapValidationErrorService mapErrorService;
	private ApplicantService applicantService;
	
	
	
	public EduBackgroundController(EduBackgroundServie eduService, MapValidationErrorService mapErrorService, ApplicantService applicantService) {
		super();
		this.eduService = eduService;
		this.mapErrorService = mapErrorService;
		this.applicantService=applicantService;
	}
	
	
	@PostMapping("/create/{applicantId}")
	public ResponseEntity<?> createEduBackground(@Valid @RequestBody EduBackground eduBackground,@PathVariable String applicantId,BindingResult result){
		Long appId=Long.parseLong(applicantId);
		System.out.println("Applicant Id is "+appId);
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		System.out.println(eduBackground);
	
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		
		//get applicant obj
		Applicant applicant=applicantService.findByApplicantId(appId).get();
		EduBackground createdEduBackground = eduService.saveorUpdate(eduBackground);
		applicant.setEdu(createdEduBackground);
		//applicantService.saveorUpdate(applicant);
		Applicant createdApplicant = applicantService.saveorUpdate(applicant);
		
		return new ResponseEntity<Applicant>(createdApplicant,HttpStatus.CREATED);	
	}
	
	@GetMapping("/all")
	public List<EduBackground> findAll(){
		return eduService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<EduBackground> eduOptional = eduService.findByEduBackgroundId(id);
		
		if(eduOptional.isEmpty())
			return new ResponseEntity<String>("EducationBackground with id = "+id+"is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<EduBackground>(eduOptional.get(),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		
		eduService.deleteByEduBackgroundId(id);
		return new ResponseEntity<String>("Delete id = "+id,HttpStatus.OK);
	}
	

}
