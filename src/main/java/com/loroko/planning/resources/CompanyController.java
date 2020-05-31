package com.loroko.planning.resources;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.loroko.planning.model.entities.Company;
import com.loroko.planning.model.services.CompanyService;

@RestController
@RequestMapping("/plannings")
@CrossOrigin
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	
	
	//@RequestMapping(value = "{id}")
	//@PathVariable String id)
	//@RequestParam
	@GetMapping(value = "/{id}")
	public HttpEntity<Company> getEntity( @PathVariable(value = "id") Long id ){		
		
		Company company = new Company();
		
		//companyService.findById(id)
		
		company.add( linkTo( methodOn(CompanyController.class).companyService.findById(id) ).withSelfRel());
		
		return new ResponseEntity<>(company, HttpStatus.OK);
		
	}
	
		
}
