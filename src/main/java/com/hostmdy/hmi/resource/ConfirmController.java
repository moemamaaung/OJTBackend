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
import com.hostmdy.hmi.domain.Confirm;

import com.hostmdy.hmi.service.ConfirmService;
import com.hostmdy.hmi.service.MapValidationErrorService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/confirm")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ConfirmController {
	
	private ConfirmService confirmService;
	private MapValidationErrorService mapErrorService;
	
	public ConfirmController(ConfirmService confirmService, MapValidationErrorService mapErrorService) {
		super();
		this.confirmService = confirmService;
		this.mapErrorService = mapErrorService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createConfirm(@RequestBody Confirm confirm,BindingResult result){
	
				
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		

		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		

		Confirm createdConfirm= confirmService.saveorUpdate(confirm);
		
		return new ResponseEntity<Confirm>(createdConfirm,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public List<Confirm> findAll(){
		return confirmService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Confirm> confirmOptional = confirmService.findByConfirmId(id);
		
		if(confirmOptional.isEmpty())
			return new ResponseEntity<String>("Confirm with id = "+id+"is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<Confirm>(confirmOptional.get(),HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		 
		confirmService.deleteByConfirmId(id);
		return new ResponseEntity<String>("Delete id = "+id ,HttpStatus.OK);
	}

}
