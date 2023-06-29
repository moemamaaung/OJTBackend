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

import com.hostmdy.hmi.domain.Time;
import com.hostmdy.hmi.service.TimeService;

@RestController
@RequestMapping("/api/time")
@CrossOrigin(origins = "http://localhost:3000")
public class TimeController {
	private final TimeService timeService;

	public TimeController(TimeService timeService) {
		super();
		this.timeService = timeService;
	}
	
	@PostMapping("/create/{programId}")
	public ResponseEntity<Time> createTime(@RequestBody Time time,@PathVariable Long programId){
		Time createdTime = timeService.createTime(time,programId);
		return new ResponseEntity<Time>(createdTime, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<Time> findAllTime(){
		return timeService.findAll();
		
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Time> timeOptional = timeService.findByTimeId(id);
		
		if(timeOptional.isEmpty())
			return new ResponseEntity<String>("AcademicYearId"+id+ "not found", HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Time>(timeOptional.get(),HttpStatus.OK);
		
	}
	
	@PostMapping("/update/{programId}")
	public ResponseEntity<?> updateTime(@RequestBody Time time,@PathVariable Long programId){
		Time updateTime = timeService.updateTime(time,programId);
		return new ResponseEntity<Time>(updateTime,HttpStatus.OK);
		
	}
	@DeleteMapping("id/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id){
		timeService.deleteById(id);
		return new ResponseEntity<Number>(id,HttpStatus.OK);
		
	}

}
