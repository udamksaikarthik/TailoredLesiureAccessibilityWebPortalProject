package com.tailoredleisure.webportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tailoredleisure.webportal.bean.Users;
import com.tailoredleisure.webportal.service.users.UserServiceImpl;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/login")
	private ModelAndView showLoginPage() {
        System.out.println("Inside showLoginPage method");
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", new Users());
		mv.setViewName("login.html");
		return mv;
	}
	
	@PostMapping("/login")
    public String processLogin(@Valid @ModelAttribute("user") Users users,
                                BindingResult bindingResult) {
        System.out.println("Inside processLogin method");

        if (bindingResult.hasErrors()) {
        	System.out.println("bindingResult has Errors.");
            return "login";  // return to signup form if errors
        }else {
        	System.out.println("bindingResult has no Errors.");
        }

        // Process the valid form (e.g., save user to the database)
        // Signup logic here...

        return "/";  // Redirect to login after successful signup
    }
	
	@GetMapping("/signup")
	private ModelAndView showSignUpPage() {
        System.out.println("Inside showSignUpPage method");
		ModelAndView mv = new ModelAndView();
		mv.addObject("signupForm", new Users());
		mv.setViewName("signup.html");
		return mv;
	}
	
	@PostMapping("/signup")
    public String processSignup(@Valid @ModelAttribute("signupForm") Users users,
                                BindingResult bindingResult) {
        System.out.println("Inside processSignup method");
     // Check for validation errors
        if (bindingResult.hasErrors()) {
            return "signup";  // Return signup page with errors
        }

        // If passwords don't match, add custom error
        if (!users.getPassword().equals(users.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.signupForm", "Passwords do not match");
            return "signup";  // Return signup page with error
        }
        
        Boolean flag = userServiceImpl.checkIfGmailAlreadyExists(users);
        
        if(flag) {
            bindingResult.rejectValue("email", "error.signupForm", "Gmail already exists with an account!");
            return "signup";
        }

        // Process the registration
        userServiceImpl.registerUser(users);

        // Redirect to login after successful signup
        return "redirect:/login";
    }
	
}
