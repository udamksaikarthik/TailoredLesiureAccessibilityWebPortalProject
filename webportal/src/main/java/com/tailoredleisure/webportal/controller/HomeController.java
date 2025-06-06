package com.tailoredleisure.webportal.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tailoredleisure.webportal.bean.CommentForm;
import com.tailoredleisure.webportal.bean.MediaBean;
import com.tailoredleisure.webportal.bean.VenueAdvertForm;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
import com.tailoredleisure.webportal.dao.users.UserRepository;
import com.tailoredleisure.webportal.entity.PasswordResetToken;
import com.tailoredleisure.webportal.entity.Users;
import com.tailoredleisure.webportal.service.admin.AdminServiceImpl;
import com.tailoredleisure.webportal.service.users.EmailService;
import com.tailoredleisure.webportal.service.users.HomeServiceImpl;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	private HomeServiceImpl homeServiceImpl;
	

	@Autowired
	private EmailService emailService;
	

	@PostMapping("/forgot-password")
    public ModelAndView forgotPassword(@RequestParam String email, RedirectAttributes redirectAttributes) {
		System.out.println("Inside forgotPassword method");
		ModelAndView mv = new ModelAndView();
        try {
            String token = homeServiceImpl.generateResetToken(email);
            emailService.sendPasswordResetEmail(email, token);
            System.out.println("After sendPasswordResetEmail method!");
            String msg = "Password reset email sent successfully.";
            redirectAttributes.addFlashAttribute("passwordResetMailMsgSuccess", msg);
            System.out.println("msg:"+ msg);
            mv.setViewName("redirect:/login");
            return mv;
        } catch (Exception e) {
        	String msg = "Email not associated in our database. Please create an account!";
            redirectAttributes.addFlashAttribute("passwordResetMailMsgError", msg);
            System.out.println("msg:"+ msg);
            mv.setViewName("redirect:/login");
            return mv;
        }
    }
	
	@PostMapping("/reset-password")
	public ModelAndView resetPassword(@RequestParam("token") String token, @RequestParam("newPassword") String newPassword,
			RedirectAttributes redirectAttributes) {
		System.out.println("Inside Reset Password");
	    PasswordResetToken resetToken = homeServiceImpl.findByToken(token);
	    System.out.println("resetToken: "+resetToken);
	    ModelAndView mv = new ModelAndView();

	    if (resetToken != null && resetToken.getExpiryDate().isAfter(LocalDateTime.now())) {
	        Users user = resetToken.getUser();
	        user.setPassword(new BCryptPasswordEncoder().encode(newPassword));
	        userRepository.save(user);
	        homeServiceImpl.delete(resetToken); // Invalidate the token
	        String msg = "Password has been resetted successfully!";
	        System.out.println("msg: "+msg);
	        redirectAttributes.addFlashAttribute("passwordResetMsgSuccess",msg);
	        mv.setViewName("redirect:/login");
	        return mv;
	    } else {
	        String msg = "Password hasn't been resetted! Try Again please!";
	        System.out.println("msg: "+msg);
	        redirectAttributes.addFlashAttribute("passwordResetMsgError",msg);
	        mv.setViewName("redirect:/login");
	        return mv;
	    }
	}
	
	@GetMapping("/showForgotPasswordPage")
	public ModelAndView showForgotPasswordPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("forgotpasswordpage.html");
		return mv;
	}
	
	@GetMapping("/reset-password")
	public ModelAndView showResetPasswordPage(@RequestParam("token") String token) {
		System.out.println("Inside showResetPasswordPage");
		ModelAndView mv = new ModelAndView();
		mv.addObject("token", token);
		mv.setViewName("resetpasswordpage.html");
		return mv;
	}

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

		mv.addObject("adverts", new VenueAdvertFormBean());
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
	
	@GetMapping("/users/showVenuesPage")
	public ModelAndView showVerifyVenuesPage() {
		ModelAndView mv = new ModelAndView();
		ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> adverts = homeServiceImpl.getAllAdverts(true);
		mv.addObject("adverts", adverts);
		mv.addObject("adverts_title", "Verified Adverts");
		mv.setViewName("displayallusersvenuespage.html");
		return mv;
	}
	
	@GetMapping("/users/showSelectedVenuePage")
	public ModelAndView showSelectedVenuePage(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView();
		VenueAdvertFormBean venueAdvertFormBean = homeServiceImpl.getSelectedVenueAdvertForm(id);
		System.out.println("venueAdvertFormBean toString[]= "+venueAdvertFormBean.toString());
		mv.addObject("advert", venueAdvertFormBean);
		mv.addObject("commentForm", new CommentForm());
		mv.setViewName("selectedallusersvenuepage.html");
		return mv;
	}
	
	@GetMapping("/business/showUserVenueAdvertsPage")
	private ModelAndView showUserVenueAdvertsPage() {
        System.out.println("Inside showUserVenueAdvertsPage method");

		ModelAndView mv = new ModelAndView();


        // Get the logged-in user's email (username in this case)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();  // Get the logged-in user's email

        // Fetch the user entity from the database using the email
        Users user = userRepository.findByEmail(email);
        
		ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> adverts = homeServiceImpl.getAllAdvertsOfBusiness(user);
		if(adverts.isEmpty() || adverts==null) {
			mv.addObject("user_venue_advert_msg_prompt","No Exisiting Adverts!!! Please go back to Dashboard and use Venue Advertisement Feature to add advert.");
		}
		mv.addObject("adverts", adverts);
		mv.setViewName("uservenueadvertspage.html");
		return mv;
	}
	

	@GetMapping("/business/deleteSelectedMedia")
	private ModelAndView deleteSelectedMedia(@RequestParam("id") Long advertId, @RequestParam("mediaId") Long mediaId) {
        System.out.println("Inside deleteSelectedMedia method");
        
        homeServiceImpl.deleteMediaFile(mediaId);
        
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/users/editSelectedVenuePage?id=" + advertId);
		return mv;
	}
	
	@GetMapping("/users/editSelectedVenuePage")
	public ModelAndView editSelectedVenuePage(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView();
		VenueAdvertFormBean venueAdvertFormBean = homeServiceImpl.getSelectedVenueAdvertForm(id);
		System.out.println("venueAdvertFormBean toString[]= "+venueAdvertFormBean.toString());
		VenueAdvertForm venueAdvertForm = convertVenueAdvertFormBeanToVenueAdvertForm(venueAdvertFormBean);
		mv.addObject("adverts", venueAdvertFormBean);
		mv.addObject("venueForm", venueAdvertForm);
		mv.setViewName("updatevenueadvertpage.html");
		return mv;
	}
	
	@GetMapping("/terms-and-conditions")
	public ModelAndView showTermsAndConditionsPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("termsandconditionsPage.html");
		return mv;
	}
	
	@PostMapping("/business/submitUpdatedVenueAdvertForm")
	private ModelAndView submitUpdatedVenueAdvertForm(@Valid @ModelAttribute("venueForm") VenueAdvertForm venueAdvertForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        System.out.println("Inside submitUpdatedVenueAdvertForm method");
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
        
        int existingMediaCount = homeServiceImpl.getExistingMediaCount(venueAdvertForm.getId());
        
        int totalMediaCount = 0;
        
        if(venueAdvertForm.getMediaFiles()!=null) {
            totalMediaCount = existingMediaCount + venueAdvertForm.getMediaFiles().size();
        }else {
        	totalMediaCount = existingMediaCount;
        }
        if(totalMediaCount > 5) {
        	System.out.println("Media File Size Exceeded");
        	redirectAttributes.addFlashAttribute("advert_form_media_error_msg", "Advert Update Failed: You cannot add more than 5 media files to this advert. Please remove an existing media file before adding a new one.");
            mv.setViewName("redirect:/users/editSelectedVenuePage?id=" + venueAdvertForm.getId());

    		return mv;
        }
        
        System.out.println("venueAdvertForm toString: "+venueAdvertForm.toString());
        
        // Get the logged-in user's email (username in this case)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();  // Get the logged-in user's email

        // Fetch the user entity from the database using the email
        Users user = userRepository.findByEmail(email);


        // Process the valid form (e.g., save venue form to the database)
        Boolean flag = homeServiceImpl.updateAdvertForm(venueAdvertForm, user);
        if(flag) {
        	redirectAttributes.addFlashAttribute("advert_form_success_msg", "Advert Updated successfully.");
        }else {
        	
        }
        mv.setViewName("redirect:/users/editSelectedVenuePage?id=" + venueAdvertForm.getId());

		return mv;
	}
	
	@DeleteMapping("/business/deleteAdvert/{id}")
	private ModelAndView deleteAdvert(@PathVariable("id") Long advertId) {
		System.out.println("Inside deleteAdvert Method");
		ModelAndView mv = new ModelAndView();
		homeServiceImpl.deleteAdvert(advertId);
		mv.setViewName("redirect:/business/showUserVenueAdvertsPage");
		return mv;
	}
	
	@PostMapping("/users/advertAddComment")
	private ModelAndView advertAddComment(@RequestParam("advertId") Long advertId,@RequestParam("rating") int rating,@Valid  @ModelAttribute("commentForm") CommentForm commentForm,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		System.out.println("Inside advertAddComment Method");
		ModelAndView mv = new ModelAndView();
		
		System.out.println("rating: "+rating);
		
		if(rating == 0) {
    		redirectAttributes.addFlashAttribute("error_msg", "Comment has not been added successfully.");
        	mv.setViewName("redirect:/users/showSelectedVenuePage?id=" + advertId);
            return mv;  
		}
		
		// Check for validation errors
        if (bindingResult.hasErrors()) {
    		redirectAttributes.addFlashAttribute("error_msg", "Comment has not been added successfully.");
        	mv.setViewName("redirect:/users/showSelectedVenuePage?id=" + advertId);
            return mv;  
        }
        

		// Get the logged-in user's email (username in this case)
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();  // Get the logged-in user's email

        // Fetch the user entity from the database using the email
        Users user = userRepository.findByEmail(email);
        
        commentForm.setRating(rating);
        
		homeServiceImpl.advertAddComment(advertId, commentForm, user);
		redirectAttributes.addFlashAttribute("success_msg", "Comment has been added successfully.");
		mv.setViewName("redirect:/users/showSelectedVenuePage?id=" + advertId);
		return mv;
	}

	private VenueAdvertForm convertVenueAdvertFormBeanToVenueAdvertForm(VenueAdvertFormBean venueAdvertFormBean) {
		// TODO Auto-generated method stub
		VenueAdvertForm venueAdvertForm = new VenueAdvertForm();
		venueAdvertForm.setId(venueAdvertFormBean.getId());
		venueAdvertForm.setVenueAuditFlg(venueAdvertFormBean.getVenueAuditFlg());
		venueAdvertForm.setVenueAuditFlgTL(venueAdvertFormBean.getVenueAuditFlgTL());
		venueAdvertForm.setVenueLocation(venueAdvertFormBean.getVenueLocation());
		venueAdvertForm.setVenueName(venueAdvertFormBean.getVenueName());
		venueAdvertForm.setVenuePostCode(venueAdvertFormBean.getVenuePostCode());
		venueAdvertForm.setVenueType(venueAdvertFormBean.getVenueType());
		

		venueAdvertForm.setMobilityAccessibleDoors(venueAdvertFormBean.getMobilityAccessibleDoors());
		venueAdvertForm.setMobilityAccessibleDoorsComments(venueAdvertFormBean.getMobilityAccessibleDoorsComments());
		venueAdvertForm.setMobilityAccessibleRoute(venueAdvertFormBean.getMobilityAccessibleRoute());
		venueAdvertForm.setMobilityAccessibleRouteComments(venueAdvertFormBean.getMobilityAccessibleRouteComments());
		venueAdvertForm.setMobilityChangingPlace(venueAdvertFormBean.getMobilityChangingPlace());
		venueAdvertForm.setMobilityChangingPlaceComments(venueAdvertFormBean.getMobilityChangingPlaceComments());
		venueAdvertForm.setMobilityComments(venueAdvertFormBean.getMobilityComments());
		venueAdvertForm.setMobilityDisabledCarParking(venueAdvertFormBean.getMobilityDisabledCarParking());
		venueAdvertForm.setMobilityDisabledCarParkingComments(venueAdvertFormBean.getMobilityDisabledCarParkingComments());
		venueAdvertForm.setMobilityDisabledToilets(venueAdvertFormBean.getMobilityDisabledToilets());
		venueAdvertForm.setMobilityDisabledToiletsComments(venueAdvertFormBean.getMobilityDisabledToiletsComments());
		venueAdvertForm.setMobilityEyeLevelSignage(venueAdvertFormBean.getMobilityEyeLevelSignage());
		venueAdvertForm.setMobilityEyeLevelSignageComments(venueAdvertFormBean.getMobilityEyeLevelSignageComments());
		venueAdvertForm.setMobilityHeadphonesAvailable(venueAdvertFormBean.getMobilityHeadphonesAvailable());
		venueAdvertForm.setMobilityHeadphonesAvailableComments(venueAdvertFormBean.getMobilityHeadphonesAvailableComments());
		venueAdvertForm.setMobilityLifts(venueAdvertFormBean.getMobilityLifts());
		venueAdvertForm.setMobilityLiftsComments(venueAdvertFormBean.getMobilityLiftsComments());
		venueAdvertForm.setMobilityLowerCounters(venueAdvertFormBean.getMobilityLowerCounters());
		venueAdvertForm.setMobilityLowerCountersComments(venueAdvertFormBean.getMobilityLowerCountersComments());
		venueAdvertForm.setMobilityRamps(venueAdvertFormBean.getMobilityRamps());
		venueAdvertForm.setMobilityRampsComments(venueAdvertFormBean.getMobilityRampsComments());
		venueAdvertForm.setMobilitySupportiveStaff(venueAdvertFormBean.getMobilitySupportiveStaff());
		venueAdvertForm.setMobilitySupportiveStaffComments(venueAdvertFormBean.getMobilitySupportiveStaffComments());
		venueAdvertForm.setMobilityTrainedStaff(venueAdvertFormBean.getMobilityTrainedStaff());
		venueAdvertForm.setMobilityTrainedStaffComments(venueAdvertFormBean.getMobilityTrainedStaffComments());
		venueAdvertForm.setMobilityUnrestrictedViewing(venueAdvertFormBean.getMobilityUnrestrictedViewing());
		venueAdvertForm.setMobilityUnrestrictedViewingComments(venueAdvertFormBean.getMobilityUnrestrictedViewingComments());
		venueAdvertForm.setMobilityWheelchairSeating(venueAdvertFormBean.getMobilityWheelchairSeating());
		venueAdvertForm.setMobilityWheelchairSeatingComments(venueAdvertFormBean.getMobilityWheelchairSeatingComments());
		venueAdvertForm.setMobilityWideDoorways(venueAdvertFormBean.getMobilityWideDoorways());
		venueAdvertForm.setMobilityWideDoorwaysComments(venueAdvertFormBean.getMobilityWideDoorwaysComments());
		
		
		venueAdvertForm.setBlindAdaptedLeaflets(venueAdvertFormBean.getBlindAdaptedLeaflets());
		venueAdvertForm.setBlindAdaptedLeafletsComments(venueAdvertFormBean.getBlindAdaptedLeafletsComments());
		venueAdvertForm.setBlindAdaptedSignage(venueAdvertFormBean.getBlindAdaptedSignage());
		venueAdvertForm.setBlindAdaptedSignageComments(venueAdvertFormBean.getBlindAdaptedSignageComments());
		venueAdvertForm.setBlindAdjustableLighting(venueAdvertFormBean.getBlindAdjustableLighting());
		venueAdvertForm.setBlindAdjustableLightingComments(venueAdvertFormBean.getBlindAdjustableLightingComments());
		venueAdvertForm.setBlindAudioDescriptions(venueAdvertFormBean.getBlindAudioDescriptions());
		venueAdvertForm.setBlindAudioDescriptionsComments(venueAdvertFormBean.getBlindAudioDescriptionsComments());
		venueAdvertForm.setBlindBrailleSignage(venueAdvertFormBean.getBlindBrailleSignage());
		venueAdvertForm.setBlindBrailleSignageComments(venueAdvertFormBean.getBlindBrailleSignageComments());
		venueAdvertForm.setBlindComments(venueAdvertFormBean.getBlindComments());
		venueAdvertForm.setBlindFrontSeating(venueAdvertFormBean.getBlindFrontSeating());
		venueAdvertForm.setBlindFrontSeatingComments(venueAdvertFormBean.getBlindFrontSeatingComments());
		venueAdvertForm.setBlindHighContrastSignage(venueAdvertFormBean.getBlindHighContrastSignage());
		venueAdvertForm.setBlindHighContrastSignageComments(venueAdvertFormBean.getBlindHighContrastSignageComments());
		venueAdvertForm.setBlindLargeFontSignage(venueAdvertFormBean.getBlindLargeFontSignage());
		venueAdvertForm.setBlindLargeFontSignageComments(venueAdvertFormBean.getBlindLargeFontSignageComments());
		venueAdvertForm.setBlindLargeSubtitles(venueAdvertFormBean.getBlindLargeSubtitles());
		venueAdvertForm.setBlindLargeSubtitlesComments(venueAdvertFormBean.getBlindLargeSubtitlesComments());
		venueAdvertForm.setBlindNoTripHazards(venueAdvertFormBean.getBlindNoTripHazards());
		venueAdvertForm.setBlindNoTripHazardsComments(venueAdvertFormBean.getBlindNoTripHazardsComments());
		venueAdvertForm.setBlindSupportiveStaff(venueAdvertFormBean.getBlindSupportiveStaff());
		venueAdvertForm.setBlindSupportiveStaffComments(venueAdvertFormBean.getBlindSupportiveStaffComments());
		venueAdvertForm.setBlindTouchTours(venueAdvertFormBean.getBlindTouchTours());
		venueAdvertForm.setBlindTouchToursComments(venueAdvertFormBean.getBlindTouchToursComments());
		venueAdvertForm.setBlindTrainedStaff(venueAdvertFormBean.getBlindTrainedStaff());
		venueAdvertForm.setBlindTrainedStaffComments(venueAdvertFormBean.getBlindTrainedStaffComments());
		venueAdvertForm.setBlindVisibleWalkways(venueAdvertFormBean.getBlindVisibleWalkways());
		venueAdvertForm.setBlindVisibleWalkwaysComments(venueAdvertFormBean.getBlindVisibleWalkwaysComments());
		

		venueAdvertForm.setDeafAdequateSignage(venueAdvertFormBean.getDeafAdequateSignage());
		venueAdvertForm.setDeafAdequateSignageComments(venueAdvertFormBean.getDeafAdequateSignageComments());
		venueAdvertForm.setDeafAssistiveTechnology(venueAdvertFormBean.getDeafAssistiveTechnology());
		venueAdvertForm.setDeafAssistiveTechnologyComments(venueAdvertFormBean.getDeafAssistiveTechnologyComments());
		venueAdvertForm.setDeafComments(venueAdvertFormBean.getDeafComments());
		venueAdvertForm.setDeafFrontSeating(venueAdvertFormBean.getDeafFrontSeating());
		venueAdvertForm.setDeafFrontSeatingComments(venueAdvertFormBean.getDeafFrontSeatingComments());
		venueAdvertForm.setDeafHearingLoops(venueAdvertFormBean.getDeafHearingLoops());
		venueAdvertForm.setDeafHearingLoopsComments(venueAdvertFormBean.getDeafHearingLoopsComments());
		venueAdvertForm.setDeafSignLanguage(venueAdvertFormBean.getDeafSignLanguage());
		venueAdvertForm.setDeafSignLanguageComments(venueAdvertFormBean.getDeafSignLanguageComments());
		venueAdvertForm.setDeafSubtitles(venueAdvertFormBean.getDeafSubtitles());
		venueAdvertForm.setDeafSubtitlesComments(venueAdvertFormBean.getDeafSubtitlesComments());
		venueAdvertForm.setDeafSupportiveStaff(venueAdvertFormBean.getDeafSupportiveStaff());
		venueAdvertForm.setDeafSupportiveStaffComments(venueAdvertFormBean.getDeafSupportiveStaffComments());
		venueAdvertForm.setDeafTrainedStaff(venueAdvertFormBean.getDeafTrainedStaff());
		venueAdvertForm.setDeafTrainedStaffComments(venueAdvertFormBean.getDeafTrainedStaffComments());
		
		
		venueAdvertForm.setNeurodiverseAdaptedLeaflets(venueAdvertFormBean.getNeurodiverseAdaptedLeaflets());
		venueAdvertForm.setNeurodiverseAdaptedLeafletsComments(venueAdvertFormBean.getNeurodiverseAdaptedLeafletsComments());
		venueAdvertForm.setNeurodiverseAdjustableLighting(venueAdvertFormBean.getNeurodiverseAdjustableLighting());
		venueAdvertForm.setNeurodiverseAdjustableLightingComments(venueAdvertFormBean.getNeurodiverseAdjustableLightingComments());
		venueAdvertForm.setNeurodiverseComments(venueAdvertFormBean.getNeurodiverseComments());
		venueAdvertForm.setNeurodiverseFlashingSignage(venueAdvertFormBean.getNeurodiverseFlashingSignage());
		venueAdvertForm.setNeurodiverseFlashingSignageComments(venueAdvertFormBean.getNeurodiverseFlashingSignageComments());
		venueAdvertForm.setNeurodiverseLoudNoiseReduction(venueAdvertFormBean.getNeurodiverseLoudNoiseReduction());
		venueAdvertForm.setNeurodiverseLoudNoiseReductionComments(venueAdvertFormBean.getNeurodiverseLoudNoiseReductionComments());
		venueAdvertForm.setNeurodiverseNoiseReduction(venueAdvertFormBean.getNeurodiverseNoiseReduction());
		venueAdvertForm.setNeurodiverseNoiseReductionComments(venueAdvertFormBean.getNeurodiverseNoiseReductionComments());
		venueAdvertForm.setNeurodiverseQuieterAreas(venueAdvertFormBean.getNeurodiverseQuieterAreas());
		venueAdvertForm.setNeurodiverseQuieterAreasComments(venueAdvertFormBean.getNeurodiverseQuieterAreasComments());
		venueAdvertForm.setNeurodiverseQuieterTimeAds(venueAdvertFormBean.getNeurodiverseQuieterTimeAds());
		venueAdvertForm.setNeurodiverseQuieterTimeAdsComments(venueAdvertFormBean.getNeurodiverseQuieterTimeAdsComments());
		venueAdvertForm.setNeurodiverseSensoryBag(venueAdvertFormBean.getNeurodiverseSensoryBag());
		venueAdvertForm.setNeurodiverseSensoryBagComments(venueAdvertFormBean.getNeurodiverseSensoryBagComments());
		venueAdvertForm.setNeurodiverseSupportiveStaff(venueAdvertFormBean.getNeurodiverseSupportiveStaff());
		venueAdvertForm.setNeurodiverseSupportiveStaffComments(venueAdvertFormBean.getNeurodiverseSupportiveStaffComments());
		venueAdvertForm.setNeurodiverseTrainedStaff(venueAdvertFormBean.getNeurodiverseTrainedStaff());
		venueAdvertForm.setNeurodiverseTrainedStaffComments(venueAdvertFormBean.getNeurodiverseTrainedStaffComments());
		
		venueAdvertForm.setBusinessEmail(venueAdvertFormBean.getBusinessEmail());		
		return venueAdvertForm;
	}
	
	
}
