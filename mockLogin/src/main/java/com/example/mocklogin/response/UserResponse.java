package com.example.mocklogin.response;

import lombok.Builder;
import lombok.Data;

import com.example.mocklogin.model.User;

@Data
@Builder
public class UserResponse {
    private long id;
    private String username;
    private String role;

    public static UserResponse getUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .role(user.getRole().getName())
                .build();
    }
}
