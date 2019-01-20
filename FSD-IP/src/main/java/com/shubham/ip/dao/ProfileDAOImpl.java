package com.shubham.ip.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.ip.Entity.Profile;

/**
 * @author sh953432 Handles all the used DB operartion being performed on the
 *         JobSeeker's Profile like add, update and fetch
 *         JobSeeker Has @OneToOne Relationship with Profile
 *        
 *
 */

public class ProfileDAOImpl implements ProfileDAO {

	SessionFactory sessionFactory;

	public ProfileDAOImpl(SessionFactory factory) {

		this.sessionFactory = factory;
	}

	@Override
	@Transactional
	public void addResume(Profile profile) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		System.out.println("Saving profile");
		session.saveOrUpdate(profile);
		System.out.println("Profile saved to DB");

	}

	@Override
	@Transactional
	public void updateResume(Profile profile) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(profile);

	}

	@Override
	@Transactional
	public Profile getProfile(int id) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();
		System.out.println("fetching profile");
		Profile profile = session.get(Profile.class, id);
		System.out.println("Profile " + profile + "fetched from DB");
		return profile;
	}

}
