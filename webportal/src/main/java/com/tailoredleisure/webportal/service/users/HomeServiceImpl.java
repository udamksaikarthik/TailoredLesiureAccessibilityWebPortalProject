package com.tailoredleisure.webportal.service.users;

import com.tailoredleisure.webportal.bean.VenueAdvertForm;
import com.tailoredleisure.webportal.entity.Users;

import jakarta.validation.Valid;

public interface HomeServiceImpl {

	Boolean saveAdvertForm(@Valid VenueAdvertForm venueAdvertForm, Users user);

}
