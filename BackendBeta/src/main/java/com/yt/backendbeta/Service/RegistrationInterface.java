package com.yt.backendbeta.Service;

import java.util.List;

import com.yt.backendbeta.Entity.Registration;

public interface RegistrationInterface {

	public void addRegistration(Registration reg);
	public Registration getRegistrationId(String registrationId);
	public List<Registration> getAllRegistration();
	public List<Registration> getRegistrationName(String name);
}
