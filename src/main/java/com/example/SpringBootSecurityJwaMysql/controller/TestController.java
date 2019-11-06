package com.example.SpringBootSecurityJwaMysql.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("test")
	public ResponseEntity<?> test() {
		return ResponseEntity.ok("app is running");
	}
}
