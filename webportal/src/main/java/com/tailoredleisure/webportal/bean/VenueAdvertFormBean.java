package com.tailoredleisure.webportal.bean;

import java.util.List;

public class VenueAdvertFormBean {

    // Basic Details
    private Long id;
    private String venueName;
    private String venueType;
    private String venueLocation;
    private String venuePostCode;
    private Boolean venueAuditFlg;
    private Boolean venueAuditFlgTL;
    private Boolean TLVerifiedVenueAdvertFlg;
    private String businessEmail;

    // Related Entities
    private List<MediaBean> media;
    private Users user;

    // Mobility Checklist
    private Boolean mobilityDisabledCarParking;
    private Boolean mobilityHeadphonesAvailable;
    private Boolean mobilityAccessibleRoute;
    private Boolean mobilityWideDoorways;
    private Boolean mobilityWheelchairSeating;
    private Boolean mobilityDisabledToilets;
    private Boolean mobilityChangingPlace;
    private Boolean mobilityLowerCounters;
    private Boolean mobilityLifts;
    private Boolean mobilityRamps;
    private Boolean mobilityUnrestrictedViewing;
    private Boolean mobilityAccessibleDoors;
    private Boolean mobilityEyeLevelSignage;
    private Boolean mobilitySupportiveStaff;
    private Boolean mobilityTrainedStaff;
    private String mobilityComments;

    // Blind Checklist
    private Boolean blindHighContrastSignage;
    private Boolean blindLargeFontSignage;
    private Boolean blindBrailleSignage;
    private Boolean blindVisibleWalkways;
    private Boolean blindTouchTours;
    private Boolean blindLargeSubtitles;
    private Boolean blindNoTripHazards;
    private Boolean blindAdjustableLighting;
    private Boolean blindAudioDescriptions;
    private Boolean blindAdaptedLeaflets;
    private Boolean blindAdaptedSignage;
    private Boolean blindFrontSeating;
    private Boolean blindSupportiveStaff;
    private Boolean blindTrainedStaff;
    private String blindComments;

    // Deaf Checklist
    private Boolean deafHearingLoops;
    private Boolean deafAssistiveTechnology;
    private Boolean deafSignLanguage;
    private Boolean deafAdequateSignage;
    private Boolean deafSubtitles;
    private Boolean deafFrontSeating;
    private Boolean deafSupportiveStaff;
    private Boolean deafTrainedStaff;
    private String deafComments;

    // Neurodiverse Checklist
    private Boolean neurodiverseNoiseReduction;
    private Boolean neurodiverseAdjustableLighting;
    private Boolean neurodiverseQuieterAreas;
    private Boolean neurodiverseSensoryBag;
    private Boolean neurodiverseLoudNoiseReduction;
    private Boolean neurodiverseQuieterTimeAds;
    private Boolean neurodiverseFlashingSignage;
    private Boolean neurodiverseAdaptedLeaflets;
    private Boolean neurodiverseSupportiveStaff;
    private Boolean neurodiverseTrainedStaff;
    private String neurodiverseComments;
    
    

    // Getters and Setters for All Fields
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVenueName() {
		return venueName;
	}
	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}
	public String getVenueType() {
		return venueType;
	}
	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}
	public String getVenueLocation() {
		return venueLocation;
	}
	public void setVenueLocation(String venueLocation) {
		this.venueLocation = venueLocation;
	}
	public String getVenuePostCode() {
		return venuePostCode;
	}
	public void setVenuePostCode(String venuePostCode) {
		this.venuePostCode = venuePostCode;
	}
	public Boolean getVenueAuditFlg() {
		return venueAuditFlg;
	}
	public void setVenueAuditFlg(Boolean venueAuditFlg) {
		this.venueAuditFlg = venueAuditFlg;
	}
	public Boolean getVenueAuditFlgTL() {
		return venueAuditFlgTL;
	}
	public void setVenueAuditFlgTL(Boolean venueAuditFlgTL) {
		this.venueAuditFlgTL = venueAuditFlgTL;
	}
	public Boolean getTLVerifiedVenueAdvertFlg() {
		return TLVerifiedVenueAdvertFlg;
	}
	public void setTLVerifiedVenueAdvertFlg(Boolean tLVerifiedVenueAdvertFlg) {
		TLVerifiedVenueAdvertFlg = tLVerifiedVenueAdvertFlg;
	}
	public List<MediaBean> getMedia() {
		return media;
	}
	public void setMedia(List<MediaBean> media) {
		this.media = media;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Boolean getMobilityDisabledCarParking() {
		return mobilityDisabledCarParking;
	}
	public void setMobilityDisabledCarParking(Boolean mobilityDisabledCarParking) {
		this.mobilityDisabledCarParking = mobilityDisabledCarParking;
	}
	public Boolean getMobilityHeadphonesAvailable() {
		return mobilityHeadphonesAvailable;
	}
	public void setMobilityHeadphonesAvailable(Boolean mobilityHeadphonesAvailable) {
		this.mobilityHeadphonesAvailable = mobilityHeadphonesAvailable;
	}
	public Boolean getMobilityAccessibleRoute() {
		return mobilityAccessibleRoute;
	}
	public void setMobilityAccessibleRoute(Boolean mobilityAccessibleRoute) {
		this.mobilityAccessibleRoute = mobilityAccessibleRoute;
	}
	public Boolean getMobilityWideDoorways() {
		return mobilityWideDoorways;
	}
	public void setMobilityWideDoorways(Boolean mobilityWideDoorways) {
		this.mobilityWideDoorways = mobilityWideDoorways;
	}
	public Boolean getMobilityWheelchairSeating() {
		return mobilityWheelchairSeating;
	}
	public void setMobilityWheelchairSeating(Boolean mobilityWheelchairSeating) {
		this.mobilityWheelchairSeating = mobilityWheelchairSeating;
	}
	public Boolean getMobilityDisabledToilets() {
		return mobilityDisabledToilets;
	}
	public void setMobilityDisabledToilets(Boolean mobilityDisabledToilets) {
		this.mobilityDisabledToilets = mobilityDisabledToilets;
	}
	public Boolean getMobilityChangingPlace() {
		return mobilityChangingPlace;
	}
	public void setMobilityChangingPlace(Boolean mobilityChangingPlace) {
		this.mobilityChangingPlace = mobilityChangingPlace;
	}
	public Boolean getMobilityLowerCounters() {
		return mobilityLowerCounters;
	}
	public void setMobilityLowerCounters(Boolean mobilityLowerCounters) {
		this.mobilityLowerCounters = mobilityLowerCounters;
	}
	public Boolean getMobilityLifts() {
		return mobilityLifts;
	}
	public void setMobilityLifts(Boolean mobilityLifts) {
		this.mobilityLifts = mobilityLifts;
	}
	public Boolean getMobilityRamps() {
		return mobilityRamps;
	}
	public void setMobilityRamps(Boolean mobilityRamps) {
		this.mobilityRamps = mobilityRamps;
	}
	public Boolean getMobilityUnrestrictedViewing() {
		return mobilityUnrestrictedViewing;
	}
	public void setMobilityUnrestrictedViewing(Boolean mobilityUnrestrictedViewing) {
		this.mobilityUnrestrictedViewing = mobilityUnrestrictedViewing;
	}
	public Boolean getMobilityAccessibleDoors() {
		return mobilityAccessibleDoors;
	}
	public void setMobilityAccessibleDoors(Boolean mobilityAccessibleDoors) {
		this.mobilityAccessibleDoors = mobilityAccessibleDoors;
	}
	public Boolean getMobilityEyeLevelSignage() {
		return mobilityEyeLevelSignage;
	}
	public void setMobilityEyeLevelSignage(Boolean mobilityEyeLevelSignage) {
		this.mobilityEyeLevelSignage = mobilityEyeLevelSignage;
	}
	public Boolean getMobilitySupportiveStaff() {
		return mobilitySupportiveStaff;
	}
	public void setMobilitySupportiveStaff(Boolean mobilitySupportiveStaff) {
		this.mobilitySupportiveStaff = mobilitySupportiveStaff;
	}
	public Boolean getMobilityTrainedStaff() {
		return mobilityTrainedStaff;
	}
	public void setMobilityTrainedStaff(Boolean mobilityTrainedStaff) {
		this.mobilityTrainedStaff = mobilityTrainedStaff;
	}
	public String getMobilityComments() {
		return mobilityComments;
	}
	public void setMobilityComments(String mobilityComments) {
		this.mobilityComments = mobilityComments;
	}
	public Boolean getBlindHighContrastSignage() {
		return blindHighContrastSignage;
	}
	public void setBlindHighContrastSignage(Boolean blindHighContrastSignage) {
		this.blindHighContrastSignage = blindHighContrastSignage;
	}
	public Boolean getBlindLargeFontSignage() {
		return blindLargeFontSignage;
	}
	public void setBlindLargeFontSignage(Boolean blindLargeFontSignage) {
		this.blindLargeFontSignage = blindLargeFontSignage;
	}
	public Boolean getBlindBrailleSignage() {
		return blindBrailleSignage;
	}
	public void setBlindBrailleSignage(Boolean blindBrailleSignage) {
		this.blindBrailleSignage = blindBrailleSignage;
	}
	public Boolean getBlindVisibleWalkways() {
		return blindVisibleWalkways;
	}
	public void setBlindVisibleWalkways(Boolean blindVisibleWalkways) {
		this.blindVisibleWalkways = blindVisibleWalkways;
	}
	public Boolean getBlindTouchTours() {
		return blindTouchTours;
	}
	public void setBlindTouchTours(Boolean blindTouchTours) {
		this.blindTouchTours = blindTouchTours;
	}
	public Boolean getBlindLargeSubtitles() {
		return blindLargeSubtitles;
	}
	public void setBlindLargeSubtitles(Boolean blindLargeSubtitles) {
		this.blindLargeSubtitles = blindLargeSubtitles;
	}
	public Boolean getBlindNoTripHazards() {
		return blindNoTripHazards;
	}
	public void setBlindNoTripHazards(Boolean blindNoTripHazards) {
		this.blindNoTripHazards = blindNoTripHazards;
	}
	public Boolean getBlindAdjustableLighting() {
		return blindAdjustableLighting;
	}
	public void setBlindAdjustableLighting(Boolean blindAdjustableLighting) {
		this.blindAdjustableLighting = blindAdjustableLighting;
	}
	public Boolean getBlindAudioDescriptions() {
		return blindAudioDescriptions;
	}
	public void setBlindAudioDescriptions(Boolean blindAudioDescriptions) {
		this.blindAudioDescriptions = blindAudioDescriptions;
	}
	public Boolean getBlindAdaptedLeaflets() {
		return blindAdaptedLeaflets;
	}
	public void setBlindAdaptedLeaflets(Boolean blindAdaptedLeaflets) {
		this.blindAdaptedLeaflets = blindAdaptedLeaflets;
	}
	public Boolean getBlindAdaptedSignage() {
		return blindAdaptedSignage;
	}
	public void setBlindAdaptedSignage(Boolean blindAdaptedSignage) {
		this.blindAdaptedSignage = blindAdaptedSignage;
	}
	public Boolean getBlindFrontSeating() {
		return blindFrontSeating;
	}
	public void setBlindFrontSeating(Boolean blindFrontSeating) {
		this.blindFrontSeating = blindFrontSeating;
	}
	public Boolean getBlindSupportiveStaff() {
		return blindSupportiveStaff;
	}
	public void setBlindSupportiveStaff(Boolean blindSupportiveStaff) {
		this.blindSupportiveStaff = blindSupportiveStaff;
	}
	public Boolean getBlindTrainedStaff() {
		return blindTrainedStaff;
	}
	public void setBlindTrainedStaff(Boolean blindTrainedStaff) {
		this.blindTrainedStaff = blindTrainedStaff;
	}
	public String getBlindComments() {
		return blindComments;
	}
	public void setBlindComments(String blindComments) {
		this.blindComments = blindComments;
	}
	public Boolean getDeafHearingLoops() {
		return deafHearingLoops;
	}
	public void setDeafHearingLoops(Boolean deafHearingLoops) {
		this.deafHearingLoops = deafHearingLoops;
	}
	public Boolean getDeafAssistiveTechnology() {
		return deafAssistiveTechnology;
	}
	public void setDeafAssistiveTechnology(Boolean deafAssistiveTechnology) {
		this.deafAssistiveTechnology = deafAssistiveTechnology;
	}
	public Boolean getDeafSignLanguage() {
		return deafSignLanguage;
	}
	public void setDeafSignLanguage(Boolean deafSignLanguage) {
		this.deafSignLanguage = deafSignLanguage;
	}
	public Boolean getDeafAdequateSignage() {
		return deafAdequateSignage;
	}
	public void setDeafAdequateSignage(Boolean deafAdequateSignage) {
		this.deafAdequateSignage = deafAdequateSignage;
	}
	public Boolean getDeafSubtitles() {
		return deafSubtitles;
	}
	public void setDeafSubtitles(Boolean deafSubtitles) {
		this.deafSubtitles = deafSubtitles;
	}
	public Boolean getDeafFrontSeating() {
		return deafFrontSeating;
	}
	public void setDeafFrontSeating(Boolean deafFrontSeating) {
		this.deafFrontSeating = deafFrontSeating;
	}
	public Boolean getDeafSupportiveStaff() {
		return deafSupportiveStaff;
	}
	public void setDeafSupportiveStaff(Boolean deafSupportiveStaff) {
		this.deafSupportiveStaff = deafSupportiveStaff;
	}
	public Boolean getDeafTrainedStaff() {
		return deafTrainedStaff;
	}
	public void setDeafTrainedStaff(Boolean deafTrainedStaff) {
		this.deafTrainedStaff = deafTrainedStaff;
	}
	public String getDeafComments() {
		return deafComments;
	}
	public void setDeafComments(String deafComments) {
		this.deafComments = deafComments;
	}
	public Boolean getNeurodiverseNoiseReduction() {
		return neurodiverseNoiseReduction;
	}
	public void setNeurodiverseNoiseReduction(Boolean neurodiverseNoiseReduction) {
		this.neurodiverseNoiseReduction = neurodiverseNoiseReduction;
	}
	public Boolean getNeurodiverseAdjustableLighting() {
		return neurodiverseAdjustableLighting;
	}
	public void setNeurodiverseAdjustableLighting(Boolean neurodiverseAdjustableLighting) {
		this.neurodiverseAdjustableLighting = neurodiverseAdjustableLighting;
	}
	public Boolean getNeurodiverseQuieterAreas() {
		return neurodiverseQuieterAreas;
	}
	public void setNeurodiverseQuieterAreas(Boolean neurodiverseQuieterAreas) {
		this.neurodiverseQuieterAreas = neurodiverseQuieterAreas;
	}
	public Boolean getNeurodiverseSensoryBag() {
		return neurodiverseSensoryBag;
	}
	public void setNeurodiverseSensoryBag(Boolean neurodiverseSensoryBag) {
		this.neurodiverseSensoryBag = neurodiverseSensoryBag;
	}
	public Boolean getNeurodiverseLoudNoiseReduction() {
		return neurodiverseLoudNoiseReduction;
	}
	public void setNeurodiverseLoudNoiseReduction(Boolean neurodiverseLoudNoiseReduction) {
		this.neurodiverseLoudNoiseReduction = neurodiverseLoudNoiseReduction;
	}
	public Boolean getNeurodiverseQuieterTimeAds() {
		return neurodiverseQuieterTimeAds;
	}
	public void setNeurodiverseQuieterTimeAds(Boolean neurodiverseQuieterTimeAds) {
		this.neurodiverseQuieterTimeAds = neurodiverseQuieterTimeAds;
	}
	public Boolean getNeurodiverseFlashingSignage() {
		return neurodiverseFlashingSignage;
	}
	public void setNeurodiverseFlashingSignage(Boolean neurodiverseFlashingSignage) {
		this.neurodiverseFlashingSignage = neurodiverseFlashingSignage;
	}
	public Boolean getNeurodiverseAdaptedLeaflets() {
		return neurodiverseAdaptedLeaflets;
	}
	public void setNeurodiverseAdaptedLeaflets(Boolean neurodiverseAdaptedLeaflets) {
		this.neurodiverseAdaptedLeaflets = neurodiverseAdaptedLeaflets;
	}
	public Boolean getNeurodiverseSupportiveStaff() {
		return neurodiverseSupportiveStaff;
	}
	public void setNeurodiverseSupportiveStaff(Boolean neurodiverseSupportiveStaff) {
		this.neurodiverseSupportiveStaff = neurodiverseSupportiveStaff;
	}
	public Boolean getNeurodiverseTrainedStaff() {
		return neurodiverseTrainedStaff;
	}
	public void setNeurodiverseTrainedStaff(Boolean neurodiverseTrainedStaff) {
		this.neurodiverseTrainedStaff = neurodiverseTrainedStaff;
	}
	public String getNeurodiverseComments() {
		return neurodiverseComments;
	}
	public void setNeurodiverseComments(String neurodiverseComments) {
		this.neurodiverseComments = neurodiverseComments;
	}
	
	public String getBusinessEmail() {
		return businessEmail;
	}
	public void setBusinessEmail(String businessEmail) {
		this.businessEmail = businessEmail;
	}
	@Override
	public String toString() {
		return "VenueAdvertFormBean [id=" + id + ", venueName=" + venueName + ", venueType=" + venueType
				+ ", venueLocation=" + venueLocation + ", venuePostCode=" + venuePostCode + ", venueAuditFlg="
				+ venueAuditFlg + ", venueAuditFlgTL=" + venueAuditFlgTL + ", TLVerifiedVenueAdvertFlg="
				+ TLVerifiedVenueAdvertFlg + ", media=" + media + ", user=" + user + ", mobilityDisabledCarParking="
				+ mobilityDisabledCarParking + ", mobilityHeadphonesAvailable=" + mobilityHeadphonesAvailable
				+ ", mobilityAccessibleRoute=" + mobilityAccessibleRoute + ", mobilityWideDoorways="
				+ mobilityWideDoorways + ", mobilityWheelchairSeating=" + mobilityWheelchairSeating
				+ ", mobilityDisabledToilets=" + mobilityDisabledToilets + ", mobilityChangingPlace=" + mobilityChangingPlace
				+ ", mobilityLowerCounters=" + mobilityLowerCounters + ", mobilityLifts=" + mobilityLifts
				+ ", mobilityRamps=" + mobilityRamps + ", mobilityUnrestrictedViewing=" + mobilityUnrestrictedViewing
				+ ", mobilityAccessibleDoors=" + mobilityAccessibleDoors + ", mobilityEyeLevelSignage="
				+ mobilityEyeLevelSignage + ", mobilitySupportiveStaff=" + mobilitySupportiveStaff
				+ ", mobilityTrainedStaff=" + mobilityTrainedStaff + ", mobilityComments=" + mobilityComments
				+ ", blindHighContrastSignage=" + blindHighContrastSignage + ", blindLargeFontSignage="
				+ blindLargeFontSignage + ", blindBrailleSignage=" + blindBrailleSignage + ", blindVisibleWalkways="
				+ blindVisibleWalkways + ", blindTouchTours=" + blindTouchTours + ", blindLargeSubtitles="
				+ blindLargeSubtitles + ", blindNoTripHazards=" + blindNoTripHazards + ", blindAdjustableLighting="
				+ blindAdjustableLighting + ", blindAudioDescriptions=" + blindAudioDescriptions
				+ ", blindAdaptedLeaflets=" + blindAdaptedLeaflets + ", blindAdaptedSignage=" + blindAdaptedSignage
				+ ", blindFrontSeating=" + blindFrontSeating + ", blindSupportiveStaff=" + blindSupportiveStaff
				+ ", blindTrainedStaff=" + blindTrainedStaff + ", blindComments=" + blindComments
				+ ", deafHearingLoops=" + deafHearingLoops + ", deafAssistiveTechnology=" + deafAssistiveTechnology
				+ ", deafSignLanguage=" + deafSignLanguage + ", deafAdequateSignage=" + deafAdequateSignage
				+ ", deafSubtitles=" + deafSubtitles + ", deafFrontSeating=" + deafFrontSeating
				+ ", deafSupportiveStaff=" + deafSupportiveStaff + ", deafTrainedStaff=" + deafTrainedStaff
				+ ", deafComments=" + deafComments + ", neurodiverseNoiseReduction=" + neurodiverseNoiseReduction
				+ ", neurodiverseAdjustableLighting=" + neurodiverseAdjustableLighting + ", neurodiverseQuieterAreas="
				+ neurodiverseQuieterAreas + ", neurodiverseSensoryBag=" + neurodiverseSensoryBag
				+ ", neurodiverseLoudNoiseReduction=" + neurodiverseLoudNoiseReduction + ", neurodiverseQuieterTimeAds="
				+ neurodiverseQuieterTimeAds + ", neurodiverseFlashingSignage=" + neurodiverseFlashingSignage
				+ ", neurodiverseAdaptedLeaflets=" + neurodiverseAdaptedLeaflets + ", neurodiverseSupportiveStaff="
				+ neurodiverseSupportiveStaff + ", neurodiverseTrainedStaff=" + neurodiverseTrainedStaff
				+ ", neurodiverseComments=" + neurodiverseComments + "]";
	}

    
}
