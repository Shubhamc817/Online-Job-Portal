package com.shubham.ip.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.shubham.ip.Entity.JobDetails;

/**
 * 
 * @author sh953432 Handles all the used DB operartions being performed on the
 *         JobDetails Entity
 *         JobDetails Has @ManyToMany Relation with JobSeeker
 *
 */
public class JobDAOImpl implements JobDAO {

	SessionFactory sessionFactory;

	public JobDAOImpl(SessionFactory factory) {

		this.sessionFactory = factory;
	}

	@Transactional
	public List<JobDetails> getJobDetails() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();

		List<JobDetails> list = session.createQuery("from JobDetails", JobDetails.class).list();

		return list;

	}

	@Transactional
	public void saveJob(JobDetails theJob) {
		// TODO Auto-generated method stub

		System.out.println(sessionFactory);
		Session session = sessionFactory.getCurrentSession();

		session.saveOrUpdate(theJob);

	}

	@Transactional
	public void updateJobDetails(JobDetails job) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		session.update(job);

	}

	@Transactional
	public void updateJobWithApplicants(JobDetails job) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		session.merge(job);

	}

	@Transactional
	public JobDetails getJobDetail(int theId) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.getCurrentSession();

		JobDetails job = session.get(JobDetails.class, theId);
		if(job!=null)
		Hibernate.initialize(job.getApplicant());

		return job;
	}

	@Override
	@Transactional
	public void deleteJob(int id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		session.delete(getJobDetail(id));
	}

	@Override
	@Transactional
	public List<JobDetails> showJobBySkill(String skill) {
		// TODO Auto-generated method stub
		List<JobDetails> list=null;
		try
		{
	    System.out.println("Fetching Records .....................");
		Session session=sessionFactory.getCurrentSession();
		
		Criteria c=session.createCriteria(JobDetails.class);
		c.add(Restrictions.ilike("mandSkills","%"+skill+"%"));
		list=c.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	
	}

	@Override
	@Transactional
	public List<JobDetails> showJobByLoc(String loc) {
		// TODO Auto-generated method stub
		List<JobDetails> list=null;
		try
		{
	    System.out.println("Fetching Records .....................");
		Session session=sessionFactory.getCurrentSession();
		
		Criteria c=session.createCriteria(JobDetails.class);
		c.add(Restrictions.ilike("location","%"+loc+"%"));
		list=c.list();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	@Transactional
	public List<JobDetails> showJobByExp(String exp) {
		List<JobDetails> list=null;
		try
		{
	    
		Session session=sessionFactory.getCurrentSession();
		
		Criteria c=session.createCriteria(JobDetails.class);
		c.add(Restrictions.ge("empExp",Double.parseDouble(exp)));
		list=c.list();
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
		

}
