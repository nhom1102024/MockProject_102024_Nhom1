package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.model.LoginRequest;

@Service
public class UserService {

    private static List<LoginRequest> users = new ArrayList<>();

    static {
        users.add(new LoginRequest("user1", "password1"));
        users.add(new LoginRequest("user2", "password2")); 
    }

    public LoginRequest findByUsername(String username) {
        return users.stream()
            .filter(user -> user.getUsername().equals(username))
            .findFirst()
            .orElse(null);
    }
}
