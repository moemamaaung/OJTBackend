package com.hostmdy.hmi.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.hmi.domain.AcademicYear;

import com.hostmdy.hmi.service.AcademicYearService;

@RestController
@RequestMapping("/api/academicyear")
@CrossOrigin(origins = "http://localhost:3000")
public class AcademicYearController {

	private final AcademicYearService academicYearService;

	@Autowired
	public AcademicYearController(AcademicYearService academicYearService) {
		super();
		this.academicYearService = academicYearService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<AcademicYear> createAcademicyear(@RequestBody AcademicYear academicYear){
		AcademicYear createdAcademicyear = academicYearService.createAcademicYear(academicYear);
		return new ResponseEntity<AcademicYear>(createdAcademicyear, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<AcademicYear> findAllAcademicyear(){
		return academicYearService.findAll();
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<AcademicYear> AcademicyearOptional = academicYearService.findByAcademicYearId(id);
		
		if(AcademicyearOptional.isEmpty())
			return new ResponseEntity<String>("AcademicYearId"+id+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<AcademicYear>(AcademicyearOptional.get(),HttpStatus.OK);
		
	}
	
	@PatchMapping("/update")
	public ResponseEntity<?> updateAcademicyear(@RequestBody AcademicYear academicYear){
		AcademicYear updateAcademicyear = academicYearService.updateAcademicYear(academicYear);
		return new ResponseEntity<AcademicYear>(updateAcademicyear,HttpStatus.OK);
		
	}
	@DeleteMapping("id/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		academicYearService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}
	
	
}
