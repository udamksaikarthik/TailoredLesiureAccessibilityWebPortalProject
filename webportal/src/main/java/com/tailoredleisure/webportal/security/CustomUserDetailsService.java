package com.tailoredleisure.webportal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tailoredleisure.webportal.dao.users.UserRepository;
import com.tailoredleisure.webportal.entity.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Find user by email (username in this case)
        Users user = userRepository.findByEmail(username);
        
        // If user is not found, throw an exception
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + username);
        }

        // Return the UserDetails implementation (Spring Security User)
        return User
                .withUsername(user.getEmail())
                .password(user.getPassword())  // Use the encoded password
                .roles(user.getRole())  // Assuming role is stored as a string like "USER", "ADMIN"
                .build();
    }
}