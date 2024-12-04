package com.tailoredleisure.webportal.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailoredleisure.webportal.bean.VenueAdvertForm;
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

}
