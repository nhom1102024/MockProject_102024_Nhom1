package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Enable CSRF protection
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/login").permitAll()  // Allow access to login page
                .anyRequest().authenticated()  // Other requests require authentication
            )
            .formLogin((form) -> form
                .loginProcessingUrl("/login")  // URL to process login
                .usernameParameter("username")  // Username parameter in request body
                .passwordParameter("password")  // Password parameter in request body
                .defaultSuccessUrl("/welcome", true)  // URL after successful login
                .failureUrl("/login?error=true")  // URL on login failure
                .permitAll()  // Allow access to the login page for all
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
            .username("giang")
            .password(passwordEncoder().encode("11111")) // Encode password
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Use BCrypt for password encoding
    }
}
