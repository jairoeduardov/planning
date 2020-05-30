package com.loroko.planning.model.services.implementations;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.loroko.planning.exceptions.CompanyException;

@Service
public class ServiceImpl <T, G, TE extends JpaRepository<G, T>> {

	@Autowired
	private TE te;
	
	public TE getRepository() {
		return te;
	}
	
	public Collection<G> findAll() {
		return te.findAll();
	}
	
	public G findById(T t) {
		return te.findById(t).orElseThrow( ()-> new CompanyException("Entity with ID : " + t + " Not found"));
	}
	
	public G save(G g) {
		return te.save(g);
	}
	/*
	public G edit(T t, G g) {
		
		return te.findById(t).map(
				entity -> {
					
					return te.save(entity);
				}).orElseGet(()->{
					return te.save(g);
				});
	}*/

	public void delete(T t) {
		te.delete( 
				te.findById(t).orElseThrow(()-> new CompanyException("Entity with ID : " + t + " Not found")) 
		);
	}
	
	public ResponseEntity<?> errorMap(BindingResult result){
		Map<String, Object> errorM = new HashMap<>();
		for(FieldError error : result.getFieldErrors()) {
			errorM.put(error.getField(), error.getDefaultMessage());
		}
		
		return new ResponseEntity<>(errorM, HttpStatus.BAD_REQUEST);
	}
	
}