package com.tailoredleisure.webportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tailoredleisure.webportal.bean.VenueAdvertForm;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
import com.tailoredleisure.webportal.dao.users.UserRepository;
import com.tailoredleisure.webportal.entity.Users;
import com.tailoredleisure.webportal.service.admin.AdminServiceImpl;
import com.tailoredleisure.webportal.service.users.HomeServiceImpl;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private HomeServiceImpl homeServiceImpl;
	


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
        }
		
		mv.setViewName("homepage.html");
		return mv;
	}
	
	@GetMapping("/business/showVenueAdvertPage")
	private ModelAndView showVenueAdvertPage() {
        System.out.println("Inside showVenueAdvertPage method");

		ModelAndView mv = new ModelAndView();
		// Get the logged-in user's email (username in this case)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();  // Get the logged-in user's email

        // Fetch the user entity from the database using the email
        Users user = userRepository.findByEmail(email);

        // Add the first name, last name, and role to the model
        if (user != null) {
            mv.addObject("firstName", user.getFirstName());
        }
        
		mv.addObject("venueForm", new VenueAdvertForm());
		mv.setViewName("venueadvertpage.html");
		return mv;
	}
	
	@PostMapping("/business/submitVenueAdvertForm")
	private ModelAndView submitVenueAdvertForm(@Valid @ModelAttribute("venueForm") VenueAdvertForm venueAdvertForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("Inside showVenueAdvertPage method");
        ModelAndView mv = new ModelAndView();
        if (bindingResult.hasErrors()) {
        	System.out.println("bindingResult has Errors.");
        	System.out.println("bindingResult.getErrorCount(): "+bindingResult.getErrorCount());
        	System.out.println("bindingResult.getAllErrors(): "+bindingResult.getAllErrors());
        	mv.addObject("images_warn_msg", "Please reselect the media files(images/videos) again in media section! If you have selected any before submitting the form.");
        	mv.setViewName("venueadvertpage");
            return mv;  // return to signup form if errors
        }else {
        	System.out.println("bindingResult has no Errors.");
        }
        
        // Get the logged-in user's email (username in this case)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();  // Get the logged-in user's email

        // Fetch the user entity from the database using the email
        Users user = userRepository.findByEmail(email);


        // Process the valid form (e.g., save venue form to the database)
        Boolean flag = homeServiceImpl.saveAdvertForm(venueAdvertForm, user);
        if(flag) {
        	redirectAttributes.addFlashAttribute("advert_form_success_msg", "Advert added successfully.");
        }else {
        	
        }
        mv.setViewName("redirect:/");

		return mv;
	}
	
	@GetMapping("/users/showVerifyVenuesPage")
	public ModelAndView showVerifyVenuesPage() {
		ModelAndView mv = new ModelAndView();
		ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> adverts = homeServiceImpl.getAllAdverts(true);
		mv.addObject("adverts", adverts);
		mv.addObject("adverts_title", "Verified Adverts");
		mv.setViewName("verifyvenuespage.html");
		return mv;
	}
	
	@GetMapping("/users/showSelectedVenuePage")
	public ModelAndView showSelectedVenuePage(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView();
		VenueAdvertFormBean venueAdvertFormBean = homeServiceImpl.getSelectedVenueAdvertForm(id);
		System.out.println("venueAdvertFormBean toString[]= "+venueAdvertFormBean.toString());
		mv.addObject("advert", venueAdvertFormBean);
		mv.setViewName("selectedvenuepage.html");
		return mv;
	}
}
