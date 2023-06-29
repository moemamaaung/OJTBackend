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

import com.hostmdy.hmi.service.ApplicantService;
import com.hostmdy.hmi.service.MapValidationErrorService;


@RestController
@RequestMapping("/api/applicant")
@CrossOrigin(origins = "http://localhost:3000")
public class ApplicantController {
	
	private ApplicantService appService;
	private MapValidationErrorService mapErrorService;
	
	public ApplicantController(ApplicantService appService, MapValidationErrorService mapErrorService) {
		super();
		this.appService = appService;
		this.mapErrorService = mapErrorService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createApplicant(@RequestBody Applicant applicant,BindingResult result){
	
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		

		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		

		Applicant createdApplicant= appService.saveorUpdate(applicant);
		
		return new ResponseEntity<Applicant>(createdApplicant,HttpStatus.CREATED);
	
	}
	
	@GetMapping("/all")
	public List<Applicant> findAll(){
		return appService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Applicant> appOptional = appService.findByApplicantId(id);
		
		if(appOptional.isEmpty())
			return new ResponseEntity<String>("Applicant with id = "+id+"is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Applicant>(appOptional.get(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		 
		appService.deleteByApplicantId(id);
		return new ResponseEntity<String>("Delete id = "+id ,HttpStatus.OK);
	}
	
	
}
