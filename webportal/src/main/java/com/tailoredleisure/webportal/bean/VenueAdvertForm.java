package com.tailoredleisure.webportal.bean;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class VenueAdvertForm {

    // Section 1: Venue Information
    @NotBlank(message = "Venue Name is mandatory")
    private String venueName;

    @NotBlank(message = "Venue Type is mandatory")
    private String venueType;

    @NotBlank(message = "Venue Location is mandatory")
    private String venueLocation;

    @NotBlank(message = "Venue Post Code is mandatory")
    private String venuePostCode;

    // Section 2: Upload Venue Images/Videos
    @Size(max = 5, message = "You can upload a maximum of 5 media files")
    private List<MultipartFile> mediaFiles;

    // Section 3: Mobility Access Checklist
    @NotBlank(message = "This field is mandatory")
    private String mobilityDisabledCarParking;

    @NotBlank(message = "This field is mandatory")
    private String mobilityHeadphonesAvailable;

    @NotBlank(message = "This field is mandatory")
    private String mobilityAccessibleRoute;

    @NotBlank(message = "This field is mandatory")
    private String mobilityWideDoorways;

    @NotBlank(message = "This field is mandatory")
    private String mobilityWheelchairSeating;

    @NotBlank(message = "This field is mandatory")
    private String mobilityDisabledToilets;

    @NotBlank(message = "This field is mandatory")
    private String mobilityToiletTurnaround;

    @NotBlank(message = "This field is mandatory")
    private String mobilityChangingPlace;

    @NotBlank(message = "This field is mandatory")
    private String mobilityLowerCounters;

    @NotBlank(message = "This field is mandatory")
    private String mobilityLifts;

    @NotBlank(message = "This field is mandatory")
    private String mobilityRamps;

    @NotBlank(message = "This field is mandatory")
    private String mobilityUnrestrictedViewing;

    @NotBlank(message = "This field is mandatory")
    private String mobilityAccessibleDoors;

    @NotBlank(message = "This field is mandatory")
    private String mobilityEyeLevelSignage;

    @NotBlank(message = "This field is mandatory")
    private String mobilitySupportiveStaff;

    @NotBlank(message = "This field is mandatory")
    private String mobilityTrainedStaff;

    private String mobilityComments;

    // Section 4: Blind Visually Impaired Access Checklist
    @NotBlank(message = "This field is mandatory")
    private String blindHighContrastSignage;

    @NotBlank(message = "This field is mandatory")
    private String blindLargeFontSignage;

    @NotBlank(message = "This field is mandatory")
    private String blindBrailleSignage;

    @NotBlank(message = "This field is mandatory")
    private String blindVisibleWalkways;

    @NotBlank(message = "This field is mandatory")
    private String blindTouchTours;

    @NotBlank(message = "This field is mandatory")
    private String blindLargeSubtitles;

    @NotBlank(message = "This field is mandatory")
    private String blindNoTripHazards;

    @NotBlank(message = "This field is mandatory")
    private String blindAdjustableLighting;

    @NotBlank(message = "This field is mandatory")
    private String blindAudioDescriptions;

    @NotBlank(message = "This field is mandatory")
    private String blindAdaptedLeaflets;

    @NotBlank(message = "This field is mandatory")
    private String blindAdaptedSignage;

    @NotBlank(message = "This field is mandatory")
    private String blindFrontSeating;

    @NotBlank(message = "This field is mandatory")
    private String blindSupportiveStaff;

    @NotBlank(message = "This field is mandatory")
    private String blindTrainedStaff;

    private String blindComments;

    // Section 5: Deaf/Hard of Hearing Access Checklist
    @NotBlank(message = "This field is mandatory")
    private String deafHearingLoops;

    @NotBlank(message = "This field is mandatory")
    private String deafAssistiveTechnology;

    @NotBlank(message = "This field is mandatory")
    private String deafSignLanguage;

    @NotBlank(message = "This field is mandatory")
    private String deafAdequateSignage;

    @NotBlank(message = "This field is mandatory")
    private String deafSubtitles;

    @NotBlank(message = "This field is mandatory")
    private String deafFrontSeating;

    @NotBlank(message = "This field is mandatory")
    private String deafSupportiveStaff;

    @NotBlank(message = "This field is mandatory")
    private String deafTrainedStaff;

    private String deafComments;

    // Section 6: Neurodiverse Access Checklist
    @NotBlank(message = "This field is mandatory")
    private String neurodiverseNoiseReduction;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseAdjustableLighting;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseQuieterAreas;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseSensoryBag;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseLoudNoiseReduction;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseQuieterTimeAds;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseFlashingSignage;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseAdaptedLeaflets;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseSupportiveStaff;

    @NotBlank(message = "This field is mandatory")
    private String neurodiverseTrainedStaff;

    private String neurodiverseComments;


    // Getters and Setters for all fields
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

    public List<MultipartFile> getMediaFiles() {
        return mediaFiles;
    }

    public void setMediaFiles(List<MultipartFile> mediaFiles) {
        this.mediaFiles = mediaFiles;
    }

    public String getMobilityDisabledCarParking() {
        return mobilityDisabledCarParking;
    }

    public void setMobilityDisabledCarParking(String mobilityDisabledCarParking) {
        this.mobilityDisabledCarParking = mobilityDisabledCarParking;
    }

    public String getMobilityHeadphonesAvailable() {
        return mobilityHeadphonesAvailable;
    }

    public void setMobilityHeadphonesAvailable(String mobilityHeadphonesAvailable) {
        this.mobilityHeadphonesAvailable = mobilityHeadphonesAvailable;
    }

    public String getMobilityAccessibleRoute() {
        return mobilityAccessibleRoute;
    }

    public void setMobilityAccessibleRoute(String mobilityAccessibleRoute) {
        this.mobilityAccessibleRoute = mobilityAccessibleRoute;
    }

    public String getMobilityWideDoorways() {
        return mobilityWideDoorways;
    }

    public void setMobilityWideDoorways(String mobilityWideDoorways) {
        this.mobilityWideDoorways = mobilityWideDoorways;
    }

    public String getMobilityWheelchairSeating() {
        return mobilityWheelchairSeating;
    }

    public void setMobilityWheelchairSeating(String mobilityWheelchairSeating) {
        this.mobilityWheelchairSeating = mobilityWheelchairSeating;
    }

    public String getMobilityDisabledToilets() {
        return mobilityDisabledToilets;
    }

    public void setMobilityDisabledToilets(String mobilityDisabledToilets) {
        this.mobilityDisabledToilets = mobilityDisabledToilets;
    }

    public String getMobilityToiletTurnaround() {
        return mobilityToiletTurnaround;
    }

    public void setMobilityToiletTurnaround(String mobilityToiletTurnaround) {
        this.mobilityToiletTurnaround = mobilityToiletTurnaround;
    }

    public String getMobilityChangingPlace() {
        return mobilityChangingPlace;
    }

    public void setMobilityChangingPlace(String mobilityChangingPlace) {
        this.mobilityChangingPlace = mobilityChangingPlace;
    }

    public String getMobilityLowerCounters() {
        return mobilityLowerCounters;
    }

    public void setMobilityLowerCounters(String mobilityLowerCounters) {
        this.mobilityLowerCounters = mobilityLowerCounters;
    }

    public String getMobilityLifts() {
        return mobilityLifts;
    }

    public void setMobilityLifts(String mobilityLifts) {
        this.mobilityLifts = mobilityLifts;
    }

    
    public String getMobilityRamps() {
		return mobilityRamps;
	}

	public void setMobilityRamps(String mobilityRamps) {
		this.mobilityRamps = mobilityRamps;
	}

	public String getMobilityUnrestrictedViewing() {
		return mobilityUnrestrictedViewing;
	}

	public void setMobilityUnrestrictedViewing(String mobilityUnrestrictedViewing) {
		this.mobilityUnrestrictedViewing = mobilityUnrestrictedViewing;
	}

	public String getMobilityAccessibleDoors() {
		return mobilityAccessibleDoors;
	}

	public void setMobilityAccessibleDoors(String mobilityAccessibleDoors) {
		this.mobilityAccessibleDoors = mobilityAccessibleDoors;
	}

	public String getMobilityEyeLevelSignage() {
		return mobilityEyeLevelSignage;
	}

	public void setMobilityEyeLevelSignage(String mobilityEyeLevelSignage) {
		this.mobilityEyeLevelSignage = mobilityEyeLevelSignage;
	}

	public String getMobilitySupportiveStaff() {
		return mobilitySupportiveStaff;
	}

	public void setMobilitySupportiveStaff(String mobilitySupportiveStaff) {
		this.mobilitySupportiveStaff = mobilitySupportiveStaff;
	}

	public String getMobilityTrainedStaff() {
		return mobilityTrainedStaff;
	}

	public void setMobilityTrainedStaff(String mobilityTrainedStaff) {
		this.mobilityTrainedStaff = mobilityTrainedStaff;
	}

	public String getMobilityComments() {
        return mobilityComments;
    }

    public void setMobilityComments(String mobilityComments) {
        this.mobilityComments = mobilityComments;
    }

    public String getBlindHighContrastSignage() {
        return blindHighContrastSignage;
    }

    public void setBlindHighContrastSignage(String blindHighContrastSignage) {
        this.blindHighContrastSignage = blindHighContrastSignage;
    }

    public String getBlindLargeFontSignage() {
        return blindLargeFontSignage;
    }

    public void setBlindLargeFontSignage(String blindLargeFontSignage) {
        this.blindLargeFontSignage = blindLargeFontSignage;
    }

    public String getBlindBrailleSignage() {
        return blindBrailleSignage;
    }

    public void setBlindBrailleSignage(String blindBrailleSignage) {
        this.blindBrailleSignage = blindBrailleSignage;
    }

    public String getBlindVisibleWalkways() {
        return blindVisibleWalkways;
    }

    public void setBlindVisibleWalkways(String blindVisibleWalkways) {
        this.blindVisibleWalkways = blindVisibleWalkways;
    }

    public String getBlindTouchTours() {
        return blindTouchTours;
    }

    public void setBlindTouchTours(String blindTouchTours) {
        this.blindTouchTours = blindTouchTours;
    }

    public String getBlindLargeSubtitles() {
        return blindLargeSubtitles;
    }

    public void setBlindLargeSubtitles(String blindLargeSubtitles) {
        this.blindLargeSubtitles = blindLargeSubtitles;
    }

    public String getBlindNoTripHazards() {
        return blindNoTripHazards;
    }

    public void setBlindNoTripHazards(String blindNoTripHazards) {
        this.blindNoTripHazards = blindNoTripHazards;
    }

    public String getBlindAdjustableLighting() {
        return blindAdjustableLighting;
    }

    public void setBlindAdjustableLighting(String blindAdjustableLighting) {
        this.blindAdjustableLighting = blindAdjustableLighting;
    }

    public String getBlindAudioDescriptions() {
        return blindAudioDescriptions;
    }

    public void setBlindAudioDescriptions(String blindAudioDescriptions) {
        this.blindAudioDescriptions = blindAudioDescriptions;
    }

    public String getBlindAdaptedLeaflets() {
        return blindAdaptedLeaflets;
    }

    public void setBlindAdaptedLeaflets(String blindAdaptedLeaflets) {
        this.blindAdaptedLeaflets = blindAdaptedLeaflets;
    }

    public String getBlindComments() {
        return blindComments;
    }

    public void setBlindComments(String blindComments) {
        this.blindComments = blindComments;
    }

    public String getDeafHearingLoops() {
        return deafHearingLoops;
    }

    public void setDeafHearingLoops(String deafHearingLoops) {
        this.deafHearingLoops = deafHearingLoops;
    }

    public String getDeafAssistiveTechnology() {
        return deafAssistiveTechnology;
    }

    public void setDeafAssistiveTechnology(String deafAssistiveTechnology) {
        this.deafAssistiveTechnology = deafAssistiveTechnology;
    }

    public String getDeafSignLanguage() {
        return deafSignLanguage;
    }

    public void setDeafSignLanguage(String deafSignLanguage) {
        this.deafSignLanguage = deafSignLanguage;
    }

    public String getDeafAdequateSignage() {
        return deafAdequateSignage;
    }

    public void setDeafAdequateSignage(String deafAdequateSignage) {
        this.deafAdequateSignage = deafAdequateSignage;
    }

    public String getDeafSubtitles() {
        return deafSubtitles;
    }

    public void setDeafSubtitles(String deafSubtitles) {
        this.deafSubtitles = deafSubtitles;
    }

    public String getDeafComments() {
        return deafComments;
    }

    public void setDeafComments(String deafComments) {
        this.deafComments = deafComments;
    }

    public String getNeurodiverseNoiseReduction() {
        return neurodiverseNoiseReduction;
    }

    public void setNeurodiverseNoiseReduction(String neurodiverseNoiseReduction) {
        this.neurodiverseNoiseReduction = neurodiverseNoiseReduction;
    }

    public String getNeurodiverseAdjustableLighting() {
        return neurodiverseAdjustableLighting;
    }

    public void setNeurodiverseAdjustableLighting(String neurodiverseAdjustableLighting) {
        this.neurodiverseAdjustableLighting = neurodiverseAdjustableLighting;
    }

    public String getNeurodiverseQuieterAreas() {
        return neurodiverseQuieterAreas;
    }

    public void setNeurodiverseQuieterAreas(String neurodiverseQuieterAreas) {
        this.neurodiverseQuieterAreas = neurodiverseQuieterAreas;
    }

    public String getNeurodiverseSensoryBag() {
        return neurodiverseSensoryBag;
    }

    public void setNeurodiverseSensoryBag(String neurodiverseSensoryBag) {
        this.neurodiverseSensoryBag = neurodiverseSensoryBag;
    }

    public String getNeurodiverseFlashingSignage() {
        return neurodiverseFlashingSignage;
    }

    public void setNeurodiverseFlashingSignage(String neurodiverseFlashingSignage) {
        this.neurodiverseFlashingSignage = neurodiverseFlashingSignage;
    }

    public String getNeurodiverseAdaptedLeaflets() {
        return neurodiverseAdaptedLeaflets;
    }

    public void setNeurodiverseAdaptedLeaflets(String neurodiverseAdaptedLeaflets) {
        this.neurodiverseAdaptedLeaflets = neurodiverseAdaptedLeaflets;
    }

    public String getNeurodiverseComments() {
        return neurodiverseComments;
    }

    public void setNeurodiverseComments(String neurodiverseComments) {
        this.neurodiverseComments = neurodiverseComments;
    }

	public String getBlindAdaptedSignage() {
		return blindAdaptedSignage;
	}

	public void setBlindAdaptedSignage(String blindAdaptedSignage) {
		this.blindAdaptedSignage = blindAdaptedSignage;
	}

	public String getBlindFrontSeating() {
		return blindFrontSeating;
	}

	public void setBlindFrontSeating(String blindFrontSeating) {
		this.blindFrontSeating = blindFrontSeating;
	}

	public String getBlindSupportiveStaff() {
		return blindSupportiveStaff;
	}

	public void setBlindSupportiveStaff(String blindSupportiveStaff) {
		this.blindSupportiveStaff = blindSupportiveStaff;
	}

	public String getBlindTrainedStaff() {
		return blindTrainedStaff;
	}

	public void setBlindTrainedStaff(String blindTrainedStaff) {
		this.blindTrainedStaff = blindTrainedStaff;
	}

	public String getDeafFrontSeating() {
		return deafFrontSeating;
	}

	public void setDeafFrontSeating(String deafFrontSeating) {
		this.deafFrontSeating = deafFrontSeating;
	}

	public String getDeafSupportiveStaff() {
		return deafSupportiveStaff;
	}

	public void setDeafSupportiveStaff(String deafSupportiveStaff) {
		this.deafSupportiveStaff = deafSupportiveStaff;
	}

	public String getDeafTrainedStaff() {
		return deafTrainedStaff;
	}

	public void setDeafTrainedStaff(String deafTrainedStaff) {
		this.deafTrainedStaff = deafTrainedStaff;
	}

	public String getNeurodiverseLoudNoiseReduction() {
		return neurodiverseLoudNoiseReduction;
	}

	public void setNeurodiverseLoudNoiseReduction(String neurodiverseLoudNoiseReduction) {
		this.neurodiverseLoudNoiseReduction = neurodiverseLoudNoiseReduction;
	}

	public String getNeurodiverseQuieterTimeAds() {
		return neurodiverseQuieterTimeAds;
	}

	public void setNeurodiverseQuieterTimeAds(String neurodiverseQuieterTimeAds) {
		this.neurodiverseQuieterTimeAds = neurodiverseQuieterTimeAds;
	}

	public String getNeurodiverseSupportiveStaff() {
		return neurodiverseSupportiveStaff;
	}

	public void setNeurodiverseSupportiveStaff(String neurodiverseSupportiveStaff) {
		this.neurodiverseSupportiveStaff = neurodiverseSupportiveStaff;
	}

	public String getNeurodiverseTrainedStaff() {
		return neurodiverseTrainedStaff;
	}

	public void setNeurodiverseTrainedStaff(String neurodiverseTrainedStaff) {
		this.neurodiverseTrainedStaff = neurodiverseTrainedStaff;
	}
    
}

