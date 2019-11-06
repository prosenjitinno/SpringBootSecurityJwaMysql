package com.example.SpringBootSecurityJwaMysql.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static long serialVersionUID = -8091879091924046844L;
	
	private final String jwtToken;

	public JwtResponse(String jwtToken) {
		super();
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}
	
	
	
	
}
