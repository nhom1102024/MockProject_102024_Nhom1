package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("/welcome")
    public String welcome() {
        return "Dang nhap thanh cong!";
    }

    @GetMapping("/login")
    public String login() {
        return "Vui long dang nhap!";
    }
}
