package com.example.mocklogin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;
import java.util.List;

import com.example.mocklogin.dto.LoginDto;
import com.example.mocklogin.response.ResponseObject;
import com.example.mocklogin.response.UserResponse;
import com.example.mocklogin.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
        private final UserService userService = new UserService();

        @PostMapping("/login")
        public ResponseEntity<ResponseObject> login(
                        @Valid @RequestBody LoginDto loginDto, BindingResult bindingResult) {
                try {
                        if (bindingResult.hasErrors()) {
                                List<String> errorMessages = bindingResult.getFieldErrors().stream()
                                                .map(FieldError::getDefaultMessage)
                                                .toList();
                                return ResponseEntity.badRequest().body(
                                                ResponseObject.builder()
                                                                .message("Validation errors: " + errorMessages)
                                                                .data(errorMessages)
                                                                .build());
                        }
                        UserResponse userResponse = userService.login(loginDto);
                        return ResponseEntity.ok(
                                        ResponseObject.builder()
                                                        .message("Login successful!!!")
                                                        .data(userResponse)
                                                        .build());
                } catch (Exception e) {
                        return ResponseEntity.badRequest().body(
                                        ResponseObject.builder()
                                                        .message(e.getMessage())
                                                        .build());
                }
        }
}
