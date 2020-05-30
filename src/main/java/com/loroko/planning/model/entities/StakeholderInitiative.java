package com.loroko.planning.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class StakeholderInitiative extends Base {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Initiative initiative;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private Stakeholder stakeholder;
	
	
	
}
