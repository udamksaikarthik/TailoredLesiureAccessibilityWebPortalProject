package com.tailoredleisure.webportal.entity;

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
import jakarta.persistence.OneToOne;
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
    @NotBlank(message = "Comment is mandatory")
    private String commentText;
    

    @Column(name = "created_date", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    
    
    // Many-to-One Relationship with VenueAdvertForm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_advert_form_id", nullable = false)
    private VenueAdvertForm venueAdvertForm; // Associated VenueAdvertForm
    

    // Many-to-One Relationship with VenueAdvertForm
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference // Backward reference
    private Users userComment; // Associated VenueAdvertForm


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


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public VenueAdvertForm getVenueAdvertForm() {
		return venueAdvertForm;
	}


	public void setVenueAdvertForm(VenueAdvertForm venueAdvertForm) {
		this.venueAdvertForm = venueAdvertForm;
	}


	public Users getUser() {
		return userComment;
	}


	public void setUser(Users userComment) {
		this.userComment = userComment;
	}
    
    
}
