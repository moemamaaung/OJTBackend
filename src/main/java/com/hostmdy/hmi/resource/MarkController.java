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


import com.hostmdy.hmi.domain.Mark;
import com.hostmdy.hmi.service.MarkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mark")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class MarkController {
	
	private final MarkService markService;
	
	@GetMapping("/all")
	public List<Mark> getAllMark(){
		 return markService.findAll();
		
	}
	
	@PostMapping("/create/{courseId}/{examId}")
	public ResponseEntity<?> createMark(@RequestBody Mark mark,@PathVariable Long courseId,@PathVariable Long examId){
		
		Mark savedMark = markService.create(mark, courseId, examId);
		return new ResponseEntity<Mark>(savedMark,HttpStatus.CREATED);
	}
	
	@PatchMapping("/update/{courseId}/{examId}")
	public ResponseEntity<?> updateMark(@RequestBody Mark mark,@PathVariable Long courseId,@PathVariable Long examId){
		Mark updatedMark = markService.updateMark(mark,courseId,examId);
		
		return new ResponseEntity<Mark>(updatedMark, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		
		markService.deleteById(id);
		
		return new ResponseEntity<Number>(id,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> getMarkById(@PathVariable Long id) {
		
		Optional<Mark> markOpt = markService.findById(id);
		
		if(markOpt.isEmpty()) {
			return  new ResponseEntity<String>("Mark not found!", HttpStatus.OK);
		}
		
		return new ResponseEntity<Mark>(markOpt.get(), HttpStatus.OK);
	}
}
