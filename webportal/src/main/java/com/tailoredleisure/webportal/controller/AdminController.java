package com.tailoredleisure.webportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tailoredleisure.webportal.bean.Users;
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
}
