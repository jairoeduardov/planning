package com.loroko.planning.model.services;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface BaseService<T, TE> {
		
	public TE findById(T t);
	
	public Collection<TE> findAll();
	
	public TE save(TE te);
	
	public TE edit(T t, TE te);
	
	public void delete(T t);
	
	public ResponseEntity<?> errorMap(BindingResult result);
	
}