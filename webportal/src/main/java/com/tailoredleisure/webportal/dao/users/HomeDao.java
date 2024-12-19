package com.tailoredleisure.webportal.dao.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
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
			venueAdvertFormEntity.setVenueName(venueAdvertForm.getVenueName());
			venueAdvertFormEntity.setVenueType(venueAdvertForm.getVenueType());
			venueAdvertFormEntity.setVenueLocation(venueAdvertForm.getVenueLocation());
			venueAdvertFormEntity.setVenuePostCode(venueAdvertForm.getVenuePostCode());
			venueAdvertFormEntity.setVenueAuditFlg(venueAdvertForm.getVenueAuditFlg());
			venueAdvertFormEntity.setBusinessEmail(venueAdvertForm.getBusinessEmail());
			
			
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
		            }
	            	venueAdvertFormEntity.setMedia(mediaLists);
				}
			
			//Section-3
			venueAdvertFormEntity.setMobilityAccessibleDoors(venueAdvertForm.getMobilityAccessibleDoors());
			venueAdvertFormEntity.setMobilityAccessibleRoute(venueAdvertForm.getMobilityAccessibleRoute());
			venueAdvertFormEntity.setMobilityChangingPlace(venueAdvertForm.getMobilityChangingPlace());
			venueAdvertFormEntity.setMobilityComments(venueAdvertForm.getMobilityComments());
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
			
			//Section-4

			venueAdvertFormEntity.setBlindAdaptedLeaflets(venueAdvertForm.getBlindAdaptedLeaflets());
			venueAdvertFormEntity.setBlindAdaptedSignage(venueAdvertForm.getBlindAdaptedSignage());
			venueAdvertFormEntity.setBlindAdjustableLighting(venueAdvertForm.getBlindAdjustableLighting());
			venueAdvertFormEntity.setBlindAudioDescriptions(venueAdvertForm.getBlindAudioDescriptions());
			venueAdvertFormEntity.setBlindBrailleSignage(venueAdvertForm.getBlindBrailleSignage());
			venueAdvertFormEntity.setBlindComments(venueAdvertForm.getBlindComments());
			venueAdvertFormEntity.setBlindFrontSeating(venueAdvertForm.getBlindFrontSeating());
			venueAdvertFormEntity.setBlindHighContrastSignage(venueAdvertForm.getBlindHighContrastSignage());
			venueAdvertFormEntity.setBlindLargeFontSignage(venueAdvertForm.getBlindLargeFontSignage());
			venueAdvertFormEntity.setBlindLargeSubtitles(venueAdvertForm.getBlindLargeSubtitles());
			venueAdvertFormEntity.setBlindNoTripHazards(venueAdvertForm.getBlindNoTripHazards());
			venueAdvertFormEntity.setBlindSupportiveStaff(venueAdvertForm.getBlindSupportiveStaff());
			venueAdvertFormEntity.setBlindTouchTours(venueAdvertForm.getBlindTouchTours());
			venueAdvertFormEntity.setBlindTrainedStaff(venueAdvertForm.getBlindTrainedStaff());
			venueAdvertFormEntity.setBlindVisibleWalkways(venueAdvertForm.getBlindVisibleWalkways());
			
			//Section-5
			venueAdvertFormEntity.setDeafAdequateSignage(venueAdvertForm.getDeafAdequateSignage());
			venueAdvertFormEntity.setDeafAssistiveTechnology(venueAdvertForm.getDeafAssistiveTechnology());
			venueAdvertFormEntity.setDeafComments(venueAdvertForm.getDeafComments());
			venueAdvertFormEntity.setDeafFrontSeating(venueAdvertForm.getDeafFrontSeating());
			venueAdvertFormEntity.setDeafHearingLoops(venueAdvertForm.getDeafHearingLoops());
			venueAdvertFormEntity.setDeafSignLanguage(venueAdvertForm.getDeafSignLanguage());
			venueAdvertFormEntity.setDeafSubtitles(venueAdvertForm.getDeafSubtitles());
			venueAdvertFormEntity.setDeafSupportiveStaff(venueAdvertForm.getDeafSupportiveStaff());
			venueAdvertFormEntity.setDeafTrainedStaff(venueAdvertForm.getDeafTrainedStaff());
			
			//Section-6
			venueAdvertFormEntity.setNeurodiverseAdaptedLeaflets(venueAdvertForm.getNeurodiverseAdaptedLeaflets());
			venueAdvertFormEntity.setNeurodiverseAdjustableLighting(venueAdvertForm.getNeurodiverseAdjustableLighting());
			venueAdvertFormEntity.setNeurodiverseComments(venueAdvertForm.getNeurodiverseComments());
			venueAdvertFormEntity.setNeurodiverseFlashingSignage(venueAdvertForm.getNeurodiverseFlashingSignage());
			venueAdvertFormEntity.setNeurodiverseLoudNoiseReduction(venueAdvertForm.getNeurodiverseLoudNoiseReduction());
			venueAdvertFormEntity.setNeurodiverseNoiseReduction(venueAdvertForm.getNeurodiverseLoudNoiseReduction());
			venueAdvertFormEntity.setNeurodiverseQuieterAreas(venueAdvertForm.getNeurodiverseQuieterAreas());
			venueAdvertFormEntity.setNeurodiverseQuieterTimeAds(venueAdvertForm.getNeurodiverseQuieterTimeAds());
			venueAdvertFormEntity.setNeurodiverseSensoryBag(venueAdvertForm.getNeurodiverseSensoryBag());
			venueAdvertFormEntity.setNeurodiverseSupportiveStaff(venueAdvertForm.getNeurodiverseSupportiveStaff());
			venueAdvertFormEntity.setNeurodiverseTrainedStaff(venueAdvertForm.getNeurodiverseTrainedStaff());
			
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
		
		
		
		
		//Section-3
		venueAdvertFormBean.setMobilityAccessibleDoors(venueAdvertFormEntity.getMobilityAccessibleDoors());
		venueAdvertFormBean.setMobilityAccessibleRoute(venueAdvertFormEntity.getMobilityAccessibleRoute());
		venueAdvertFormBean.setMobilityChangingPlace(venueAdvertFormEntity.getMobilityChangingPlace());
		venueAdvertFormBean.setMobilityComments(venueAdvertFormEntity.getMobilityComments());
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
		
		//Section-4

		venueAdvertFormBean.setBlindAdaptedLeaflets(venueAdvertFormEntity.getBlindAdaptedLeaflets());
		venueAdvertFormBean.setBlindAdaptedSignage(venueAdvertFormEntity.getBlindAdaptedSignage());
		venueAdvertFormBean.setBlindAdjustableLighting(venueAdvertFormEntity.getBlindAdjustableLighting());
		venueAdvertFormBean.setBlindAudioDescriptions(venueAdvertFormEntity.getBlindAudioDescriptions());
		venueAdvertFormBean.setBlindBrailleSignage(venueAdvertFormEntity.getBlindBrailleSignage());
		venueAdvertFormBean.setBlindComments(venueAdvertFormEntity.getBlindComments());
		venueAdvertFormBean.setBlindFrontSeating(venueAdvertFormEntity.getBlindFrontSeating());
		venueAdvertFormBean.setBlindHighContrastSignage(venueAdvertFormEntity.getBlindHighContrastSignage());
		venueAdvertFormBean.setBlindLargeFontSignage(venueAdvertFormEntity.getBlindLargeFontSignage());
		venueAdvertFormBean.setBlindLargeSubtitles(venueAdvertFormEntity.getBlindLargeSubtitles());
		venueAdvertFormBean.setBlindNoTripHazards(venueAdvertFormEntity.getBlindNoTripHazards());
		venueAdvertFormBean.setBlindSupportiveStaff(venueAdvertFormEntity.getBlindSupportiveStaff());
		venueAdvertFormBean.setBlindTouchTours(venueAdvertFormEntity.getBlindTouchTours());
		venueAdvertFormBean.setBlindTrainedStaff(venueAdvertFormEntity.getBlindTrainedStaff());
		venueAdvertFormBean.setBlindVisibleWalkways(venueAdvertFormEntity.getBlindVisibleWalkways());
		
		//Section-5
		venueAdvertFormBean.setDeafAdequateSignage(venueAdvertFormEntity.getDeafAdequateSignage());
		venueAdvertFormBean.setDeafAssistiveTechnology(venueAdvertFormEntity.getDeafAssistiveTechnology());
		venueAdvertFormBean.setDeafComments(venueAdvertFormEntity.getDeafComments());
		venueAdvertFormBean.setDeafFrontSeating(venueAdvertFormEntity.getDeafFrontSeating());
		venueAdvertFormBean.setDeafHearingLoops(venueAdvertFormEntity.getDeafHearingLoops());
		venueAdvertFormBean.setDeafSignLanguage(venueAdvertFormEntity.getDeafSignLanguage());
		venueAdvertFormBean.setDeafSubtitles(venueAdvertFormEntity.getDeafSubtitles());
		venueAdvertFormBean.setDeafSupportiveStaff(venueAdvertFormEntity.getDeafSupportiveStaff());
		venueAdvertFormBean.setDeafTrainedStaff(venueAdvertFormEntity.getDeafTrainedStaff());
		
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
			venueAdvertRepository.save(existingAdvertEntity);
			venueAdvertBean = convertEntityIntoBean(existingAdvertEntity);
		}
		return venueAdvertBean;
	}

}
