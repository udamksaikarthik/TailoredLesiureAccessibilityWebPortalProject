package com.tailoredleisure.webportal.dao.users;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.tailoredleisure.webportal.bean.VenueAdvertForm;
import com.tailoredleisure.webportal.entity.Media;
import com.tailoredleisure.webportal.entity.Users;

import jakarta.validation.Valid;

@Repository
public class HomeDao {
	
	@Autowired
	private VenueAdvertRepository venueAdvertRepository;

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
			

			user.setVenueAdvertForm(venueAdvertFormEntity);
			venueAdvertFormEntity.setUser(user);
			
			
			//Section-1
			venueAdvertFormEntity.setVenueName(venueAdvertForm.getVenueName());
			venueAdvertFormEntity.setVenueType(venueAdvertForm.getVenueType());
			venueAdvertFormEntity.setVenueLocation(venueAdvertForm.getVenueLocation());
			venueAdvertFormEntity.setVenuePostCode(venueAdvertForm.getVenuePostCode());
			venueAdvertFormEntity.setVenueAuditFlg(venueAdvertForm.getVenueAuditFlg());
			
			
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
			venueAdvertFormEntity.setMobilityToiletTurnaround(venueAdvertForm.getMobilityToiletTurnaround());
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

	public com.tailoredleisure.webportal.entity.VenueAdvertForm getSelectedVenueAdvertForm(Long id) {
		// TODO Auto-generated method stub
		Optional<com.tailoredleisure.webportal.entity.VenueAdvertForm> venueAdvert = venueAdvertRepository.findById(id);
		
		com.tailoredleisure.webportal.entity.VenueAdvertForm venueAdvertFormEntity = new com.tailoredleisure.webportal.entity.VenueAdvertForm();
		if(venueAdvert.isPresent()) {
			venueAdvertFormEntity = venueAdvert.get();
		}
		System.out.println("venueAdvertFormEntity: "+venueAdvertFormEntity.toString());
		return venueAdvertFormEntity;
	}

}
