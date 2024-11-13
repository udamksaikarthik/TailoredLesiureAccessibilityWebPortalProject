package com.tailoredleisure.webportal.service.admin;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailoredleisure.webportal.dao.users.UserDao;
import com.tailoredleisure.webportal.model.Users;

@Service
public class AdminService implements AdminServiceImpl{
	
	@Autowired
	private UserDao userDao;

	@Override
	public ArrayList<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUsers();
	}

}
