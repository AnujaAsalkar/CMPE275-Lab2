package com.lab2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lab2.DAO.ProfileDAOImpl;
import com.lab2.model.Profile;


@Service
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	private ProfileDAOImpl profileDao;
	
	@Transactional
	public void add(Profile prof) {
		// TODO Auto-generated method stub
		profileDao.add(prof);	
	}

	@Transactional
	public void edit(Profile prof) {
		// TODO Auto-generated method stub
		profileDao.edit(prof);
	}

	@Transactional
	public void delete(String id) {
		// TODO Auto-generated method stub
		profileDao.delete(id);
	}

	@Transactional
	public Profile getProfile(String id) {
		// TODO Auto-generated method stub
		return profileDao.getProfile(id);
	}

	@Transactional
	public List getAllProfile() {
		// TODO Auto-generated method stub
		return profileDao.getAllProfile();
	}

}
