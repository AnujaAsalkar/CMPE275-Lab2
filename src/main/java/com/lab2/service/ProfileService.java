package com.lab2.service;

import java.util.List;

import com.lab2.model.Profile;

public interface ProfileService {
	public void add(Profile prof);
	public void edit(Profile prof);
	public void delete(String id);
	public Profile getProfile(String id);
	public List getAllProfile();


}
