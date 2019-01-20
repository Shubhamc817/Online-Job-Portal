package com.shubham.ip.dao;

import com.shubham.ip.Entity.Profile;

/**
 * @author sh953432 Interface to ProfileDAOImpl
 */

public interface ProfileDAO {

	public void addResume(Profile profile);

	public void updateResume(Profile profile);

	public Profile getProfile(int id);

}
