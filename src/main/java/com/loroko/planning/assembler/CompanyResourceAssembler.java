package com.loroko.planning.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.loroko.planning.model.entities.Company;
import com.loroko.planning.resources.CompanyController;
import org.springframework.hateoas.Link;

@Component
public class CompanyResourceAssembler implements ResourceAssembler<Company, Resource<Company>> {

	@Override
	public Resource<Company> toResource(Company entity) {
		
		return new Resource<>(
				entity,
				linkTo(methodOn(CompanyController.class).getById(entity.getId())).withSelfRel(), 
				linkTo(methodOn(CompanyController.class).delete(entity.getId())).withRel("delete"), 
				linkTo(methodOn(CompanyController.class).getAll()).withRel("all"), 
				new Link("http://localhost:8080/plannings/" + entity.getId()).withRel("update")
				
				);
	}

}
