package com.tailoredleisure.webportal.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tailoredleisure.webportal.bean.MediaBean;
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
	
	@GetMapping("/users/editSelectedVenuePage")
	public ModelAndView editSelectedVenuePage(@RequestParam Long id) {
		ModelAndView mv = new ModelAndView();
		VenueAdvertFormBean venueAdvertFormBean = homeServiceImpl.getSelectedVenueAdvertForm(id);
		System.out.println("venueAdvertFormBean toString[]= "+venueAdvertFormBean.toString());
		VenueAdvertForm venueAdvertForm = convertVenueAdvertFormBeanToVenueAdvertForm(venueAdvertFormBean);
		mv.addObject("venueForm", venueAdvertForm);
		mv.setViewName("venueadvertpage.html");
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
		
		return venueAdvertForm;
	}
	
}
