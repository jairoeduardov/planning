package com.loroko.planning.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Stakeholder extends Base  {

	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Company company;
}
