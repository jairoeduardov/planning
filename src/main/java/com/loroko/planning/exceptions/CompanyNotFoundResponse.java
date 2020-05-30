package com.loroko.planning.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyNotFoundResponse {
	
	private String notFound;

	public CompanyNotFoundResponse(String notFound) {
		this.notFound = notFound;
	}

	
}
