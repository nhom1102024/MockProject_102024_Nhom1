package com.example.mocklogin.service;

import com.example.mocklogin.dto.LoginDto;
import com.example.mocklogin.response.UserResponse;

public interface IUserService {
    UserResponse login(LoginDto loginDTO) throws Exception;
}
