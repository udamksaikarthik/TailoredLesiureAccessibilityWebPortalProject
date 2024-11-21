package com.tailoredleisure.webportal.service.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tailoredleisure.webportal.bean.Users;
import com.tailoredleisure.webportal.dao.users.UserDao;


@Service
public class UserService implements UserServiceImpl{
	
	@Autowired
	private UserDao userDao;

	@Override
	public void registerUser(Users users) {
		// TODO Auto-generated method stub
		userDao.saveUser(users);
	}

	@Override
	public Boolean checkIfGmailAlreadyExists(Users users) {
		// TODO Auto-generated method stub
		return userDao.checkIfGmailAlreadyExists(users);
	}

}
