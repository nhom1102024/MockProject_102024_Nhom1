package com.mockproject_102024_nhom1.mockproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("user")
    public String user() {
        return "Welcome User";
    }

    @GetMapping("admin")
    public String admin() {
        return "Welcome Admin";
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

}
