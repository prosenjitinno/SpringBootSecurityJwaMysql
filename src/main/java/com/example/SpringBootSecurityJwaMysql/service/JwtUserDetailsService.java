package com.example.SpringBootSecurityJwaMysql.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringBootSecurityJwaMysql.dao.UserDao;
import com.example.SpringBootSecurityJwaMysql.model.Employee;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired 
	private UserDao userDao;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Employee employee = userDao.findByEmpName(username);
		if(employee == null) {
			throw new UsernameNotFoundException("User not found with username" + username);
		}
		
		return new org.springframework.security.core.userdetails.User(employee.getEmpName(), employee.getPassword(),
				new ArrayList<>());
	}
	
	public Employee save(Employee employee) {
		Employee newEmployee = new Employee();
		newEmployee.setEmpName(employee.getEmpName());
		System.out.println(employee.getPassword());
		newEmployee.setPassword(passwordEncoder.encode(employee.getPassword()));
		return userDao.save(newEmployee);
	}
	
	
}
