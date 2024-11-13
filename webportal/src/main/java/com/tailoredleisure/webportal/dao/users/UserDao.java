package com.tailoredleisure.webportal.dao.users;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tailoredleisure.webportal.model.Users;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userRepository;
	

    @Autowired
    private PasswordEncoder passwordEncoder; 


	public void saveUser(Users user) {
		// TODO Auto-generated method stub
		com.tailoredleisure.webportal.entity.Users userEntity = new com.tailoredleisure.webportal.entity.Users();
		userEntity = convertToUserEntity(user);
		userRepository.save(userEntity);
	}
	

	public Boolean checkIfGmailAlreadyExists(Users users) {
		Boolean flag = false;
		String user_gmail = users.getEmail().trim();
		com.tailoredleisure.webportal.entity.Users user = userRepository.findByEmail(user_gmail);
		if(user!=null) {
			System.out.println("Username already exists");
			flag = true;
		}else {
			System.out.println("New Username");
			flag = false;
		}
		return flag;
	}

	public ArrayList<Users> getAllUsers() {
		ArrayList<com.tailoredleisure.webportal.entity.Users> users = userRepository.findAllByOrderByCreatedAtAsc();
		ArrayList<Users> usersModel = convertToUserModel(users);
		return usersModel;
	}
	

	private com.tailoredleisure.webportal.entity.Users convertToUserEntity(Users users) {
        com.tailoredleisure.webportal.entity.Users userEntity = new com.tailoredleisure.webportal.entity.Users();

        userEntity.setFirstName(users.getFirstName());
        userEntity.setLastName(users.getLastName());
        userEntity.setEmail(users.getEmail());

        // Encrypt the password before saving
        userEntity.setPassword(passwordEncoder.encode(users.getPassword()));

        userEntity.setRole(users.getRole());
        userEntity.setPhoneNumber(users.getPhoneNumber());
        userEntity.setCreatedAt(new Date());

        return userEntity;
    }

	private ArrayList<Users> convertToUserModel(ArrayList<com.tailoredleisure.webportal.entity.Users> users) {
		ArrayList<Users> userModels = new ArrayList<>();
		
		for (com.tailoredleisure.webportal.entity.Users user : users) {
			
			Users userModel = new Users();
	        userModel.setFirstName(user.getFirstName());
	        userModel.setLastName(user.getLastName());
	        userModel.setEmail(user.getEmail());

	        // Encrypt the password before saving
	        userModel.setPassword(passwordEncoder.encode(user.getPassword()));

	        userModel.setRole(user.getRole());
	        userModel.setPhoneNumber(user.getPhoneNumber());
	        userModel.setCreatedAt(user.getCreatedAt());
			userModels.add(userModel);
		}

        return userModels;
    }

}
