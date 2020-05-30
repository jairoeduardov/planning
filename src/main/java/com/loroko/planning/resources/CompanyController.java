package com.loroko.planning.resources;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.loroko.planning.assembler.CompanyResourceAssembler;
import com.loroko.planning.model.entities.Company;
import com.loroko.planning.model.services.CompanyService;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@RequestMapping("/plannings")
@CrossOrigin
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private CompanyResourceAssembler assembler;
	
	@GetMapping
	public Resources<Resource<Company>>getAll(){
		
		return new Resources<>(
				companyService.findAll().stream().map( entity -> assembler.toResource( entity )).collect(Collectors.toList()), 
				new Link("http://localhost:8080/plannings/").withRel("create")
				);
	}
	
	@GetMapping("/{id}")
	public Resource<?> getById(@PathVariable Long id){
		return new Resource<>(  
				assembler.toResource(companyService.findById(id))
				);
	}
	
	@PostMapping
	public Object create(@Valid @RequestBody Company company, BindingResult result) {
		
		if(result.hasErrors()) return companyService.errorMap(result);
		
		return new Resource<>( assembler.toResource(companyService.save(company)) );
	}
	
	@PutMapping("/{id}")
	public Object update(@PathVariable Long id, @Valid @RequestBody Company company, BindingResult result ) {
		
		if(result.hasErrors()) return companyService.errorMap(result);
		
		return new Resource<>(assembler.toResource(companyService.edit(id, company)));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		companyService.delete(id);
		return new ResponseEntity<String>("Company Deleted", HttpStatus.OK);
		
	}
	
	
	
	
}
