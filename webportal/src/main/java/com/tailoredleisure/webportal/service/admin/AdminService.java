package com.tailoredleisure.webportal.service.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailoredleisure.webportal.bean.Users;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
import com.tailoredleisure.webportal.dao.users.HomeDao;
import com.tailoredleisure.webportal.dao.users.UserDao;
import com.tailoredleisure.webportal.entity.VenueAdvertForm;

@Service
public class AdminService implements AdminServiceImpl{
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private HomeDao homeDao;

	@Override
	public ArrayList<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

	@Override
	public ArrayList<VenueAdvertForm> getAllAdverts(boolean flag) {
		// TODO Auto-generated method stub
		return homeDao.getAllAdverts(flag);
	}

	@Override
	public VenueAdvertFormBean getSelectedVenueAdvertForm(Long id) {
		// TODO Auto-generated method stub
		
		return homeDao.getSelectedVenueAdvertForm(id);
	}

}
