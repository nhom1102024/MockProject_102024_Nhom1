package com.seichi.auth_service.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on October 2024
 *
 * @author Seichi
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	@Operation(tags = "Hello Service", description = "When you send token information in the header it just says Hello")
	public ResponseEntity<String> sayHello() {

		return ResponseEntity.ok("Hello this is my service");
	}

}