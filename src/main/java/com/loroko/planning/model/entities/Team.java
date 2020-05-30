package com.loroko.planning.model.entities;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team extends Base {
	
	private static final long serialVersionUID = 1L;

	private String firstName;
	
	private String lastName;
}
