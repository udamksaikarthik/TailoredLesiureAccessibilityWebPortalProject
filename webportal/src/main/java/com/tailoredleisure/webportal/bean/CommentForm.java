package com.tailoredleisure.webportal.bean;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * Represents the form data for a comment with reactions.
 */
public class CommentForm {

    /**
     * The text of the comment.
     */
	
	private Long id;
	
    private String commentText;
    

    private int rating;
    

    private Users user;
    

    private LocalDateTime createdDate;
    
    private Boolean tlVerifiedFlag;

    // Getters and Setters

    
    
    
    /**
     * Gets the comment text.
     * 
     * @return the comment text
     */
    public String getCommentText() {
        return commentText;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/**
     * Sets the comment text.
     * 
     * @param commentText the text to set
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    
    


    public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	
	
	public Boolean getTlVerifiedFlag() {
		return tlVerifiedFlag;
	}

	public void setTlVerifiedFlag(Boolean tlVerifiedFlag) {
		this.tlVerifiedFlag = tlVerifiedFlag;
	}

	// Getter for the formatted date
    public String getFormattedCreatedDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm:ss a");
        return createdDate != null ? createdDate.format(formatter) : null;
    }

	@Override
    public String toString() {
        return "CommentForm{" +
                "commentText='" + commentText + '\'' +
                '}';
    }
}

