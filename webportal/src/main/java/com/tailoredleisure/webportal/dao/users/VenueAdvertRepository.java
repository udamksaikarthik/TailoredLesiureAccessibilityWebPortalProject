package com.tailoredleisure.webportal.dao.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tailoredleisure.webportal.entity.VenueAdvertForm;

@Repository
public interface VenueAdvertRepository extends JpaRepository<VenueAdvertForm, Long>{

}
