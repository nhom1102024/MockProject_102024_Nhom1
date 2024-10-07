package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.config.JwtProvider;
import com.login.request.LoginRequest;
import com.login.response.AuthResponse;
import com.login.service.CustomerUserDetailsService;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;


    @PostMapping("/signin")
    public AuthResponse Signin(@RequestBody LoginRequest loginRequest) throws Exception{
        Authentication authentication = Authenticate(loginRequest.getEmail(),loginRequest.getPassword());
        String token = JwtProvider.generateToken(authentication);
        AuthResponse res = new AuthResponse(token, "Login success");
        return res;
    }

    private Authentication Authenticate(String email, String password) throws Exception {
        UserDetails userDetails = customerUserDetailsService.loadUserByUsername(email);

        if(userDetails==null){
            throw new Exception("invalid username");
        }
        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new Exception("Password not matched");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
    }
}
