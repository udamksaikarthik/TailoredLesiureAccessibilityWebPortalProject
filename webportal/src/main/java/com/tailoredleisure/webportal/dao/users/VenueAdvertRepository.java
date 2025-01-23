package com.tailoredleisure.webportal.dao.users;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tailoredleisure.webportal.entity.Users;
import com.tailoredleisure.webportal.entity.VenueAdvertForm;

@Repository
public interface VenueAdvertRepository extends JpaRepository<VenueAdvertForm, Long>{

	@Query("SELECT a FROM VenueAdvertForm a WHERE a.TLVerifiedVenueAdvertFlg = :flag")
	ArrayList<VenueAdvertForm> findAllAdvertsByVerifiedFlag(@Param("flag") Boolean flag);

	@Query("SELECT a FROM VenueAdvertForm a WHERE a.user = :user")
	ArrayList<VenueAdvertForm> findAllAdvertsByUserId(Users user);

}
