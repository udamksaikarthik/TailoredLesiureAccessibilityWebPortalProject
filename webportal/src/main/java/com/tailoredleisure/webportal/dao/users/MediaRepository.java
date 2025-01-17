package com.tailoredleisure.webportal.dao.users;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailoredleisure.webportal.entity.Media;
import com.tailoredleisure.webportal.entity.VenueAdvertForm;

import jakarta.transaction.Transactional;


public interface MediaRepository extends JpaRepository<Media, Integer>{

	@Transactional
	void deleteById(Long mediaId);

	ArrayList<Media> findByVenueAdvertForm(VenueAdvertForm venueAdvertFormEntity);

}
