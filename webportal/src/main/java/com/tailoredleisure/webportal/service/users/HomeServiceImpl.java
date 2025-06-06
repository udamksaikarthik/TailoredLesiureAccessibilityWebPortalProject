package com.tailoredleisure.webportal.service.users;

import java.util.ArrayList;

import com.tailoredleisure.webportal.bean.CommentForm;
import com.tailoredleisure.webportal.bean.VenueAdvertForm;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
import com.tailoredleisure.webportal.entity.PasswordResetToken;
import com.tailoredleisure.webportal.entity.Users;

import jakarta.validation.Valid;

public interface HomeServiceImpl {

	Boolean saveAdvertForm(@Valid VenueAdvertForm venueAdvertForm, Users user);

	ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> getAllAdverts(boolean b);

	VenueAdvertFormBean getSelectedVenueAdvertForm(Long id);

	ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> getAllAdvertsOfBusiness(Users user);

	void deleteMediaFile(Long mediaId);

	Boolean updateAdvertForm(@Valid VenueAdvertForm venueAdvertForm, Users user);

	void deleteAdvert(Long advertId);

	int getExistingMediaCount(Long id);

	void advertAddComment(Long advertId, @Valid CommentForm commentForm, Users user);

	String generateResetToken(String email);
	
	PasswordResetToken findByToken(String token);

	void delete(PasswordResetToken resetToken);

}
