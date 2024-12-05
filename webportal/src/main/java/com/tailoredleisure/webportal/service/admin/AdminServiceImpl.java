package com.tailoredleisure.webportal.service.admin;

import java.util.ArrayList;

import com.tailoredleisure.webportal.bean.Users;
import com.tailoredleisure.webportal.entity.VenueAdvertForm;

public interface AdminServiceImpl {

	ArrayList<Users> getAllUsers();

	ArrayList<VenueAdvertForm> getAllAdverts(boolean b);

	VenueAdvertForm getSelectedVenueAdvertForm(Long id);


}
