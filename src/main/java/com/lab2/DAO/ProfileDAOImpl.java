package com.lab2.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lab2.model.Profile;

@Repository
public class ProfileDAOImpl implements ProfileDAO{
	
	@Autowired
	private SessionFactory session;

	@Override
	public void add(Profile prof) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(prof);
	}

	@Override
	public void edit(Profile prof) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(prof);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(getProfile(id));
	}

	@Override
	public Profile getProfile(String id) {
		// TODO Auto-generated method stub
		return (Profile)session.getCurrentSession().get(Profile.class,id);
	}

	@Override
	public List getAllProfile() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from Profile").list();
	}
	
}
