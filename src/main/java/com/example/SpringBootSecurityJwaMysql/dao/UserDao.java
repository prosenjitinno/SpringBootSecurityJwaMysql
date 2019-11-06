package com.example.SpringBootSecurityJwaMysql.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootSecurityJwaMysql.model.Employee;
import java.lang.String;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Employee, Integer> {

	Employee findByEmpName(String empname);
}
