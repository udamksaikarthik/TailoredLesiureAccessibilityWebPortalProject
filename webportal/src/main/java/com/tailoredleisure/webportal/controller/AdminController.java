package com.tailoredleisure.webportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tailoredleisure.webportal.bean.Users;
import com.tailoredleisure.webportal.entity.VenueAdvertForm;
import com.tailoredleisure.webportal.service.admin.AdminServiceImpl;

@Controller
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@GetMapping("/admin/showUserManagementPage")
	public ModelAndView showUserManagementPage() {
		ModelAndView mv = new ModelAndView();
		ArrayList<Users> users = adminServiceImpl.getAllUsers();
		mv.addObject("users", users);
		mv.setViewName("adminusermanagementpage.html");
		return mv;
	}
	
	@GetMapping("/admin/showVerifyVenuesPage")
	public ModelAndView showVerifyVenuesPage(@RequestParam(defaultValue = "unverified") String type) {
		ModelAndView mv = new ModelAndView();
		if(type.equals("unverified")) {
			ArrayList<VenueAdvertForm> adverts = adminServiceImpl.getAllAdverts(false);
			mv.addObject("adverts", adverts);
			mv.addObject("adverts_title", "Unverified Adverts");
		}
		else {
			ArrayList<VenueAdvertForm> adverts = adminServiceImpl.getAllAdverts(true);
			mv.addObject("adverts", adverts);
			mv.addObject("adverts_title", "Verified Adverts");
		}
		mv.setViewName("verifyvenuespage.html");
		return mv;
	}
	
	@GetMapping("/admin/showSelectedVenuePage")
	public ModelAndView showSelectedVenuePage(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView();
		VenueAdvertForm venueAdvertForm = adminServiceImpl.getSelectedVenueAdvertForm(id);
		mv.addObject("advert", venueAdvertForm);
		mv.setViewName("selectedvenuepage.html");
		return mv;
	}
}
