package com.example.SpringBootSecurityJwaMysql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.SpringBootSecurityJwaMysql.config.JwtTokenUtil;
import com.example.SpringBootSecurityJwaMysql.model.Employee;
import com.example.SpringBootSecurityJwaMysql.model.JwtRequest;
import com.example.SpringBootSecurityJwaMysql.model.JwtResponse;
import com.example.SpringBootSecurityJwaMysql.service.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired 
	private JwtUserDetailsService jwtUserDetailsService;
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationManagerRequest ) throws Exception {
		
		authenticate(authenticationManagerRequest.getUsername(), authenticationManagerRequest.getPassword());
		
		final UserDetails userDetails = jwtUserDetailsService
				.loadUserByUsername(authenticationManagerRequest.getUsername());
		
		final String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody Employee employeeDetails ) throws Exception{
		return ResponseEntity.ok(jwtUserDetailsService.save(employeeDetails));
	}

	private void authenticate(String username, String password) throws Exception{
		// TODO Auto-generated method stub
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}catch(DisabledException e){
			throw new Exception("Disabled Exception : " + e);
		}catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials : " + e);
		}
		
	}
}
