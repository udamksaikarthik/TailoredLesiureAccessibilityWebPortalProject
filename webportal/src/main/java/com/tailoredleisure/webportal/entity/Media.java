package com.tailoredleisure.webportal.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "media")
public class Media {
	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for the Posts table
    
	@Lob
    @Column(name = "media_data", nullable = true, columnDefinition = "LONGBLOB")
    private byte[] mediaData; // Binary data for the media file

    @Column(name = "media_type")
    private String mediaType; // Type of media (e.g., "image/jpeg", "video/mp4")

    @Column(name = "file_name")
    private String fileName; // Optional file name for the media
    
    // Many-to-One Relationship with VenueAdvertForm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_advert_form_id", nullable = false)
    private VenueAdvertForm venueAdvertForm; // Associated VenueAdvertForm

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

	public VenueAdvertForm getVenueAdvertForm() {
		return venueAdvertForm;
	}

	public void setVenueAdvertForm(VenueAdvertForm venueAdvertForm) {
		this.venueAdvertForm = venueAdvertForm;
	}
    
}
