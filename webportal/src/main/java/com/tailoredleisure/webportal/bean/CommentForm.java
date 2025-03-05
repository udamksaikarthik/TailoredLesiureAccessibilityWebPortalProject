package com.tailoredleisure.webportal.bean;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    private String commentText;
    

    private int rating;
    

    private Users user;
    

    private Date createdDate;

    // Getters and Setters

    /**
     * Gets the comment text.
     * 
     * @return the comment text
     */
    public String getCommentText() {
        return commentText;
    }

    /**
     * Sets the comment text.
     * 
     * @param commentText the text to set
     */
    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
    
    


    public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
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
	
	// Getter for the formatted date
    public String getFormattedCreatedDate() {
    	if (createdDate != null) {
            // Convert java.util.Date to LocalDateTime
            Instant instant = createdDate.toInstant();
            LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

            // Format the LocalDateTime
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm:ss a");
            return localDateTime.format(formatter);
        }
        return null; // or return a default value like "No date available"
    }

	@Override
    public String toString() {
        return "CommentForm{" +
                "commentText='" + commentText + '\'' +
                '}';
    }
}

