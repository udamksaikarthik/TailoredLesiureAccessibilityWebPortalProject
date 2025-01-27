package com.tailoredleisure.webportal.bean;

import java.util.Date;
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
    

    private Date createdDate;

    private Date updatedDate;

    private Date TLVerifiedDate;

    private Date TLAuditedDate;

    // Related Entities
    private List<MediaBean> media;
    private List<CommentForm> commentForm;
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
    private String mobilityDisabledCarParkingComments;
    private String mobilityHeadphonesAvailableComments;
    private String mobilityAccessibleRouteComments;
    private String mobilityWideDoorwaysComments;
    private String mobilityWheelchairSeatingComments;
    private String mobilityDisabledToiletsComments;
    private String mobilityChangingPlaceComments;
    private String mobilityLowerCountersComments;
    private String mobilityLiftsComments;
    private String mobilityRampsComments;
    private String mobilityUnrestrictedViewingComments;
    private String mobilityAccessibleDoorsComments;
    private String mobilityEyeLevelSignageComments;
    private String mobilitySupportiveStaffComments;
    private String mobilityTrainedStaffComments;
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
    private String blindHighContrastSignageComments;
    private String blindLargeFontSignageComments;
    private String blindBrailleSignageComments;
    private String blindVisibleWalkwaysComments;
    private String blindTouchToursComments;
    private String blindLargeSubtitlesComments;
    private String blindNoTripHazardsComments;
    private String blindAdjustableLightingComments;
    private String blindAudioDescriptionsComments;
    private String blindAdaptedLeafletsComments;
    private String blindAdaptedSignageComments;
    private String blindFrontSeatingComments;
    private String blindSupportiveStaffComments;
    private String blindTrainedStaffComments;
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
    private String deafHearingLoopsComments;
    private String deafAssistiveTechnologyComments;
    private String deafSignLanguageComments;
    private String deafAdequateSignageComments;
    private String deafSubtitlesComments;
    private String deafFrontSeatingComments;
    private String deafSupportiveStaffComments;
    private String deafTrainedStaffComments;
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
    private String neurodiverseNoiseReductionComments;
    private String neurodiverseAdjustableLightingComments;
    private String neurodiverseQuieterAreasComments;
    private String neurodiverseSensoryBagComments;
    private String neurodiverseLoudNoiseReductionComments;
    private String neurodiverseQuieterTimeAdsComments;
    private String neurodiverseFlashingSignageComments;
    private String neurodiverseAdaptedLeafletsComments;
    private String neurodiverseSupportiveStaffComments;
    private String neurodiverseTrainedStaffComments;
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
	
	
	
	public String getMobilityDisabledCarParkingComments() {
		return mobilityDisabledCarParkingComments;
	}
	public void setMobilityDisabledCarParkingComments(String mobilityDisabledCarParkingComments) {
		this.mobilityDisabledCarParkingComments = mobilityDisabledCarParkingComments;
	}
	public String getMobilityHeadphonesAvailableComments() {
		return mobilityHeadphonesAvailableComments;
	}
	public void setMobilityHeadphonesAvailableComments(String mobilityHeadphonesAvailableComments) {
		this.mobilityHeadphonesAvailableComments = mobilityHeadphonesAvailableComments;
	}
	public String getMobilityAccessibleRouteComments() {
		return mobilityAccessibleRouteComments;
	}
	public void setMobilityAccessibleRouteComments(String mobilityAccessibleRouteComments) {
		this.mobilityAccessibleRouteComments = mobilityAccessibleRouteComments;
	}
	public String getMobilityWideDoorwaysComments() {
		return mobilityWideDoorwaysComments;
	}
	public void setMobilityWideDoorwaysComments(String mobilityWideDoorwaysComments) {
		this.mobilityWideDoorwaysComments = mobilityWideDoorwaysComments;
	}
	public String getMobilityWheelchairSeatingComments() {
		return mobilityWheelchairSeatingComments;
	}
	public void setMobilityWheelchairSeatingComments(String mobilityWheelchairSeatingComments) {
		this.mobilityWheelchairSeatingComments = mobilityWheelchairSeatingComments;
	}
	public String getMobilityDisabledToiletsComments() {
		return mobilityDisabledToiletsComments;
	}
	public void setMobilityDisabledToiletsComments(String mobilityDisabledToiletsComments) {
		this.mobilityDisabledToiletsComments = mobilityDisabledToiletsComments;
	}
	public String getMobilityChangingPlaceComments() {
		return mobilityChangingPlaceComments;
	}
	public void setMobilityChangingPlaceComments(String mobilityChangingPlaceComments) {
		this.mobilityChangingPlaceComments = mobilityChangingPlaceComments;
	}
	public String getMobilityLowerCountersComments() {
		return mobilityLowerCountersComments;
	}
	public void setMobilityLowerCountersComments(String mobilityLowerCountersComments) {
		this.mobilityLowerCountersComments = mobilityLowerCountersComments;
	}
	public String getMobilityLiftsComments() {
		return mobilityLiftsComments;
	}
	public void setMobilityLiftsComments(String mobilityLiftsComments) {
		this.mobilityLiftsComments = mobilityLiftsComments;
	}
	public String getMobilityRampsComments() {
		return mobilityRampsComments;
	}
	public void setMobilityRampsComments(String mobilityRampsComments) {
		this.mobilityRampsComments = mobilityRampsComments;
	}
	public String getMobilityUnrestrictedViewingComments() {
		return mobilityUnrestrictedViewingComments;
	}
	public void setMobilityUnrestrictedViewingComments(String mobilityUnrestrictedViewingComments) {
		this.mobilityUnrestrictedViewingComments = mobilityUnrestrictedViewingComments;
	}
	public String getMobilityAccessibleDoorsComments() {
		return mobilityAccessibleDoorsComments;
	}
	public void setMobilityAccessibleDoorsComments(String mobilityAccessibleDoorsComments) {
		this.mobilityAccessibleDoorsComments = mobilityAccessibleDoorsComments;
	}
	public String getMobilityEyeLevelSignageComments() {
		return mobilityEyeLevelSignageComments;
	}
	public void setMobilityEyeLevelSignageComments(String mobilityEyeLevelSignageComments) {
		this.mobilityEyeLevelSignageComments = mobilityEyeLevelSignageComments;
	}
	public String getMobilitySupportiveStaffComments() {
		return mobilitySupportiveStaffComments;
	}
	public void setMobilitySupportiveStaffComments(String mobilitySupportiveStaffComments) {
		this.mobilitySupportiveStaffComments = mobilitySupportiveStaffComments;
	}
	public String getMobilityTrainedStaffComments() {
		return mobilityTrainedStaffComments;
	}
	public void setMobilityTrainedStaffComments(String mobilityTrainedStaffComments) {
		this.mobilityTrainedStaffComments = mobilityTrainedStaffComments;
	}
	public String getBlindHighContrastSignageComments() {
		return blindHighContrastSignageComments;
	}
	public void setBlindHighContrastSignageComments(String blindHighContrastSignageComments) {
		this.blindHighContrastSignageComments = blindHighContrastSignageComments;
	}
	public String getBlindLargeFontSignageComments() {
		return blindLargeFontSignageComments;
	}
	public void setBlindLargeFontSignageComments(String blindLargeFontSignageComments) {
		this.blindLargeFontSignageComments = blindLargeFontSignageComments;
	}
	public String getBlindBrailleSignageComments() {
		return blindBrailleSignageComments;
	}
	public void setBlindBrailleSignageComments(String blindBrailleSignageComments) {
		this.blindBrailleSignageComments = blindBrailleSignageComments;
	}
	public String getBlindVisibleWalkwaysComments() {
		return blindVisibleWalkwaysComments;
	}
	public void setBlindVisibleWalkwaysComments(String blindVisibleWalkwaysComments) {
		this.blindVisibleWalkwaysComments = blindVisibleWalkwaysComments;
	}
	public String getBlindTouchToursComments() {
		return blindTouchToursComments;
	}
	public void setBlindTouchToursComments(String blindTouchToursComments) {
		this.blindTouchToursComments = blindTouchToursComments;
	}
	public String getBlindLargeSubtitlesComments() {
		return blindLargeSubtitlesComments;
	}
	public void setBlindLargeSubtitlesComments(String blindLargeSubtitlesComments) {
		this.blindLargeSubtitlesComments = blindLargeSubtitlesComments;
	}
	public String getBlindNoTripHazardsComments() {
		return blindNoTripHazardsComments;
	}
	public void setBlindNoTripHazardsComments(String blindNoTripHazardsComments) {
		this.blindNoTripHazardsComments = blindNoTripHazardsComments;
	}
	public String getBlindAdjustableLightingComments() {
		return blindAdjustableLightingComments;
	}
	public void setBlindAdjustableLightingComments(String blindAdjustableLightingComments) {
		this.blindAdjustableLightingComments = blindAdjustableLightingComments;
	}
	public String getBlindAudioDescriptionsComments() {
		return blindAudioDescriptionsComments;
	}
	public void setBlindAudioDescriptionsComments(String blindAudioDescriptionsComments) {
		this.blindAudioDescriptionsComments = blindAudioDescriptionsComments;
	}
	public String getBlindAdaptedLeafletsComments() {
		return blindAdaptedLeafletsComments;
	}
	public void setBlindAdaptedLeafletsComments(String blindAdaptedLeafletsComments) {
		this.blindAdaptedLeafletsComments = blindAdaptedLeafletsComments;
	}
	public String getBlindAdaptedSignageComments() {
		return blindAdaptedSignageComments;
	}
	public void setBlindAdaptedSignageComments(String blindAdaptedSignageComments) {
		this.blindAdaptedSignageComments = blindAdaptedSignageComments;
	}
	public String getBlindFrontSeatingComments() {
		return blindFrontSeatingComments;
	}
	public void setBlindFrontSeatingComments(String blindFrontSeatingComments) {
		this.blindFrontSeatingComments = blindFrontSeatingComments;
	}
	public String getBlindSupportiveStaffComments() {
		return blindSupportiveStaffComments;
	}
	public void setBlindSupportiveStaffComments(String blindSupportiveStaffComments) {
		this.blindSupportiveStaffComments = blindSupportiveStaffComments;
	}
	public String getBlindTrainedStaffComments() {
		return blindTrainedStaffComments;
	}
	public void setBlindTrainedStaffComments(String blindTrainedStaffComments) {
		this.blindTrainedStaffComments = blindTrainedStaffComments;
	}
	public String getDeafHearingLoopsComments() {
		return deafHearingLoopsComments;
	}
	public void setDeafHearingLoopsComments(String deafHearingLoopsComments) {
		this.deafHearingLoopsComments = deafHearingLoopsComments;
	}
	public String getDeafAssistiveTechnologyComments() {
		return deafAssistiveTechnologyComments;
	}
	public void setDeafAssistiveTechnologyComments(String deafAssistiveTechnologyComments) {
		this.deafAssistiveTechnologyComments = deafAssistiveTechnologyComments;
	}
	public String getDeafSignLanguageComments() {
		return deafSignLanguageComments;
	}
	public void setDeafSignLanguageComments(String deafSignLanguageComments) {
		this.deafSignLanguageComments = deafSignLanguageComments;
	}
	public String getDeafAdequateSignageComments() {
		return deafAdequateSignageComments;
	}
	public void setDeafAdequateSignageComments(String deafAdequateSignageComments) {
		this.deafAdequateSignageComments = deafAdequateSignageComments;
	}
	public String getDeafSubtitlesComments() {
		return deafSubtitlesComments;
	}
	public void setDeafSubtitlesComments(String deafSubtitlesComments) {
		this.deafSubtitlesComments = deafSubtitlesComments;
	}
	public String getDeafFrontSeatingComments() {
		return deafFrontSeatingComments;
	}
	public void setDeafFrontSeatingComments(String deafFrontSeatingComments) {
		this.deafFrontSeatingComments = deafFrontSeatingComments;
	}
	public String getDeafSupportiveStaffComments() {
		return deafSupportiveStaffComments;
	}
	public void setDeafSupportiveStaffComments(String deafSupportiveStaffComments) {
		this.deafSupportiveStaffComments = deafSupportiveStaffComments;
	}
	public String getDeafTrainedStaffComments() {
		return deafTrainedStaffComments;
	}
	public void setDeafTrainedStaffComments(String deafTrainedStaffComments) {
		this.deafTrainedStaffComments = deafTrainedStaffComments;
	}
	public String getNeurodiverseNoiseReductionComments() {
		return neurodiverseNoiseReductionComments;
	}
	public void setNeurodiverseNoiseReductionComments(String neurodiverseNoiseReductionComments) {
		this.neurodiverseNoiseReductionComments = neurodiverseNoiseReductionComments;
	}
	public String getNeurodiverseAdjustableLightingComments() {
		return neurodiverseAdjustableLightingComments;
	}
	public void setNeurodiverseAdjustableLightingComments(String neurodiverseAdjustableLightingComments) {
		this.neurodiverseAdjustableLightingComments = neurodiverseAdjustableLightingComments;
	}
	public String getNeurodiverseQuieterAreasComments() {
		return neurodiverseQuieterAreasComments;
	}
	public void setNeurodiverseQuieterAreasComments(String neurodiverseQuieterAreasComments) {
		this.neurodiverseQuieterAreasComments = neurodiverseQuieterAreasComments;
	}
	public String getNeurodiverseSensoryBagComments() {
		return neurodiverseSensoryBagComments;
	}
	public void setNeurodiverseSensoryBagComments(String neurodiverseSensoryBagComments) {
		this.neurodiverseSensoryBagComments = neurodiverseSensoryBagComments;
	}
	public String getNeurodiverseLoudNoiseReductionComments() {
		return neurodiverseLoudNoiseReductionComments;
	}
	public void setNeurodiverseLoudNoiseReductionComments(String neurodiverseLoudNoiseReductionComments) {
		this.neurodiverseLoudNoiseReductionComments = neurodiverseLoudNoiseReductionComments;
	}
	public String getNeurodiverseQuieterTimeAdsComments() {
		return neurodiverseQuieterTimeAdsComments;
	}
	public void setNeurodiverseQuieterTimeAdsComments(String neurodiverseQuieterTimeAdsComments) {
		this.neurodiverseQuieterTimeAdsComments = neurodiverseQuieterTimeAdsComments;
	}
	public String getNeurodiverseFlashingSignageComments() {
		return neurodiverseFlashingSignageComments;
	}
	public void setNeurodiverseFlashingSignageComments(String neurodiverseFlashingSignageComments) {
		this.neurodiverseFlashingSignageComments = neurodiverseFlashingSignageComments;
	}
	public String getNeurodiverseAdaptedLeafletsComments() {
		return neurodiverseAdaptedLeafletsComments;
	}
	public void setNeurodiverseAdaptedLeafletsComments(String neurodiverseAdaptedLeafletsComments) {
		this.neurodiverseAdaptedLeafletsComments = neurodiverseAdaptedLeafletsComments;
	}
	public String getNeurodiverseSupportiveStaffComments() {
		return neurodiverseSupportiveStaffComments;
	}
	public void setNeurodiverseSupportiveStaffComments(String neurodiverseSupportiveStaffComments) {
		this.neurodiverseSupportiveStaffComments = neurodiverseSupportiveStaffComments;
	}
	public String getNeurodiverseTrainedStaffComments() {
		return neurodiverseTrainedStaffComments;
	}
	public void setNeurodiverseTrainedStaffComments(String neurodiverseTrainedStaffComments) {
		this.neurodiverseTrainedStaffComments = neurodiverseTrainedStaffComments;
	}
	
	
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getTLVerifiedDate() {
		return TLVerifiedDate;
	}
	public void setTLVerifiedDate(Date tLVerifiedDate) {
		TLVerifiedDate = tLVerifiedDate;
	}
	public Date getTLAuditedDate() {
		return TLAuditedDate;
	}
	public void setTLAuditedDate(Date tLAuditedDate) {
		TLAuditedDate = tLAuditedDate;
	}
	
	
	
	public List<CommentForm> getCommentForm() {
		return commentForm;
	}
	public void setCommentForm(List<CommentForm> commentForm) {
		this.commentForm = commentForm;
	}
	@Override
	public String toString() {
		return "VenueAdvertFormBean [id=" + id + ", venueName=" + venueName + ", venueType=" + venueType
				+ ", venueLocation=" + venueLocation + ", venuePostCode=" + venuePostCode + ", venueAuditFlg="
				+ venueAuditFlg + ", venueAuditFlgTL=" + venueAuditFlgTL + ", TLVerifiedVenueAdvertFlg="
				+ TLVerifiedVenueAdvertFlg + ", businessEmail=" + businessEmail + ", media=" + media + ", user=" + user
				+ ", mobilityDisabledCarParking=" + mobilityDisabledCarParking + ", mobilityHeadphonesAvailable="
				+ mobilityHeadphonesAvailable + ", mobilityAccessibleRoute=" + mobilityAccessibleRoute
				+ ", mobilityWideDoorways=" + mobilityWideDoorways + ", mobilityWheelchairSeating="
				+ mobilityWheelchairSeating + ", mobilityDisabledToilets=" + mobilityDisabledToilets
				+ ", mobilityChangingPlace=" + mobilityChangingPlace + ", mobilityLowerCounters="
				+ mobilityLowerCounters + ", mobilityLifts=" + mobilityLifts + ", mobilityRamps=" + mobilityRamps
				+ ", mobilityUnrestrictedViewing=" + mobilityUnrestrictedViewing + ", mobilityAccessibleDoors="
				+ mobilityAccessibleDoors + ", mobilityEyeLevelSignage=" + mobilityEyeLevelSignage
				+ ", mobilitySupportiveStaff=" + mobilitySupportiveStaff + ", mobilityTrainedStaff="
				+ mobilityTrainedStaff + ", mobilityComments=" + mobilityComments + ", blindHighContrastSignage="
				+ blindHighContrastSignage + ", blindLargeFontSignage=" + blindLargeFontSignage
				+ ", blindBrailleSignage=" + blindBrailleSignage + ", blindVisibleWalkways=" + blindVisibleWalkways
				+ ", blindTouchTours=" + blindTouchTours + ", blindLargeSubtitles=" + blindLargeSubtitles
				+ ", blindNoTripHazards=" + blindNoTripHazards + ", blindAdjustableLighting=" + blindAdjustableLighting
				+ ", blindAudioDescriptions=" + blindAudioDescriptions + ", blindAdaptedLeaflets="
				+ blindAdaptedLeaflets + ", blindAdaptedSignage=" + blindAdaptedSignage + ", blindFrontSeating="
				+ blindFrontSeating + ", blindSupportiveStaff=" + blindSupportiveStaff + ", blindTrainedStaff="
				+ blindTrainedStaff + ", blindComments=" + blindComments + ", deafHearingLoops=" + deafHearingLoops
				+ ", deafAssistiveTechnology=" + deafAssistiveTechnology + ", deafSignLanguage=" + deafSignLanguage
				+ ", deafAdequateSignage=" + deafAdequateSignage + ", deafSubtitles=" + deafSubtitles
				+ ", deafFrontSeating=" + deafFrontSeating + ", deafSupportiveStaff=" + deafSupportiveStaff
				+ ", deafTrainedStaff=" + deafTrainedStaff + ", deafComments=" + deafComments
				+ ", neurodiverseNoiseReduction=" + neurodiverseNoiseReduction + ", neurodiverseAdjustableLighting="
				+ neurodiverseAdjustableLighting + ", neurodiverseQuieterAreas=" + neurodiverseQuieterAreas
				+ ", neurodiverseSensoryBag=" + neurodiverseSensoryBag + ", neurodiverseLoudNoiseReduction="
				+ neurodiverseLoudNoiseReduction + ", neurodiverseQuieterTimeAds=" + neurodiverseQuieterTimeAds
				+ ", neurodiverseFlashingSignage=" + neurodiverseFlashingSignage + ", neurodiverseAdaptedLeaflets="
				+ neurodiverseAdaptedLeaflets + ", neurodiverseSupportiveStaff=" + neurodiverseSupportiveStaff
				+ ", neurodiverseTrainedStaff=" + neurodiverseTrainedStaff + ", neurodiverseComments="
				+ neurodiverseComments + "]";
	}
	
	

    
}
