package com.tailoredleisure.webportal.dao.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.tailoredleisure.webportal.bean.MediaBean;
import com.tailoredleisure.webportal.bean.VenueAdvertForm;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
import com.tailoredleisure.webportal.entity.Media;
import com.tailoredleisure.webportal.entity.Users;

import jakarta.validation.Valid;

@Repository
public class HomeDao {
	
	@Autowired
	private VenueAdvertRepository venueAdvertRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private MediaRepository mediaRepository;

	public Boolean saveAdvertForm(@Valid VenueAdvertForm venueAdvertForm, Users user) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		com.tailoredleisure.webportal.entity.VenueAdvertForm venueAdvertFormEntity = convertBeanToEntity(venueAdvertForm, user);
		
		if(venueAdvertFormEntity!=null) {
			System.out.println(venueAdvertFormEntity.toString());
			try {
				venueAdvertRepository.save(venueAdvertFormEntity);
				flag = true;
			}catch(Exception e){
				System.out.println(e);
				flag = false;
			}
		}else {
			flag = false;
		}
		
		
		return flag;
	}

	private com.tailoredleisure.webportal.entity.VenueAdvertForm convertBeanToEntity(VenueAdvertForm venueAdvertForm, Users user) {
		// TODO Auto-generated method stub
		com.tailoredleisure.webportal.entity.VenueAdvertForm venueAdvertFormEntity = new com.tailoredleisure.webportal.entity.VenueAdvertForm();
		if(venueAdvertForm!=null) {
			
			
			List<com.tailoredleisure.webportal.entity.VenueAdvertForm> venueAdvertFormList = new ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm>(user.getVenueAdvertForm());
			venueAdvertFormList.add(venueAdvertFormEntity);
			
			userRepository.save(user);
			
			venueAdvertFormEntity.setUser(user);
			
			
			//Section-1
			if(venueAdvertForm.getId()!=null) {
				venueAdvertFormEntity.setId(venueAdvertForm.getId());
			}
			venueAdvertFormEntity.setVenueName(venueAdvertForm.getVenueName());
			venueAdvertFormEntity.setVenueType(venueAdvertForm.getVenueType());
			venueAdvertFormEntity.setVenueLocation(venueAdvertForm.getVenueLocation());
			venueAdvertFormEntity.setVenuePostCode(venueAdvertForm.getVenuePostCode());
			venueAdvertFormEntity.setVenueAuditFlg(venueAdvertForm.getVenueAuditFlg());
			venueAdvertFormEntity.setBusinessEmail(venueAdvertForm.getBusinessEmail());
			venueAdvertFormEntity.setCreatedDate(new Date());
			
			if(venueAdvertForm.getUpdatedDate()!=null) {
				venueAdvertFormEntity.setUpdatedDate(venueAdvertForm.getUpdatedDate());
			}
			if(venueAdvertForm.getTLVerifiedDate()!=null) {
				venueAdvertFormEntity.setTLVerifiedDate(venueAdvertForm.getTLVerifiedDate());
			}
			if(venueAdvertForm.getTLAuditedDate()!=null) {
				venueAdvertFormEntity.setTLAuditedDate(venueAdvertForm.getTLAuditedDate());
			}
			
			
			//Section-2
			if(venueAdvertForm.getMediaFiles()!=null && !venueAdvertForm.getMediaFiles().isEmpty()) {

				ArrayList<Media> mediaLists = new ArrayList<>();
				System.out.println("mediaFiles Size: "+venueAdvertForm.getMediaFiles().size());
	            for (MultipartFile file : venueAdvertForm.getMediaFiles()) {
		        	System.out.println("File Size: "+file.getSize());
	            	if(file.getSize()>0) {
	            		Media media = new Media();
		                // Process the media file (e.g., save to database or file system)
		                byte[] fileData = null;
						try {
							fileData = file.getBytes();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		                String fileName = file.getOriginalFilename();
		                String contentType = file.getContentType();
		                
		                media.setMediaData(fileData);
		                media.setFileName(fileName);
		                media.setMediaType(contentType);
		                media.setVenueAdvertForm(venueAdvertFormEntity);
		                mediaLists.add(media);
		            	}

	    				if(venueAdvertForm.getId()!=null) {
	    					ArrayList<Media> existingMediaFiles = mediaRepository.findByVenueAdvertForm(venueAdvertFormEntity);
	    					for(Media existingMedia :existingMediaFiles) {
	    						System.out.println("existingMedia: "+existingMedia.toString());
	    		                mediaLists.add(existingMedia);
	    					}
	    				}
		            }
	            	venueAdvertFormEntity.setMedia(mediaLists);
				}
			
			//Section-3
			venueAdvertFormEntity.setMobilityAccessibleDoors(venueAdvertForm.getMobilityAccessibleDoors());
			venueAdvertFormEntity.setMobilityAccessibleRoute(venueAdvertForm.getMobilityAccessibleRoute());
			venueAdvertFormEntity.setMobilityChangingPlace(venueAdvertForm.getMobilityChangingPlace());
			venueAdvertFormEntity.setMobilityDisabledCarParking(venueAdvertForm.getMobilityDisabledCarParking());
			venueAdvertFormEntity.setMobilityDisabledToilets(venueAdvertForm.getMobilityDisabledToilets());
			venueAdvertFormEntity.setMobilityEyeLevelSignage(venueAdvertForm.getMobilityEyeLevelSignage());
			venueAdvertFormEntity.setMobilityHeadphonesAvailable(venueAdvertForm.getMobilityHeadphonesAvailable());
			venueAdvertFormEntity.setMobilityLifts(venueAdvertForm.getMobilityLifts());
			venueAdvertFormEntity.setMobilityLowerCounters(venueAdvertForm.getMobilityLowerCounters());
			venueAdvertFormEntity.setMobilityRamps(venueAdvertForm.getMobilityRamps());
			venueAdvertFormEntity.setMobilitySupportiveStaff(venueAdvertForm.getMobilitySupportiveStaff());
			venueAdvertFormEntity.setMobilityTrainedStaff(venueAdvertForm.getMobilityTrainedStaff());
			venueAdvertFormEntity.setMobilityUnrestrictedViewing(venueAdvertForm.getMobilityUnrestrictedViewing());
			venueAdvertFormEntity.setMobilityWheelchairSeating(venueAdvertForm.getMobilityWheelchairSeating());
			venueAdvertFormEntity.setMobilityWideDoorways(venueAdvertForm.getMobilityWideDoorways());
			
			venueAdvertFormEntity.setMobilityAccessibleDoorsComments(venueAdvertForm.getMobilityAccessibleDoorsComments());
			venueAdvertFormEntity.setMobilityAccessibleRouteComments(venueAdvertForm.getMobilityAccessibleRouteComments());
			venueAdvertFormEntity.setMobilityChangingPlaceComments(venueAdvertForm.getMobilityChangingPlaceComments());
			venueAdvertFormEntity.setMobilityDisabledCarParkingComments(venueAdvertForm.getMobilityDisabledCarParkingComments());
			venueAdvertFormEntity.setMobilityDisabledToiletsComments(venueAdvertForm.getMobilityDisabledToiletsComments());
			venueAdvertFormEntity.setMobilityEyeLevelSignageComments(venueAdvertForm.getMobilityEyeLevelSignageComments());
			venueAdvertFormEntity.setMobilityHeadphonesAvailableComments(venueAdvertForm.getMobilityHeadphonesAvailableComments());
			venueAdvertFormEntity.setMobilityLiftsComments(venueAdvertForm.getMobilityLiftsComments());
			venueAdvertFormEntity.setMobilityLowerCountersComments(venueAdvertForm.getMobilityLowerCountersComments());
			venueAdvertFormEntity.setMobilityRampsComments(venueAdvertForm.getMobilityRampsComments());
			venueAdvertFormEntity.setMobilitySupportiveStaffComments(venueAdvertForm.getMobilitySupportiveStaffComments());
			venueAdvertFormEntity.setMobilityTrainedStaffComments(venueAdvertForm.getMobilityTrainedStaffComments());
			venueAdvertFormEntity.setMobilityUnrestrictedViewingComments(venueAdvertForm.getMobilityUnrestrictedViewingComments());
			venueAdvertFormEntity.setMobilityWheelchairSeatingComments(venueAdvertForm.getMobilityWheelchairSeatingComments());
			venueAdvertFormEntity.setMobilityWideDoorwaysComments(venueAdvertForm.getMobilityWideDoorwaysComments());
			
			venueAdvertFormEntity.setMobilityComments(venueAdvertForm.getMobilityComments());
			
			//Section-4

			venueAdvertFormEntity.setBlindAdaptedLeaflets(venueAdvertForm.getBlindAdaptedLeaflets());
			venueAdvertFormEntity.setBlindAdaptedSignage(venueAdvertForm.getBlindAdaptedSignage());
			venueAdvertFormEntity.setBlindAdjustableLighting(venueAdvertForm.getBlindAdjustableLighting());
			venueAdvertFormEntity.setBlindAudioDescriptions(venueAdvertForm.getBlindAudioDescriptions());
			venueAdvertFormEntity.setBlindBrailleSignage(venueAdvertForm.getBlindBrailleSignage());
			venueAdvertFormEntity.setBlindFrontSeating(venueAdvertForm.getBlindFrontSeating());
			venueAdvertFormEntity.setBlindHighContrastSignage(venueAdvertForm.getBlindHighContrastSignage());
			venueAdvertFormEntity.setBlindLargeFontSignage(venueAdvertForm.getBlindLargeFontSignage());
			venueAdvertFormEntity.setBlindLargeSubtitles(venueAdvertForm.getBlindLargeSubtitles());
			venueAdvertFormEntity.setBlindNoTripHazards(venueAdvertForm.getBlindNoTripHazards());
			venueAdvertFormEntity.setBlindSupportiveStaff(venueAdvertForm.getBlindSupportiveStaff());
			venueAdvertFormEntity.setBlindTouchTours(venueAdvertForm.getBlindTouchTours());
			venueAdvertFormEntity.setBlindTrainedStaff(venueAdvertForm.getBlindTrainedStaff());
			venueAdvertFormEntity.setBlindVisibleWalkways(venueAdvertForm.getBlindVisibleWalkways());
			

			venueAdvertFormEntity.setBlindAdaptedLeafletsComments(venueAdvertForm.getBlindAdaptedLeafletsComments());
			venueAdvertFormEntity.setBlindAdaptedSignageComments(venueAdvertForm.getBlindAdaptedSignageComments());
			venueAdvertFormEntity.setBlindAdjustableLightingComments(venueAdvertForm.getBlindAdjustableLightingComments());
			venueAdvertFormEntity.setBlindAudioDescriptionsComments(venueAdvertForm.getBlindAudioDescriptionsComments());
			venueAdvertFormEntity.setBlindBrailleSignageComments(venueAdvertForm.getBlindBrailleSignageComments());
			venueAdvertFormEntity.setBlindFrontSeatingComments(venueAdvertForm.getBlindFrontSeatingComments());
			venueAdvertFormEntity.setBlindHighContrastSignageComments(venueAdvertForm.getBlindHighContrastSignageComments());
			venueAdvertFormEntity.setBlindLargeFontSignageComments(venueAdvertForm.getBlindLargeFontSignageComments());
			venueAdvertFormEntity.setBlindLargeSubtitlesComments(venueAdvertForm.getBlindLargeSubtitlesComments());
			venueAdvertFormEntity.setBlindNoTripHazardsComments(venueAdvertForm.getBlindNoTripHazardsComments());
			venueAdvertFormEntity.setBlindSupportiveStaffComments(venueAdvertForm.getBlindSupportiveStaffComments());
			venueAdvertFormEntity.setBlindTouchToursComments(venueAdvertForm.getBlindTouchToursComments());
			venueAdvertFormEntity.setBlindTrainedStaffComments(venueAdvertForm.getBlindTrainedStaffComments());
			venueAdvertFormEntity.setBlindVisibleWalkwaysComments(venueAdvertForm.getBlindVisibleWalkwaysComments());
			
			venueAdvertFormEntity.setBlindComments(venueAdvertForm.getBlindComments());
			
			//Section-5
			venueAdvertFormEntity.setDeafAdequateSignage(venueAdvertForm.getDeafAdequateSignage());
			venueAdvertFormEntity.setDeafAssistiveTechnology(venueAdvertForm.getDeafAssistiveTechnology());
			venueAdvertFormEntity.setDeafFrontSeating(venueAdvertForm.getDeafFrontSeating());
			venueAdvertFormEntity.setDeafHearingLoops(venueAdvertForm.getDeafHearingLoops());
			venueAdvertFormEntity.setDeafSignLanguage(venueAdvertForm.getDeafSignLanguage());
			venueAdvertFormEntity.setDeafSubtitles(venueAdvertForm.getDeafSubtitles());
			venueAdvertFormEntity.setDeafSupportiveStaff(venueAdvertForm.getDeafSupportiveStaff());
			venueAdvertFormEntity.setDeafTrainedStaff(venueAdvertForm.getDeafTrainedStaff());
			
			venueAdvertFormEntity.setDeafAdequateSignageComments(venueAdvertForm.getDeafAdequateSignageComments());
			venueAdvertFormEntity.setDeafAssistiveTechnologyComments(venueAdvertForm.getDeafAssistiveTechnologyComments());
			venueAdvertFormEntity.setDeafFrontSeatingComments(venueAdvertForm.getDeafFrontSeatingComments());
			venueAdvertFormEntity.setDeafHearingLoopsComments(venueAdvertForm.getDeafHearingLoopsComments());
			venueAdvertFormEntity.setDeafSignLanguageComments(venueAdvertForm.getDeafSignLanguageComments());
			venueAdvertFormEntity.setDeafSubtitlesComments(venueAdvertForm.getDeafSubtitlesComments());
			venueAdvertFormEntity.setDeafSupportiveStaffComments(venueAdvertForm.getDeafSupportiveStaffComments());
			venueAdvertFormEntity.setDeafTrainedStaffComments(venueAdvertForm.getDeafTrainedStaffComments());

			venueAdvertFormEntity.setDeafComments(venueAdvertForm.getDeafComments());
			
			//Section-6
			venueAdvertFormEntity.setNeurodiverseAdaptedLeaflets(venueAdvertForm.getNeurodiverseAdaptedLeaflets());
			venueAdvertFormEntity.setNeurodiverseAdjustableLighting(venueAdvertForm.getNeurodiverseAdjustableLighting());
			venueAdvertFormEntity.setNeurodiverseFlashingSignage(venueAdvertForm.getNeurodiverseFlashingSignage());
			venueAdvertFormEntity.setNeurodiverseLoudNoiseReduction(venueAdvertForm.getNeurodiverseLoudNoiseReduction());
			venueAdvertFormEntity.setNeurodiverseNoiseReduction(venueAdvertForm.getNeurodiverseLoudNoiseReduction());
			venueAdvertFormEntity.setNeurodiverseQuieterAreas(venueAdvertForm.getNeurodiverseQuieterAreas());
			venueAdvertFormEntity.setNeurodiverseQuieterTimeAds(venueAdvertForm.getNeurodiverseQuieterTimeAds());
			venueAdvertFormEntity.setNeurodiverseSensoryBag(venueAdvertForm.getNeurodiverseSensoryBag());
			venueAdvertFormEntity.setNeurodiverseSupportiveStaff(venueAdvertForm.getNeurodiverseSupportiveStaff());
			venueAdvertFormEntity.setNeurodiverseTrainedStaff(venueAdvertForm.getNeurodiverseTrainedStaff());
			
			venueAdvertFormEntity.setNeurodiverseAdaptedLeafletsComments(venueAdvertForm.getNeurodiverseAdaptedLeafletsComments());
			venueAdvertFormEntity.setNeurodiverseAdjustableLightingComments(venueAdvertForm.getNeurodiverseAdjustableLightingComments());
			venueAdvertFormEntity.setNeurodiverseFlashingSignageComments(venueAdvertForm.getNeurodiverseFlashingSignageComments());
			venueAdvertFormEntity.setNeurodiverseLoudNoiseReductionComments(venueAdvertForm.getNeurodiverseLoudNoiseReductionComments());
			venueAdvertFormEntity.setNeurodiverseNoiseReductionComments(venueAdvertForm.getNeurodiverseNoiseReductionComments());
			venueAdvertFormEntity.setNeurodiverseQuieterAreasComments(venueAdvertForm.getNeurodiverseQuieterAreasComments());
			venueAdvertFormEntity.setNeurodiverseQuieterTimeAdsComments(venueAdvertForm.getNeurodiverseQuieterTimeAdsComments());
			venueAdvertFormEntity.setNeurodiverseSensoryBagComments(venueAdvertForm.getNeurodiverseSensoryBagComments());
			venueAdvertFormEntity.setNeurodiverseSupportiveStaffComments(venueAdvertForm.getNeurodiverseSupportiveStaffComments());
			venueAdvertFormEntity.setNeurodiverseTrainedStaffComments(venueAdvertForm.getNeurodiverseTrainedStaffComments());

			venueAdvertFormEntity.setNeurodiverseComments(venueAdvertForm.getNeurodiverseComments());
			
			System.out.println(venueAdvertFormEntity.toString());
			
		}
		return venueAdvertFormEntity;
	}

	public ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> getAllAdverts(boolean flag) {
		// TODO Auto-generated method stub
		ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> adverts = venueAdvertRepository.findAllAdvertsByVerifiedFlag(flag);
		System.out.println("adverts: "+adverts.toString());
		return adverts;
	}

	public VenueAdvertFormBean getSelectedVenueAdvertForm(Long id) {
		// TODO Auto-generated method stub
		Optional<com.tailoredleisure.webportal.entity.VenueAdvertForm> venueAdvert = venueAdvertRepository.findById(id);
		
		com.tailoredleisure.webportal.entity.VenueAdvertForm venueAdvertFormEntity = new com.tailoredleisure.webportal.entity.VenueAdvertForm();
		VenueAdvertFormBean venueAdvertFormBean = new VenueAdvertFormBean();
		if(venueAdvert.isPresent()) {
			venueAdvertFormEntity = venueAdvert.get();
			venueAdvertFormBean = convertEntityIntoBean(venueAdvertFormEntity);
		}
		System.out.println("venueAdvertFormEntity: "+venueAdvertFormEntity.toString());
		return venueAdvertFormBean;
	}

	private VenueAdvertFormBean convertEntityIntoBean(
			com.tailoredleisure.webportal.entity.VenueAdvertForm venueAdvertFormEntity) {
		// TODO Auto-generated method stub
		VenueAdvertFormBean venueAdvertFormBean = new VenueAdvertFormBean();
		
		venueAdvertFormBean.setUser(convertEntityToBean(venueAdvertFormEntity.getUser()));
		
		venueAdvertFormBean.setMedia(convertEntityToBean(venueAdvertFormEntity.getMedia()));
		
		//Section-1
		venueAdvertFormBean.setId(venueAdvertFormEntity.getId());
		venueAdvertFormBean.setVenueName(venueAdvertFormEntity.getVenueName());
		venueAdvertFormBean.setVenueType(venueAdvertFormEntity.getVenueType());
		venueAdvertFormBean.setVenueLocation(venueAdvertFormEntity.getVenueLocation());
		venueAdvertFormBean.setVenuePostCode(venueAdvertFormEntity.getVenuePostCode());
		venueAdvertFormBean.setVenueAuditFlg(venueAdvertFormEntity.getVenueAuditFlg());
		venueAdvertFormBean.setVenueAuditFlgTL(venueAdvertFormEntity.getVenueAuditFlgTL());
		venueAdvertFormBean.setTLVerifiedVenueAdvertFlg(venueAdvertFormEntity.getTLVerifiedVenueAdvertFlg());
		venueAdvertFormBean.setBusinessEmail(venueAdvertFormEntity.getBusinessEmail());
		

		venueAdvertFormBean.setCreatedDate(venueAdvertFormEntity.getCreatedDate());
		venueAdvertFormBean.setUpdatedDate(venueAdvertFormEntity.getUpdatedDate());
		venueAdvertFormBean.setTLVerifiedDate(venueAdvertFormEntity.getTLVerifiedDate());
		venueAdvertFormBean.setTLAuditedDate(venueAdvertFormEntity.getTLAuditedDate());
		
		
		
		//Section-3
		venueAdvertFormBean.setMobilityAccessibleDoors(venueAdvertFormEntity.getMobilityAccessibleDoors());
		venueAdvertFormBean.setMobilityAccessibleRoute(venueAdvertFormEntity.getMobilityAccessibleRoute());
		venueAdvertFormBean.setMobilityChangingPlace(venueAdvertFormEntity.getMobilityChangingPlace());
		venueAdvertFormBean.setMobilityDisabledCarParking(venueAdvertFormEntity.getMobilityDisabledCarParking());
		venueAdvertFormBean.setMobilityDisabledToilets(venueAdvertFormEntity.getMobilityDisabledToilets());
		venueAdvertFormBean.setMobilityEyeLevelSignage(venueAdvertFormEntity.getMobilityEyeLevelSignage());
		venueAdvertFormBean.setMobilityHeadphonesAvailable(venueAdvertFormEntity.getMobilityHeadphonesAvailable());
		venueAdvertFormBean.setMobilityLifts(venueAdvertFormEntity.getMobilityLifts());
		venueAdvertFormBean.setMobilityLowerCounters(venueAdvertFormEntity.getMobilityLowerCounters());
		venueAdvertFormBean.setMobilityRamps(venueAdvertFormEntity.getMobilityRamps());
		venueAdvertFormBean.setMobilitySupportiveStaff(venueAdvertFormEntity.getMobilitySupportiveStaff());
		venueAdvertFormBean.setMobilityTrainedStaff(venueAdvertFormEntity.getMobilityTrainedStaff());
		venueAdvertFormBean.setMobilityUnrestrictedViewing(venueAdvertFormEntity.getMobilityUnrestrictedViewing());
		venueAdvertFormBean.setMobilityWheelchairSeating(venueAdvertFormEntity.getMobilityWheelchairSeating());
		venueAdvertFormBean.setMobilityWideDoorways(venueAdvertFormEntity.getMobilityWideDoorways());

		venueAdvertFormBean.setMobilityAccessibleDoorsComments(venueAdvertFormEntity.getMobilityAccessibleDoorsComments());
		venueAdvertFormBean.setMobilityAccessibleRouteComments(venueAdvertFormEntity.getMobilityAccessibleRouteComments());
		venueAdvertFormBean.setMobilityChangingPlaceComments(venueAdvertFormEntity.getMobilityChangingPlaceComments());
		venueAdvertFormBean.setMobilityDisabledCarParkingComments(venueAdvertFormEntity.getMobilityDisabledCarParkingComments());
		venueAdvertFormBean.setMobilityDisabledToiletsComments(venueAdvertFormEntity.getMobilityDisabledToiletsComments());
		venueAdvertFormBean.setMobilityEyeLevelSignageComments(venueAdvertFormEntity.getMobilityEyeLevelSignageComments());
		venueAdvertFormBean.setMobilityHeadphonesAvailableComments(venueAdvertFormEntity.getMobilityHeadphonesAvailableComments());
		venueAdvertFormBean.setMobilityLiftsComments(venueAdvertFormEntity.getMobilityLiftsComments());
		venueAdvertFormBean.setMobilityLowerCountersComments(venueAdvertFormEntity.getMobilityLowerCountersComments());
		venueAdvertFormBean.setMobilityRampsComments(venueAdvertFormEntity.getMobilityRampsComments());
		venueAdvertFormBean.setMobilitySupportiveStaffComments(venueAdvertFormEntity.getMobilitySupportiveStaffComments());
		venueAdvertFormBean.setMobilityTrainedStaffComments(venueAdvertFormEntity.getMobilityTrainedStaffComments());
		venueAdvertFormBean.setMobilityUnrestrictedViewingComments(venueAdvertFormEntity.getMobilityUnrestrictedViewingComments());
		venueAdvertFormBean.setMobilityWheelchairSeatingComments(venueAdvertFormEntity.getMobilityWheelchairSeatingComments());
		venueAdvertFormBean.setMobilityWideDoorwaysComments(venueAdvertFormEntity.getMobilityWideDoorwaysComments());

		venueAdvertFormBean.setMobilityComments(venueAdvertFormEntity.getMobilityComments());
		
		//Section-4

		venueAdvertFormBean.setBlindAdaptedLeaflets(venueAdvertFormEntity.getBlindAdaptedLeaflets());
		venueAdvertFormBean.setBlindAdaptedSignage(venueAdvertFormEntity.getBlindAdaptedSignage());
		venueAdvertFormBean.setBlindAdjustableLighting(venueAdvertFormEntity.getBlindAdjustableLighting());
		venueAdvertFormBean.setBlindAudioDescriptions(venueAdvertFormEntity.getBlindAudioDescriptions());
		venueAdvertFormBean.setBlindBrailleSignage(venueAdvertFormEntity.getBlindBrailleSignage());
		venueAdvertFormBean.setBlindFrontSeating(venueAdvertFormEntity.getBlindFrontSeating());
		venueAdvertFormBean.setBlindHighContrastSignage(venueAdvertFormEntity.getBlindHighContrastSignage());
		venueAdvertFormBean.setBlindLargeFontSignage(venueAdvertFormEntity.getBlindLargeFontSignage());
		venueAdvertFormBean.setBlindLargeSubtitles(venueAdvertFormEntity.getBlindLargeSubtitles());
		venueAdvertFormBean.setBlindNoTripHazards(venueAdvertFormEntity.getBlindNoTripHazards());
		venueAdvertFormBean.setBlindSupportiveStaff(venueAdvertFormEntity.getBlindSupportiveStaff());
		venueAdvertFormBean.setBlindTouchTours(venueAdvertFormEntity.getBlindTouchTours());
		venueAdvertFormBean.setBlindTrainedStaff(venueAdvertFormEntity.getBlindTrainedStaff());
		venueAdvertFormBean.setBlindVisibleWalkways(venueAdvertFormEntity.getBlindVisibleWalkways());
		

		venueAdvertFormBean.setBlindAdaptedLeafletsComments(venueAdvertFormEntity.getBlindAdaptedLeafletsComments());
		venueAdvertFormBean.setBlindAdaptedSignageComments(venueAdvertFormEntity.getBlindAdaptedSignageComments());
		venueAdvertFormBean.setBlindAdjustableLightingComments(venueAdvertFormEntity.getBlindAdjustableLightingComments());
		venueAdvertFormBean.setBlindAudioDescriptionsComments(venueAdvertFormEntity.getBlindAudioDescriptionsComments());
		venueAdvertFormBean.setBlindBrailleSignageComments(venueAdvertFormEntity.getBlindBrailleSignageComments());
		venueAdvertFormBean.setBlindFrontSeatingComments(venueAdvertFormEntity.getBlindFrontSeatingComments());
		venueAdvertFormBean.setBlindHighContrastSignageComments(venueAdvertFormEntity.getBlindHighContrastSignageComments());
		venueAdvertFormBean.setBlindLargeFontSignageComments(venueAdvertFormEntity.getBlindLargeFontSignageComments());
		venueAdvertFormBean.setBlindLargeSubtitlesComments(venueAdvertFormEntity.getBlindLargeSubtitlesComments());
		venueAdvertFormBean.setBlindNoTripHazardsComments(venueAdvertFormEntity.getBlindNoTripHazardsComments());
		venueAdvertFormBean.setBlindSupportiveStaffComments(venueAdvertFormEntity.getBlindSupportiveStaffComments());
		venueAdvertFormBean.setBlindTouchToursComments(venueAdvertFormEntity.getBlindTouchToursComments());
		venueAdvertFormBean.setBlindTrainedStaffComments(venueAdvertFormEntity.getBlindTrainedStaffComments());
		venueAdvertFormBean.setBlindVisibleWalkwaysComments(venueAdvertFormEntity.getBlindVisibleWalkwaysComments());

		venueAdvertFormBean.setBlindComments(venueAdvertFormEntity.getBlindComments());
		
		//Section-5
		venueAdvertFormBean.setDeafAdequateSignage(venueAdvertFormEntity.getDeafAdequateSignage());
		venueAdvertFormBean.setDeafAssistiveTechnology(venueAdvertFormEntity.getDeafAssistiveTechnology());
		venueAdvertFormBean.setDeafFrontSeating(venueAdvertFormEntity.getDeafFrontSeating());
		venueAdvertFormBean.setDeafHearingLoops(venueAdvertFormEntity.getDeafHearingLoops());
		venueAdvertFormBean.setDeafSignLanguage(venueAdvertFormEntity.getDeafSignLanguage());
		venueAdvertFormBean.setDeafSubtitles(venueAdvertFormEntity.getDeafSubtitles());
		venueAdvertFormBean.setDeafSupportiveStaff(venueAdvertFormEntity.getDeafSupportiveStaff());
		venueAdvertFormBean.setDeafTrainedStaff(venueAdvertFormEntity.getDeafTrainedStaff());

		venueAdvertFormBean.setDeafAdequateSignageComments(venueAdvertFormEntity.getDeafAdequateSignageComments());
		venueAdvertFormBean.setDeafAssistiveTechnologyComments(venueAdvertFormEntity.getDeafAssistiveTechnologyComments());
		venueAdvertFormBean.setDeafFrontSeatingComments(venueAdvertFormEntity.getDeafFrontSeatingComments());
		venueAdvertFormBean.setDeafHearingLoopsComments(venueAdvertFormEntity.getDeafHearingLoopsComments());
		venueAdvertFormBean.setDeafSignLanguageComments(venueAdvertFormEntity.getDeafSignLanguageComments());
		venueAdvertFormBean.setDeafSubtitlesComments(venueAdvertFormEntity.getDeafSubtitlesComments());
		venueAdvertFormBean.setDeafSupportiveStaffComments(venueAdvertFormEntity.getDeafSupportiveStaffComments());
		venueAdvertFormBean.setDeafTrainedStaffComments(venueAdvertFormEntity.getDeafTrainedStaffComments());

		venueAdvertFormBean.setDeafComments(venueAdvertFormEntity.getDeafComments());
		
		//Section-6
		venueAdvertFormBean.setNeurodiverseAdaptedLeaflets(venueAdvertFormEntity.getNeurodiverseAdaptedLeaflets());
		venueAdvertFormBean.setNeurodiverseAdjustableLighting(venueAdvertFormEntity.getNeurodiverseAdjustableLighting());
		venueAdvertFormBean.setNeurodiverseComments(venueAdvertFormEntity.getNeurodiverseComments());
		venueAdvertFormBean.setNeurodiverseFlashingSignage(venueAdvertFormEntity.getNeurodiverseFlashingSignage());
		venueAdvertFormBean.setNeurodiverseLoudNoiseReduction(venueAdvertFormEntity.getNeurodiverseLoudNoiseReduction());
		venueAdvertFormBean.setNeurodiverseNoiseReduction(venueAdvertFormEntity.getNeurodiverseLoudNoiseReduction());
		venueAdvertFormBean.setNeurodiverseQuieterAreas(venueAdvertFormEntity.getNeurodiverseQuieterAreas());
		venueAdvertFormBean.setNeurodiverseQuieterTimeAds(venueAdvertFormEntity.getNeurodiverseQuieterTimeAds());
		venueAdvertFormBean.setNeurodiverseSensoryBag(venueAdvertFormEntity.getNeurodiverseSensoryBag());
		venueAdvertFormBean.setNeurodiverseSupportiveStaff(venueAdvertFormEntity.getNeurodiverseSupportiveStaff());
		venueAdvertFormBean.setNeurodiverseTrainedStaff(venueAdvertFormEntity.getNeurodiverseTrainedStaff());

		venueAdvertFormBean.setNeurodiverseAdaptedLeafletsComments(venueAdvertFormEntity.getNeurodiverseAdaptedLeafletsComments());
		venueAdvertFormBean.setNeurodiverseAdjustableLightingComments(venueAdvertFormEntity.getNeurodiverseAdjustableLightingComments());
		venueAdvertFormBean.setNeurodiverseFlashingSignageComments(venueAdvertFormEntity.getNeurodiverseFlashingSignageComments());
		venueAdvertFormBean.setNeurodiverseLoudNoiseReductionComments(venueAdvertFormEntity.getNeurodiverseLoudNoiseReductionComments());
		venueAdvertFormBean.setNeurodiverseNoiseReductionComments(venueAdvertFormEntity.getNeurodiverseNoiseReductionComments());
		venueAdvertFormBean.setNeurodiverseQuieterAreasComments(venueAdvertFormEntity.getNeurodiverseQuieterAreasComments());
		venueAdvertFormBean.setNeurodiverseQuieterTimeAdsComments(venueAdvertFormEntity.getNeurodiverseQuieterTimeAdsComments());
		venueAdvertFormBean.setNeurodiverseSensoryBagComments(venueAdvertFormEntity.getNeurodiverseSensoryBagComments());
		venueAdvertFormBean.setNeurodiverseSupportiveStaffComments(venueAdvertFormEntity.getNeurodiverseSupportiveStaffComments());
		venueAdvertFormBean.setNeurodiverseTrainedStaffComments(venueAdvertFormEntity.getNeurodiverseTrainedStaffComments());
		
		return venueAdvertFormBean;
	}

	private List<MediaBean> convertEntityToBean(List<Media> media) {
		// TODO Auto-generated method stub
		List<MediaBean> mediaBean = new ArrayList<>();
		if(media!=null) {
			for (Media m : media) {
				MediaBean mb = new MediaBean();
				mb.setBase64MediaData("data:" + m.getMediaType() + ";base64," +
			            Base64.getEncoder().encodeToString(m.getMediaData()));
				mb.setId(m.getId());
				mb.setFileName(m.getFileName());
				mb.setMediaData(m.getMediaData());
				mb.setMediaType(m.getMediaType());
				mb.setVenueAdvertFormId(m.getVenueAdvertForm().getId());
				mediaBean.add(mb);
			}
		}
		return mediaBean;
	}

	private com.tailoredleisure.webportal.bean.Users convertEntityToBean(Users user) {
		// TODO Auto-generated method stub
		com.tailoredleisure.webportal.bean.Users userBean = new com.tailoredleisure.webportal.bean.Users();
		userBean.setCreatedAt(user.getCreatedAt());
		userBean.setEmail(user.getEmail());
		userBean.setFirstName(user.getFirstName());
		userBean.setLastName(user.getLastName());
		userBean.setPhoneNumber(user.getPhoneNumber());
		userBean.setRole(user.getRole());
		userBean.setVenueAdvertForm(user.getVenueAdvertForm());
		return userBean;
	}

	public VenueAdvertFormBean updateVenueAdvert(Long advert_id, Boolean tlVerifyStatus, Boolean tlVenueAuditStatus) {
		// TODO Auto-generated method stub
		Optional<com.tailoredleisure.webportal.entity.VenueAdvertForm> venueAdvertFormEntity = venueAdvertRepository.findById(advert_id);
		
		VenueAdvertFormBean venueAdvertBean = new VenueAdvertFormBean();
		
		if(venueAdvertFormEntity.isPresent()) {
			com.tailoredleisure.webportal.entity.VenueAdvertForm existingAdvertEntity = venueAdvertFormEntity.get();
			existingAdvertEntity.setTLVerifiedVenueAdvertFlg(tlVerifyStatus);
			existingAdvertEntity.setVenueAuditFlgTL(tlVenueAuditStatus);
			existingAdvertEntity.setUpdatedDate(new Date());
			if(existingAdvertEntity.getTLVerifiedVenueAdvertFlg()) {
				existingAdvertEntity.setTLVerifiedDate(new Date());
			}
			if(existingAdvertEntity.getVenueAuditFlgTL()) {
				existingAdvertEntity.setTLAuditedDate(new Date());
			}
			venueAdvertRepository.save(existingAdvertEntity);
			venueAdvertBean = convertEntityIntoBean(existingAdvertEntity);
		}
		return venueAdvertBean;
	}

	public ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> getAllAdvertsOfBusiness(Users user) {
		// TODO Auto-generated method stub
		ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> adverts = venueAdvertRepository.findAllAdvertsByUserId(user);
		System.out.println("adverts: "+adverts.toString());
		return adverts;
	}

	public void deleteMediaFile(Long mediaId) {
		// TODO Auto-generated method stub
		mediaRepository.deleteById(mediaId);
	}

	public Boolean updateAdvertForm(@Valid VenueAdvertForm venueAdvertForm, Users user) {
		// TODO Auto-generated method stub
		Boolean flag = false;
		com.tailoredleisure.webportal.entity.VenueAdvertForm venueAdvertFormEntity = convertBeanToEntity(venueAdvertForm, user);
		
		if(venueAdvertFormEntity!=null) {
			System.out.println(venueAdvertFormEntity.toString());
			try {
				venueAdvertFormEntity.setUpdatedDate(new Date());
				System.out.println("Inside updateAdvertForm Method from homeDao Class");
				System.out.println("venueAdvertFormEntity updatedDate: "+venueAdvertFormEntity.getUpdatedDate());
				venueAdvertRepository.save(venueAdvertFormEntity);
				flag = true;
			}catch(Exception e){
				System.out.println(e);
				flag = false;
			}
		}else {
			flag = false;
		}
		
		
		return flag;
	}

	public void deleteAdvert(Long advertId) {
		// TODO Auto-generated method stub
		Optional<com.tailoredleisure.webportal.entity.VenueAdvertForm> venueAdvertFormEntity = venueAdvertRepository.findById(advertId);
		
		if(venueAdvertFormEntity.isPresent()) {
			com.tailoredleisure.webportal.entity.VenueAdvertForm existingVenueAdvertFormEntity = venueAdvertFormEntity.get();
			for(Media media: existingVenueAdvertFormEntity.getMedia()) {
				mediaRepository.deleteById(media.getId());
			}
			venueAdvertRepository.deleteById(advertId);
		}
	}

	public int getExistingMediaCount(Long id) {
		// TODO Auto-generated method stub
		Optional<com.tailoredleisure.webportal.entity.VenueAdvertForm> venueAdvertFormEntity = venueAdvertRepository.findById(id);
		int mediaSize = 0;
		if(venueAdvertFormEntity.isPresent()) {
			com.tailoredleisure.webportal.entity.VenueAdvertForm existingVenueAdvertFormEntity = venueAdvertFormEntity.get();
			if(existingVenueAdvertFormEntity.getMedia()!=null) {
				mediaSize = existingVenueAdvertFormEntity.getMedia().size();
			}else {
				
			}
		}
		
		return mediaSize;
	}

}
