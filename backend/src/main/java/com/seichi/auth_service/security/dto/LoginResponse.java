package com.seichi.auth_service.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created on October 2024
 *
 * @author Seichi
 */
@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {

	private String token;

}
