package com.loroko.planning.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Initiative extends Base {
	
	private static final long serialVersionUID = 1L;

	private String name; 
	
	private String description; 
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private TypeInitiative typeInitiative;
	
}
