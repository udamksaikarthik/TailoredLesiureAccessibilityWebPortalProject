package com.tailoredleisure.webportal.bean;

public class MediaBean {

    private Long id; // Primary key for the media entry

    private byte[] mediaData; // Binary data for the media file

    private String mediaType; // Type of media (e.g., "image/jpeg", "video/mp4")

    private String fileName; // Optional file name for the media

    private String base64MediaData; // Base64-encoded data for rendering

    private Long venueAdvertFormId; // ID of the associated VenueAdvertForm (to avoid exposing the entire entity)

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getMediaData() {
        return mediaData;
    }

    public void setMediaData(byte[] mediaData) {
        this.mediaData = mediaData;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getVenueAdvertFormId() {
        return venueAdvertFormId;
    }

    public void setVenueAdvertFormId(Long venueAdvertFormId) {
        this.venueAdvertFormId = venueAdvertFormId;
    }
    

    public String getBase64MediaData() {
        return base64MediaData;
    }

    public void setBase64MediaData(String base64MediaData) {
        this.base64MediaData = base64MediaData;
    }
}
