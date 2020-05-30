package com.loroko.planning.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class CompanyAdvise  {
	
	@ResponseBody
	@ExceptionHandler(CompanyException.class)
	public final ResponseEntity<CompanyNotFoundResponse> companyNotFoundResponseEntity(CompanyException ex){
		CompanyNotFoundResponse response = new CompanyNotFoundResponse(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
