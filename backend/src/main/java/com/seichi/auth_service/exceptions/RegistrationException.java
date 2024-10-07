package com.seichi.auth_service.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created on October 2024
 *
 * @author Seichi
 */
@Getter
@RequiredArgsConstructor
public class RegistrationException extends RuntimeException {

	private final String errorMessage;

}
