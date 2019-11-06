package com.example.SpringBootSecurityJwaMysql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "emplyee")
public class Employee {

	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Id
	private long id;
	@Column
	private String empName;
	
	@Column
	private String password;
	
	public Employee() {
		
	}

	public Employee(long id, String empName, String password) {
		super();
		this.id = id;
		this.empName = empName;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", password=" + password + "]";
	}
	
	
	
}
