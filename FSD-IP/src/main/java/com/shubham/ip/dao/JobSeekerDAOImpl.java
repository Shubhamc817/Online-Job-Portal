/**
 * 
 */
package com.shubham.ip.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.shubham.ip.Entity.JobDetails;
import com.shubham.ip.Entity.JobSeeker;

/**
 * @author sh953432 Handles all the used DB operartions being performed on the
 *         JobSeeker Entity 
 *         JobSeeker Has @ManyToMany Relation with JobDetails
 *
 */
public class JobSeekerDAOImpl implements JobSeekerDAO {

	@Autowired
	JobDAO jobDao;

	SessionFactory sessionFactory;

	public JobSeekerDAOImpl(SessionFactory factory) {

		this.sessionFactory = factory;
	}

	@Override
	public JobSeeker getJobSeeker(int id) {
		// TODO Auto-generated method stub
		Session session;

		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}

		JobSeeker js = session.get(JobSeeker.class, id);
		return js;
	}

	@Override
	@Transactional
	public String applyForJob(int id, int jobId) {
		// TODO Auto-generated method stub

		JobDetails jd = jobDao.getJobDetail(jobId);
		// List<JobSeeker> list=jd.getApplicant();

		System.out.println(jd);

		// list.add(js);

		Session session = sessionFactory.getCurrentSession();
		JobSeeker js = session.get(JobSeeker.class, id);

		System.out.println(js);

		if (jd.getApplicant().contains(js))
			return "exists";

		jd.addApplicant(js);

		// js.setAppliedJobs(jd);

		// System.out.println(js.getAppliedJobs());

		session.update(jd);

		return "success";

	}

	@Override
	@Transactional
	public String updateJobSeeker(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub

		String result = "";
		Session session = sessionFactory.getCurrentSession();
		try {
			session.update(jobSeeker);
			result = "success";
		} catch (Exception e) {
			result = "error";
		}
		return result;

	}

	@Override
	@Transactional
	public String signUp(JobSeeker emp) {
		// TODO Auto-generated method stub
		String result = "";
		Session session = sessionFactory.getCurrentSession();
		try {
			
			if(session.get(JobSeeker.class, emp.getId())==null) {
			session.save(emp);
			result = "success";
			}else
				throw new Exception();
		} catch (Exception e) {
			result = "error";
		}
		return result;
	}

	@Override
	@Transactional
	public JobSeeker login(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		JobSeeker js=null;
        try {
		js = session.get(JobSeeker.class, id);
		if(js.getPassword()==null)throw new Exception();
        }catch(Exception e) {
        	return null;
        }
		return js;
	}

	@Override
	@Transactional
	public void updateJobSeekerWithJob(JobSeeker jobseeker) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		session.merge(jobseeker);

	}

}
