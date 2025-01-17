package com.tailoredleisure.webportal.service.users;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailoredleisure.webportal.bean.VenueAdvertForm;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
import com.tailoredleisure.webportal.dao.users.HomeDao;
import com.tailoredleisure.webportal.entity.Users;

import jakarta.validation.Valid;

@Service
public class HomeService implements HomeServiceImpl{
	
	@Autowired
	private HomeDao homeDao;

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

}
