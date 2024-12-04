package com.tailoredleisure.webportal.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class VenueAdvertForm {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for VenueAdvertForm
	
    // Section 1: Venue Information
    @NotBlank(message = "Venue Name is mandatory")
    private String venueName;

    @NotBlank(message = "Venue Type is mandatory")
    private String venueType;

    @NotBlank(message = "Venue Location is mandatory")
    private String venueLocation;

    @NotBlank(message = "Venue Post Code is mandatory")
    private String venuePostCode;

    @NotNull(message = "This field is mandatory")
    private Boolean venueAuditFlg;

    // Section 2: Upload Venue Images/Videos (One-to-Many Relationship)
    @OneToMany(mappedBy = "venueAdvertForm", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Media> media; // Media files associated with the venue

    // Section 3: Mobility Access Checklist
    @NotNull(message = "This field is mandatory")
    private Boolean mobilityDisabledCarParking;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityHeadphonesAvailable;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityAccessibleRoute;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityWideDoorways;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityWheelchairSeating;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityDisabledToilets;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityToiletTurnaround;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityChangingPlace;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityLowerCounters;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityLifts;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityRamps;

    @NotBlank(message = "This field is mandatory")
    private String mobilityUnrestrictedViewing;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityAccessibleDoors;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityEyeLevelSignage;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilitySupportiveStaff;

    @NotNull(message = "This field is mandatory")
    private Boolean mobilityTrainedStaff;

    private String mobilityComments;

    // Section 4: Blind Visually Impaired Access Checklist
    @NotNull(message = "This field is mandatory")
    private Boolean blindHighContrastSignage;

    @NotNull(message = "This field is mandatory")
    private Boolean blindLargeFontSignage;

    @NotNull(message = "This field is mandatory")
    private Boolean blindBrailleSignage;

    @NotNull(message = "This field is mandatory")
    private Boolean blindVisibleWalkways;

    @NotNull(message = "This field is mandatory")
    private Boolean blindTouchTours;

    @NotNull(message = "This field is mandatory")
    private Boolean blindLargeSubtitles;

    @NotNull(message = "This field is mandatory")
    private Boolean blindNoTripHazards;

    @NotNull(message = "This field is mandatory")
    private Boolean blindAdjustableLighting;

    @NotNull(message = "This field is mandatory")
    private Boolean blindAudioDescriptions;

    @NotNull(message = "This field is mandatory")
    private Boolean blindAdaptedLeaflets;

    @NotNull(message = "This field is mandatory")
    private Boolean blindAdaptedSignage;

    @NotBlank(message = "This field is mandatory")
    private String blindFrontSeating;

    @NotNull(message = "This field is mandatory")
    private Boolean blindSupportiveStaff;

    @NotNull(message = "This field is mandatory")
    private Boolean blindTrainedStaff;

    private String blindComments;

    // Section 5: Deaf/Hard of Hearing Access Checklist
    @NotNull(message = "This field is mandatory")
    private Boolean deafHearingLoops;

    @NotNull(message = "This field is mandatory")
    private Boolean deafAssistiveTechnology;

    @NotNull(message = "This field is mandatory")
    private Boolean deafSignLanguage;

    @NotNull(message = "This field is mandatory")
    private Boolean deafAdequateSignage;

    @NotNull(message = "This field is mandatory")
    private Boolean deafSubtitles;

    @NotBlank(message = "This field is mandatory")
    private String deafFrontSeating;

    @NotNull(message = "This field is mandatory")
    private Boolean deafSupportiveStaff;

    @NotNull(message = "This field is mandatory")
    private Boolean deafTrainedStaff;

    private String deafComments;

    // Section 6: Neurodiverse Access Checklist
    @NotNull(message = "This field is mandatory")
    private Boolean neurodiverseNoiseReduction;

    @NotNull(message = "This field is mandatory")
    private Boolean neurodiverseAdjustableLighting;

    @NotNull(message = "This field is mandatory")
    private Boolean neurodiverseQuieterAreas;

    @NotNull(message = "This field is mandatory")
    private Boolean neurodiverseSensoryBag;

    @NotNull(message = "This field is mandatory")
    private Boolean neurodiverseLoudNoiseReduction;

    @NotNull(message = "This field is mandatory")
    private Boolean neurodiverseQuieterTimeAds;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseFlashingSignage;

    @NotNull(message = "This field is mandatory")
    private Boolean neurodiverseAdaptedLeaflets;

    @NotNull(message = "This field is mandatory")
    private Boolean neurodiverseSupportiveStaff;

    @NotNull(message = "This field is mandatory")
    private Boolean neurodiverseTrainedStaff;

    private String neurodiverseComments;


    // Getters and setters for all fields
    
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

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
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

	public Boolean getMobilityToiletTurnaround() {
		return mobilityToiletTurnaround;
	}

	public void setMobilityToiletTurnaround(Boolean mobilityToiletTurnaround) {
		this.mobilityToiletTurnaround = mobilityToiletTurnaround;
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

	public String getMobilityUnrestrictedViewing() {
		return mobilityUnrestrictedViewing;
	}

	public void setMobilityUnrestrictedViewing(String mobilityUnrestrictedViewing) {
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

	public String getBlindFrontSeating() {
		return blindFrontSeating;
	}

	public void setBlindFrontSeating(String blindFrontSeating) {
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

	public String getDeafFrontSeating() {
		return deafFrontSeating;
	}

	public void setDeafFrontSeating(String deafFrontSeating) {
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

	public String getNeurodiverseFlashingSignage() {
		return neurodiverseFlashingSignage;
	}

	public void setNeurodiverseFlashingSignage(String neurodiverseFlashingSignage) {
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

	@Override
	public String toString() {
		return "VenueAdvertForm [id=" + id + ", venueName=" + venueName + ", venueType=" + venueType
				+ ", venueLocation=" + venueLocation + ", venuePostCode=" + venuePostCode + ", venueAuditFlg="
				+ venueAuditFlg + ", media=" + media + ", mobilityDisabledCarParking=" + mobilityDisabledCarParking
				+ ", mobilityHeadphonesAvailable=" + mobilityHeadphonesAvailable + ", mobilityAccessibleRoute="
				+ mobilityAccessibleRoute + ", mobilityWideDoorways=" + mobilityWideDoorways
				+ ", mobilityWheelchairSeating=" + mobilityWheelchairSeating + ", mobilityDisabledToilets="
				+ mobilityDisabledToilets + ", mobilityToiletTurnaround=" + mobilityToiletTurnaround
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
