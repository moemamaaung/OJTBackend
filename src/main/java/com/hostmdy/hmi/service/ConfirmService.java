package com.hostmdy.hmi.service;

import java.util.List;
import java.util.Optional;
import com.hostmdy.hmi.domain.Confirm;

public interface ConfirmService {
	
Confirm saveorUpdate(Confirm confirm);
	
	List<Confirm> findAll();
	
	Optional<Confirm> findByConfirmId(Long id);
	
	void deleteByConfirmId(Long id);

}
