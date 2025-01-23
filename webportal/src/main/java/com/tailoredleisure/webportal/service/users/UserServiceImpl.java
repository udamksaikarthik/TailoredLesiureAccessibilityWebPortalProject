package com.tailoredleisure.webportal.service.users;


import com.tailoredleisure.webportal.bean.Users;



public interface UserServiceImpl {

	void registerUser(Users users);

	Boolean checkIfGmailAlreadyExists(Users users);
	
}
