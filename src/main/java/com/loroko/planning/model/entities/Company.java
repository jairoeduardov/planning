package com.loroko.planning.model.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Company extends Base {
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	@NotNull
	private String name;

	public Company(String name) {
		this.name = name;
	}
	
	
}
