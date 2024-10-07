package com.example.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(requests -> requests
            .requestMatchers("/login", "/forgot-password").permitAll() // Cho phép truy c?p vào các trang này mà không
                                                                       // c?n ??ng nh?p
            .anyRequest().authenticated())
        .formLogin(login -> login
            .loginPage("/login") // Trang ??ng nh?p tùy ch?nh
            .defaultSuccessUrl("/home", true) // ?i?u h??ng ??n trang /home sau khi ??ng nh?p thành công
            .permitAll())
        .logout(logout -> logout
            .permitAll()); // Cho phép ??ng xu?t không c?n xác th?c
    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user = User.withUsername("hen")
        .password(passwordEncoder().encode("123")) // Đặt tên người dùng và mật khẩu
        .roles("USER")
        .build();
    return new InMemoryUserDetailsManager(user);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}