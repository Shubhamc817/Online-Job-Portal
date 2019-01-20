package com.shubham.ip.Entity;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sh953432
 * 			Entity Bean to Profile which is mapped to empProfile table in DB
 *
 */

@Entity
@Table(name = "empProfile")
public class Profile {

	@Id
	@Column(name = "profile_id")
	int profileId;

	@Lob
	@Column(name = "profile")
	byte[] profile;

	@OneToOne(targetEntity = JobSeeker.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id")
	Integer empId;

	/**
	 * @return the profileId
	 */
	public int getProfileId() {
		return profileId;
	}

	/**
	 * @param profileId
	 *            the profileId to set
	 */
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	/**
	 * @return the profile
	 */
	public byte[] getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(byte[] profile) {
		this.profile = profile;
	}

	/**
	 * @return the emp_id
	 */
	public Integer getEmpId() {
		return empId;
	}

	/**
	 * @param emp_id
	 *            the emp_id to set
	 */
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", profile=" + Arrays.toString(profile) + ", empId=" + empId + "]";
	}

}
