package com.seichi.auth_service.controller;

import com.seichi.auth_service.security.dto.RegistrationRequest;
import com.seichi.auth_service.security.dto.RegistrationResponse;
import com.seichi.auth_service.security.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Created on October 2024
 *
 * @author Seichi
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

	private final UserService userService;

	@PostMapping
	@Operation(tags = "Register Service", description = "You can register to the system by sending information in the appropriate format.")
	public ResponseEntity<RegistrationResponse> registrationRequest(@Valid @RequestBody RegistrationRequest registrationRequest) {

		final RegistrationResponse registrationResponse = userService.registration(registrationRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}

}
