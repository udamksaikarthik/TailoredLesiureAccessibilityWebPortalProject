package com.tailoredleisure.webportal.service.users;

import java.util.ArrayList;

import com.tailoredleisure.webportal.bean.VenueAdvertForm;
import com.tailoredleisure.webportal.bean.VenueAdvertFormBean;
import com.tailoredleisure.webportal.entity.Users;

import jakarta.validation.Valid;

public interface HomeServiceImpl {

	Boolean saveAdvertForm(@Valid VenueAdvertForm venueAdvertForm, Users user);

	ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> getAllAdverts(boolean b);

	VenueAdvertFormBean getSelectedVenueAdvertForm(Long id);

	ArrayList<com.tailoredleisure.webportal.entity.VenueAdvertForm> getAllAdvertsOfBusiness(Users user);

}
