package com.tailoredleisure.webportal.dao.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tailoredleisure.webportal.entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);

}
