package com.loroko.planning.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class TeamInitiative extends Base {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Initiative initiative;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Team team;
}
