package com.shubham.ip.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.shubham.ip.Entity.JobDetails;

/**
 * @author sh953432 Interface to JobDAOImpl
 *
 */

@Repository
public interface JobDAO {

	public List<JobDetails> getJobDetails();

	public void saveJob(JobDetails theJob);

	public JobDetails getJobDetail(int theId);

	public void updateJobDetails(JobDetails job);

	public void updateJobWithApplicants(JobDetails job);

	public void deleteJob(int id);

	public List<JobDetails> showJobBySkill(String skill);

	public List<JobDetails> showJobByLoc(String loc);

	public List<JobDetails> showJobByExp(String exp);

}
