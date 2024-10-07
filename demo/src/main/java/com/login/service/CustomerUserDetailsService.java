package com.login.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomerUserDetailsService implements UserDetailsService {
    private final PasswordEncoder passwordEncoder;
    private final Map<String, UserDetails> userDetailsMap;

    public CustomerUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsMap = new HashMap<>();
        initializeUsers();
    }

    private void initializeUsers() {
        userDetailsMap.put("user@example.com", new org.springframework.security.core.userdetails.User(
            "user@example.com",
            passwordEncoder.encode("password123"),
            new ArrayList<>()
        ));
        userDetailsMap.put("admin@example.com", new org.springframework.security.core.userdetails.User(
            "admin@example.com",
            passwordEncoder.encode("adminpass"),
            new ArrayList<>()
        ));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails userDetails = userDetailsMap.get(email);
        if (userDetails == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return userDetails;
    }
}
