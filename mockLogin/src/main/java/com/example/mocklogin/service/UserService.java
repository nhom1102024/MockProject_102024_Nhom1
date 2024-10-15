package com.example.mocklogin.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.mocklogin.dto.LoginDto;
import com.example.mocklogin.model.Role;
import com.example.mocklogin.model.User;
import com.example.mocklogin.response.UserResponse;

@Service
public class UserService implements IUserService {

    private List<User> users = new ArrayList<>();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService() {
        Role adminRole = new Role(1, "admin");
        Role customRole = new Role(2, "staff");

        users.add(new User(1, "admin", passwordEncoder.encode("admin123"), adminRole));
        users.add(new User(2, "hang", passwordEncoder.encode("hang123"), customRole));
    }

    @Override
    public UserResponse login(LoginDto loginDTO) throws Exception {
        Optional<User> optionalUser = users.stream()
                .filter(user -> user.getUsername().equals(loginDTO.getUsername()))
                .findFirst();

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
                return UserResponse.getUser(user);
            }
        }

        throw new IllegalArgumentException("Wrong username/password");
    }
}
