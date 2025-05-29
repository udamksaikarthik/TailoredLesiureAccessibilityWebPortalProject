package com.tailoredleisure.webportal.entity;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "comment")
public class CommentForm {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for VenueAdvertForm
	
    // Section 1: Venue Information
    private String commentText;
    

    @Column(name = "rating")
    private int rating;
    

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdDate;
    
    
    // Many-to-One Relationship with VenueAdvertForm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_advert_form_id", nullable = false)
    private VenueAdvertForm venueAdvertForm; // Associated VenueAdvertForm
    

    // Many-to-One Relationship with VenueAdvertForm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference // Backward reference
    private Users userComment; // Associated VenueAdvertForm
    
    private Boolean tlVerifiedFlg = false;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCommentText() {
		return commentText;
	}


	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}


	public LocalDateTime getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}


	public VenueAdvertForm getVenueAdvertForm() {
		return venueAdvertForm;
	}


	public void setVenueAdvertForm(VenueAdvertForm venueAdvertForm) {
		this.venueAdvertForm = venueAdvertForm;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public Users getUserComment() {
		return userComment;
	}


	public void setUserComment(Users userComment) {
		this.userComment = userComment;
	}


	public Boolean getTlVerifiedFlg() {
		return tlVerifiedFlg;
	}


	public void setTlVerifiedFlg(Boolean tlVerifiedFlg) {
		this.tlVerifiedFlg = tlVerifiedFlg;
	}
	
    
}
