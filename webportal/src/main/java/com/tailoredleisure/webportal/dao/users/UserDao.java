package com.tailoredleisure.webportal.dao.users;

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
	
	private com.tailoredleisure.webportal.entity.Users convertToUserEntity(Users users) {
        com.tailoredleisure.webportal.entity.Users userEntity = new com.tailoredleisure.webportal.entity.Users();

        userEntity.setFirstName(users.getFirstName());
        userEntity.setLastName(users.getLastName());
        userEntity.setEmail(users.getEmail());

        // Encrypt the password before saving
        userEntity.setPassword(passwordEncoder.encode(users.getPassword()));

        userEntity.setRole(users.getRole());
        userEntity.setAddress(users.getAddress());
        userEntity.setCreatedAt(new Date());

        return userEntity;
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

}
