package com.tailoredleisure.webportal.dao.users;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tailoredleisure.webportal.entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);
	
	ArrayList<Users> findAllByOrderByCreatedAtAsc(); // Ascending order

	ArrayList<Users> findAllByOrderByCreatedAtDesc(); // Descending order
}
