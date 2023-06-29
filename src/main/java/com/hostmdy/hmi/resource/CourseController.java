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

import com.hostmdy.hmi.domain.Course;
import com.hostmdy.hmi.service.CourseService;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "http://localhost:3000")
public class CourseController {

	private final CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
	
	@PostMapping("/create/{programId}")
	public ResponseEntity<?> createCourse(@RequestBody Course course,@PathVariable Long programId){
		
		Course createdCourse = courseService.createCourse(course,programId); 
		return new ResponseEntity<Course>(createdCourse, HttpStatus.OK);
	}
	
	@PatchMapping("/update/{programId}")
	public ResponseEntity<?> updateCourse(@RequestBody Course course,@PathVariable Long programId){
		Course updateCourse = courseService.updateCourse(course, programId);
		return new ResponseEntity<Course>(updateCourse, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Course> findAllCourse(){
		return courseService.findAll();
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Course> courseOptional = courseService.findById(id);
		
		if(courseOptional.isEmpty())
			return new ResponseEntity<String>("CourseId"+id+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Course>(courseOptional.get(),HttpStatus.OK);
		
	}
	
//	@GetMapping("/subjectName/{subjectName}")
//	public ResponseEntity<?> findByProgramName(@PathVariable String subjectName){
//		Optional<Course> courseOpt = courseService.findBySubjectName(subjectName);
//		
//		if(courseOpt.isEmpty())
//			return new ResponseEntity<String>("Course Name" + subjectName +"not found", HttpStatus.NOT_FOUND);
//		
//		return new ResponseEntity<Course>(courseOpt.get(), HttpStatus.OK);
//		
//	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		courseService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}
	
}
