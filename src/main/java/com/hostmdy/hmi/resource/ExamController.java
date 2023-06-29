package com.hostmdy.hmi.resource;

import java.util.List;
import java.util.Optional;

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

import com.hostmdy.hmi.domain.Exam;
import com.hostmdy.hmi.service.ExamSercice;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/exam")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ExamController {
	
	private final ExamSercice examSercice;
	
	@PostMapping("/create")
	public ResponseEntity<?> createExam(@RequestBody Exam exam){
		Exam createdExam = examSercice.createOrUpdate(exam);
		return new ResponseEntity<Exam>(createdExam,HttpStatus.CREATED);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<?> updateExam(@RequestBody Exam exam){
		Exam updatedExam = examSercice.createOrUpdate(exam);
		return new ResponseEntity<Exam>(updatedExam,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Exam> getAllExam(){
		return examSercice.findAll();
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		examSercice.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Exam> examOpt = examSercice.findById(id);
		
		if(examOpt.isEmpty()) {
			return new ResponseEntity<String> ("Exam id "+id+" not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Exam>(examOpt.get(),HttpStatus.OK);
	}

}
