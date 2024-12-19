package com.tailoredleisure.webportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tailoredleisure.webportal.bean.Users;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
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
		VenueAdvertFormBean venueAdvertFormBean = adminServiceImpl.getSelectedVenueAdvertForm(id);
		System.out.println("venueAdvertFormBean toString[]= "+venueAdvertFormBean.toString());
		mv.addObject("advert", venueAdvertFormBean);
		mv.setViewName("selectedvenuepage.html");
		return mv;
	}
	
	@PostMapping("/admin/processVenueVerification")
	public ModelAndView processVenueVerification(@RequestParam("id") Long advert_id,
			@RequestParam("TLVerifiedVenueAdvertFlg") Boolean tlVerifyStatus,
			@RequestParam("venueAuditFlgTL") Boolean tlVenueAuditStatus) {
		System.out.println("Inside processVenueVerification method");
		System.out.println("advert_id: "+advert_id);
		ModelAndView mv = new ModelAndView();
		VenueAdvertFormBean venueAdvertFormBean = adminServiceImpl.updateVenueAdvert(advert_id, tlVerifyStatus, tlVenueAuditStatus);
		System.out.println("venueAdvertFormBean toString[]= "+venueAdvertFormBean.toString());
		mv.addObject("advert", venueAdvertFormBean);
		mv.setViewName("selectedvenuepage.html");
		return mv;
	}
}
