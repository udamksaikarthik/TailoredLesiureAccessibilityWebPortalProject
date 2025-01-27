package com.tailoredleisure.webportal.bean;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

/**
 * Represents the form data for a comment with reactions.
 */
public class CommentForm {

    /**
     * The text of the comment.
     */
    @NotBlank(message = "Comment is mandatory")
    private String commentText;
    

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

	@Override
    public String toString() {
        return "CommentForm{" +
                "commentText='" + commentText + '\'' +
                '}';
    }
}

