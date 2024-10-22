package com.tailoredleisure.webportal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        	.csrf().disable() 
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/css/**", "/js/**", "/images/**", "/signup", "/login", "/error").permitAll()  // Public paths
                .requestMatchers("/admin/**").hasRole("ADMIN")  // Only admins can access /admin/**
                .requestMatchers("/business/**").hasRole("BUSINESS_MEMBER")  // Only business members can access /business/**
                .requestMatchers("/user/**").hasRole("USER")  // Only users can access /user/**
                .anyRequest().authenticated()  // All other requests require authentication
            )
            .formLogin(form -> form
                .loginPage("/login")  // Custom login page
                .defaultSuccessUrl("/", true)  // Redirect to home on successful login
                .failureHandler(customAuthenticationFailureHandler())  // Custom failure handler
                .permitAll()  // Permit access to the login page
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")  // Redirect to login page after logout
                .permitAll()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/logout")  // Disable CSRF for logout request
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Password encoding using BCrypt
    }

    @Bean
    public AuthenticationFailureHandler customAuthenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();  // Custom failure handler
    }

}