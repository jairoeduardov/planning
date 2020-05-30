package com.loroko.planning.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Planning  extends Base {
	
	private static final long serialVersionUID = 1L;

	
	private String comment;
	
	private Date phaseDate; 

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phase_id")
	private Phase phase;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "initiative_id")
	private Initiative initiative;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "master_id")
	private Master master;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner_id")
	private Owner owner;	
}
