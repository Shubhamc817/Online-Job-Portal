/**
 * 
 */
package com.shubham.ip.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author sh953432
 * 				Entity Bean to JobSeeker which is mapped to employee table in DB
 *
 */

@Entity
@Table(name = "employee")
public class JobSeeker {
	@Id
	@Column(name = "id")
	private int id;

	public JobSeeker() {

	}

	@Column(name = "password")
	private String password;

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "skills")
	private String skillset;

	@Column(name = "dob")
	private Date dob;

	@Column(name = "qualification")
	private String qualification;

	@Column(name = "experience")
	private int experience;

	@Column(name = "gender")
	private String gender;

	@Column(name = "email")
	private String email;

	@Column(name = "contact")
	private String contact;

	@OneToOne(mappedBy = "empId", cascade = { CascadeType.ALL })
	private Profile profile;

	/**
	 * @return the profile
	 */
	public Profile getProfile() {
		return profile;
	}

	/**
	 * @param profile
	 *            the profile to set
	 */
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	/**
	 * @param js
	 *            the appliedJobs to set
	 */

	@ManyToMany // (cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "emp_job", joinColumns = @JoinColumn(name = "emp_id"), inverseJoinColumns = @JoinColumn(name = "job_id"))
	List<JobDetails> appliedJobs;

	/**
	 * @return the appliedJobs
	 */
	public List<JobDetails> getAppliedJobs() {
		return appliedJobs;
	}

	/**
	 * @param appliedJobs
	 *            the appliedJobs to set
	 */
	public void setAppliedJobs(JobDetails jobs) {
		if (appliedJobs == null) {
			new ArrayList<JobDetails>();
		}
		appliedJobs.add(jobs);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSkillset() {
		return skillset;
	}

	public void setSkillset(String skillset) {
		this.skillset = skillset;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "JobSeeker [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", skillset=" + skillset
				+ ", dob=" + dob + ", qualification=" + qualification + ", experience=" + experience + ", gender="
				+ gender + ", email=" + email + ", contact=" + contact + ", password=" + password + "]";
	}

}
