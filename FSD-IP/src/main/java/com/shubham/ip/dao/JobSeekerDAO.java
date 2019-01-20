package com.shubham.ip.dao;

import java.util.List;

import com.shubham.ip.Entity.JobSeeker;

/**
 * @author sh953432 	Interface to JobSeekerDAOImpl
 *
 */

public interface JobSeekerDAO {

	public JobSeeker getJobSeeker(int id);

	public String applyForJob(int jobSeekerId, int jobId);

	public String updateJobSeeker(JobSeeker jobSeeker);

	public String signUp(JobSeeker emp);

	public JobSeeker login(int id);

	public void updateJobSeekerWithJob(JobSeeker jsi);

}
