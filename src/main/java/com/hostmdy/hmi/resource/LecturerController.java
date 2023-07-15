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
import com.hostmdy.hmi.domain.Lecturer;
import com.hostmdy.hmi.service.LecturerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/lecturer")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class LecturerController {
	
	private final LecturerService lecturerService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createLecturer(@RequestBody Lecturer lecturer){
		
		Lecturer createdLecturer = lecturerService.createOrUpdateLecturer(lecturer);
		return new ResponseEntity<Lecturer>(createdLecturer, HttpStatus.OK);
	}
	
	@PatchMapping("/update")
	public ResponseEntity<?> updateLecturer(@RequestBody Lecturer lecturer){
		Lecturer updatedLecturer = lecturerService.createOrUpdateLecturer(lecturer);
		return new ResponseEntity<Lecturer>(updatedLecturer, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Lecturer> findAllLecturers(){
		return lecturerService.fillAllLecturers();
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Lecturer> lecturerOpt = lecturerService.findById(id);
		
		if(lecturerOpt.isEmpty())
			return new ResponseEntity<String>("LecturerId"+id+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Lecturer>(lecturerOpt.get(),HttpStatus.OK);
		
	}
	
	
	@GetMapping("/lecturerName/{name}")
	public ResponseEntity<?> findByLecturerName(@PathVariable String name){
		Optional<Lecturer> lecturerOpt = lecturerService.findByName(name);
		
		if(lecturerOpt.isEmpty())
			return new ResponseEntity<String>("Lecturer Name" + name +"not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Lecturer>(lecturerOpt.get(), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		lecturerService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}
	

}
