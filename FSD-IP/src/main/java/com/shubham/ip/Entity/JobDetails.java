package com.shubham.ip.Entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author sh953432
 * 			Entity Bean to Jobs which is mapped to job_details table in DB
 *
 */

@Entity
@Table(name = "job_details")
public class JobDetails {

	@Id
	@Column(name = "id")
	private int jobId;

	@Column(name = "jobName")
	private String jobName;

	@Column(name = "jobDescription")
	private String jobDescription;

	@Column(name = "projectName")
	private String projectName;

	@Column(name = "man_skills")
	private String mandSkills;

	@Column(name = "op_skills")
	private String optionalSkills;

	@Column(name = "location")
	private String location;

	@Column(name = "empBand")
	private String empBand;

	@Column(name = "empExp")
	private double empExp;

	@Column(name = "openPosition")
	private int openPosition;

	@Column(name = "cpEmail")
	private String cpEmail;

	@Column(name = "cpContact")
	private String cpContact;

	@ManyToMany // (cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "emp_job", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "emp_id"))
	List<JobSeeker> applicants;

	/**
	 * @return the applicant
	 */
	public List<JobSeeker> getApplicant() {
		return applicants;
	}

	/**
	 * @param applicant
	 *            the applicant to set
	 */
	public void addApplicant(JobSeeker applicant) {
		if (applicants == null) {
			new ArrayList<JobSeeker>();
		}
		applicants.add(applicant);

	}

	public JobDetails() {
		super();
	}

	public JobDetails(int jobId, String jobName, String jobDescription, String projectName, String mandSkills,
			String optionalSkills, String location, String empBand, double empExp, int openPosition, String cpEmail,
			String cpContact) {
		super();
		this.jobId = jobId;
		this.jobName = jobName;
		this.jobDescription = jobDescription;
		this.projectName = projectName;
		this.mandSkills = mandSkills;
		this.optionalSkills = optionalSkills;
		this.location = location;
		this.empBand = empBand;
		this.empExp = empExp;
		this.openPosition = openPosition;
		this.cpEmail = cpEmail;
		this.cpContact = cpContact;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getMandSkills() {
		return mandSkills;
	}

	public void setMandSkills(String mandSkills) {
		this.mandSkills = mandSkills;
	}

	public String getOptionalSkills() {
		return optionalSkills;
	}

	public void setOptionalSkills(String optionalSkills) {
		this.optionalSkills = optionalSkills;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmpBand() {
		return empBand;
	}

	public void setEmpBand(String empBand) {
		this.empBand = empBand;
	}

	public double getEmpExp() {
		return empExp;
	}

	public void setEmpExp(double empExp) {
		this.empExp = empExp;
	}

	public int getOpenPosition() {
		return openPosition;
	}

	public void setOpenPosition(int openPosition) {
		this.openPosition = openPosition;
	}

	public String getCpEmail() {
		return cpEmail;
	}

	public void setCpEmail(String cpEmail) {
		this.cpEmail = cpEmail;
	}

	public String getCpContact() {
		return cpContact;
	}

	public void setCpContact(String cpContact) {
		this.cpContact = cpContact;
	}

	@Override
	public String toString() {
		return "JobDetails [jobId=" + jobId + ", jobName=" + jobName + ", jobDescription=" + jobDescription
				+ ", projectName=" + projectName + ", mandSkills=" + mandSkills + ", optionalSkills=" + optionalSkills
				+ ", location=" + location + ", empBand=" + empBand + ", empExp=" + empExp + ", openPosition="
				+ openPosition + ", cpEmail=" + cpEmail + ", cpContact=" + cpContact + "]";
	}

}
