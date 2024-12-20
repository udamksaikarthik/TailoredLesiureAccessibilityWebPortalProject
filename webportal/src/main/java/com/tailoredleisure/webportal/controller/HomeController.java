package com.tailoredleisure.webportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tailoredleisure.webportal.dao.users.UserRepository;
import com.tailoredleisure.webportal.entity.Users;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	private ModelAndView showHomePage() {
        System.out.println("Inside showHomePage method");
		ModelAndView mv = new ModelAndView();
		
		// Get the logged-in user's email (username in this case)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();  // Get the logged-in user's email

        // Fetch the user entity from the database using the email
        Users user = userRepository.findByEmail(email);

        // Add the first name, last name, and role to the model
        if (user != null) {
            mv.addObject("firstName", user.getFirstName());
            mv.addObject("role", user.getRole());
        }
		
		mv.setViewName("homepage.html");
		return mv;
	}
}
