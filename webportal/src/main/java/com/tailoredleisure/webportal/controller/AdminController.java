package com.tailoredleisure.webportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tailoredleisure.webportal.bean.Users;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
import com.tailoredleisure.webportal.dao.users.UserRepository;
import com.tailoredleisure.webportal.entity.VenueAdvertForm;
import com.tailoredleisure.webportal.service.admin.AdminServiceImpl;

@Controller
public class AdminController {
	
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@Autowired
	private UserRepository userRepository;
	
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
		mv.setViewName("displayvenuespage.html");
		return mv;
	}
	
	@GetMapping("/admin/showSelectedVenueAdminPage")
	public ModelAndView showSelectedVenueAdminPage(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView();
		VenueAdvertFormBean venueAdvertFormBean = adminServiceImpl.getSelectedVenueAdvertForm(id);
		System.out.println("venueAdvertFormBean toString[]= "+venueAdvertFormBean.toString());
		mv.addObject("advert", venueAdvertFormBean);
		mv.setViewName("selectedvenuepage.html");
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
			@RequestParam("venueAuditFlgTL") Boolean tlVenueAuditStatus,
			@RequestParam("venue_tl_rating") int venueTlRating,
			@RequestParam("tl_comment_text") String tlCommentText) {
		System.out.println("Inside processVenueVerification method");
		System.out.println("advert_id: "+advert_id);
		System.out.println("venueTlRating: "+venueTlRating);
		System.out.println("tlCommentText: "+tlCommentText);
		ModelAndView mv = new ModelAndView();
		VenueAdvertFormBean venueAdvertFormBean = adminServiceImpl.updateVenueAdvert(advert_id, tlVerifyStatus, tlVenueAuditStatus, venueTlRating, tlCommentText);
		System.out.println("venueAdvertFormBean toString[]= "+venueAdvertFormBean.toString());
		mv.addObject("advert", venueAdvertFormBean);
		mv.setViewName("redirect:/admin/showSelectedVenueAdminPage?id="+advert_id);
		return mv;
	}
	
	@GetMapping("/admin/showAdminUserVenueAdvertsPage")
	public ModelAndView showSelectedVenuePage() {
		System.out.println("Inside showUserVenueAdvertsPage method");

		ModelAndView mv = new ModelAndView();


        // Get the logged-in user's email (username in this case)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();  // Get the logged-in user's email

        // Fetch the user entity from the database using the email
        com.tailoredleisure.webportal.entity.Users user = userRepository.findByEmail(email);
        
		ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> adverts = adminServiceImpl.getAllAdvertsOfBusiness(user);
		if(adverts.isEmpty() || adverts==null) {
			mv.addObject("user_venue_advert_msg_prompt","No Exisiting Adverts!!! Please go back to Dashboard and use Venue Advertisement Feature to add advert.");
		}
		mv.addObject("adverts", adverts);
		mv.setViewName("adminverifyvenuespage.html");
		return mv;
	}
	
	@GetMapping("/admin/verifyComment")
	public ModelAndView verifyComment(@RequestParam("advertId") Long advertId,
            @RequestParam("commentId") Long commentId,
            RedirectAttributes redirectAttributes) {
		System.out.println("Inside showUserVenueAdvertsPage method");

		ModelAndView mv = new ModelAndView();

		adminServiceImpl.updateCommentStatus(true, commentId);
		redirectAttributes.addFlashAttribute("comment_verified_msg", "Comment successfully verified.");
		mv.setViewName("redirect:/admin/showSelectedVenueAdminPage?id="+advertId);
		return mv;
	}
	
	@GetMapping("/admin/unverifyComment")
	public ModelAndView unverifyComment(@RequestParam("advertId") Long advertId,
            @RequestParam("commentId") Long commentId,
            RedirectAttributes redirectAttributes) {
		System.out.println("Inside showUserVenueAdvertsPage method");

		ModelAndView mv = new ModelAndView();

		adminServiceImpl.updateCommentStatus(false, commentId);
		redirectAttributes.addFlashAttribute("comment_verified_msg", "Comment successfully verified.");
		mv.setViewName("redirect:/admin/showSelectedVenueAdminPage?id="+advertId);
		return mv;
	}
	
}
