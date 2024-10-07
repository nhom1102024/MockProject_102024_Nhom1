package com.example.controller;

import com.example.model.LoginRequest;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        LoginRequest user = userService.findByUsername(loginRequest.getUsername());
        
        if (user != null && user.getPassword().equals(loginRequest.getPassword())) {
            return "Login successful!";
        } else {
            return "Invalid username or password!";
        }
    }
}
