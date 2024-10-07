package com.example.login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

  @GetMapping("/login")
  public String login() {
    return "login"; // Trả về file login.html
  }

  @GetMapping("/logout")
  public String logout() {
    return "logout"; // Trả về file logout.html
  }

  @GetMapping("/home")
  public String home() {
    return "home"; // Trả về file home.html
  }

  @GetMapping("/")
  public String root() {
    return "home"; // Chuyển hướng đến home nếu truy cập root
  }
  @GetMapping("/forgot-password")
    public String showForgotPasswordPage() {
        return "forgot-password"; // Tên của tệp HTML cho trang quên mật khẩu
    }
}
