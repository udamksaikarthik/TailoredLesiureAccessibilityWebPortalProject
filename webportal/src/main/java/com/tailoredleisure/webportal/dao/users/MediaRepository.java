package com.tailoredleisure.webportal.dao.users;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tailoredleisure.webportal.entity.Media;

import jakarta.transaction.Transactional;


public interface MediaRepository extends JpaRepository<Media, Integer>{

	@Transactional
	void deleteById(Long mediaId);

}
