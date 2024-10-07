package com.seichi.auth_service.security.service;

import com.seichi.auth_service.model.User;
import com.seichi.auth_service.security.dto.AuthenticatedUserDto;
import com.seichi.auth_service.security.dto.RegistrationRequest;
import com.seichi.auth_service.security.dto.RegistrationResponse;

/**
 * Created on October 2024
 *
 * @author Seichi
 */
public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
