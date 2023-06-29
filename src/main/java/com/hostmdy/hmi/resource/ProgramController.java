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

import com.hostmdy.hmi.domain.Program;
import com.hostmdy.hmi.service.ProgramService;

@RestController
@RequestMapping("/api/program")
@CrossOrigin(origins = "http://localhost:3000")
public class ProgramController {
	private final ProgramService programService;

	@Autowired
	public ProgramController(ProgramService programService) {
		super();
		this.programService = programService;
	}
	
	@PostMapping("/create/{academicId}")
	public ResponseEntity<Program> createProgram(@RequestBody Program program,@PathVariable Long academicId){
		Program createdProgram = programService.createProgram(program,academicId);
		return new ResponseEntity<Program>(createdProgram, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Program> findAllProgram(){
		return programService.findAll();
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Program> programOptional = programService.findByProgramId(id);
		
		if(programOptional.isEmpty())
			return new ResponseEntity<String>("ProgramId"+id+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Program>(programOptional.get(),HttpStatus.OK);
		
	}
	
	@GetMapping("/programName/{programName}")
	public ResponseEntity<?> findByProgramName(@PathVariable String programName){
		Optional<Program> programOpt = programService.findByProgramName(programName);
		
		if(programOpt.isEmpty())
			return new ResponseEntity<String>("Program Name" + programName +"not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Program>(programOpt.get(), HttpStatus.OK);
		
	}
	
	@PatchMapping("/update/{academicId}")
	public ResponseEntity<?> updateProgram(@RequestBody Program program,@PathVariable Long academicId){
		Program updatedProgram = programService.updateProgram(program,academicId);
		return new ResponseEntity<Program>(updatedProgram,HttpStatus.OK);
		
	}
	@DeleteMapping("id/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		programService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}

}
