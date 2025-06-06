package com.tailoredleisure.webportal.service.users;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailoredleisure.webportal.bean.CommentForm;
import com.tailoredleisure.webportal.bean.VenueAdvertForm;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
import com.tailoredleisure.webportal.dao.users.HomeDao;
import com.tailoredleisure.webportal.entity.PasswordResetToken;
import com.tailoredleisure.webportal.entity.Users;

import jakarta.validation.Valid;

@Service
public class HomeService implements HomeServiceImpl{
	
	@Autowired
	private HomeDao homeDao;
	

	@Override
	public String generateResetToken(String email) {
		// TODO Auto-generated method stub
		return homeDao.generateResetToken(email);
	}

	@Override
	public PasswordResetToken findByToken(String token) {
		// TODO Auto-generated method stub
		return homeDao.findByToken(token);
	}

	@Override
	public void delete(PasswordResetToken resetToken) {
		// TODO Auto-generated method stub
		homeDao.delete(resetToken);
	}

	@Override
	public Boolean saveAdvertForm(@Valid VenueAdvertForm venueAdvertForm, Users user) {
		// TODO Auto-generated method stub
		
		return homeDao.saveAdvertForm(venueAdvertForm,user);
	}

	@Override
	public ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> getAllAdverts(boolean b) {
		// TODO Auto-generated method stub
		return homeDao.getAllAdverts(b);
	}

	@Override
	public VenueAdvertFormBean getSelectedVenueAdvertForm(Long id) {
		// TODO Auto-generated method stub
		return homeDao.getSelectedVenueAdvertForm(id);
	}

	@Override
	public ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> getAllAdvertsOfBusiness(Users user) {
		// TODO Auto-generated method stub
		return homeDao.getAllAdvertsOfBusiness(user);
	}

	@Override
	public void deleteMediaFile(Long mediaId) {
		// TODO Auto-generated method stub
		homeDao.deleteMediaFile(mediaId);
	}

	@Override
	public Boolean updateAdvertForm(@Valid VenueAdvertForm venueAdvertForm, Users user) {
		// TODO Auto-generated method stub
		return homeDao.updateAdvertForm(venueAdvertForm, user);
	}

	@Override
	public void deleteAdvert(Long advertId) {
		// TODO Auto-generated method stub
		homeDao.deleteAdvert(advertId);
	}

	@Override
	public int getExistingMediaCount(Long id) {
		// TODO Auto-generated method stub
		return homeDao.getExistingMediaCount(id);
	}

	@Override
	public void advertAddComment(Long advertId, CommentForm commentForm, Users user) {
		// TODO Auto-generated method stub
		homeDao.advertAddComment(advertId, commentForm, user);
		
	}

}
