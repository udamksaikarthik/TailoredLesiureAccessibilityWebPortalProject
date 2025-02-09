package com.tailoredleisure.webportal.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tailoredleisure.webportal.entity.VenueAdvertForm;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Users {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    private String phoneNumber;

    @NotBlank(message = "Gmail is required")
    @Email(message = "Please enter a valid Gmail")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;

    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;

    @NotBlank(message = "Role is required")
    private String role;
    
    private Date createdAt;
    
    private List<VenueAdvertForm> venueAdvertForm = new ArrayList<>();
    
    public Users() {
    	
    }

    @Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", role=" + role + "]";
	}



	// Getters and Setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public List<VenueAdvertForm> getVenueAdvertForm() {
		return venueAdvertForm;
	}

	public void setVenueAdvertForm(List<VenueAdvertForm> venueAdvertForm) {
		this.venueAdvertForm = venueAdvertForm;
	}
	
}
