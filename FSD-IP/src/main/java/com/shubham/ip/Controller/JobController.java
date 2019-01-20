package com.shubham.ip.Controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shubham.ip.Entity.JobDetails;
import com.shubham.ip.Entity.JobSeeker;
import com.shubham.ip.dao.JobDAO;
import com.shubham.ip.dao.JobSeekerDAO;

/**
 * @author sh953432
 * 
 * Job Or Say Admin Controller, Provide all the appropriate functionality to admin
 * like add new job, update existing one, delete job, view applicants and download
 * applicant's Resume
 *
 */
@Controller

public class JobController {

	@Autowired
	JobDAO jobDAO;

	@Autowired
	JobSeekerDAO jobseekerDao;

	@RequestMapping("admin/login")
	public String adminForm(Model model) {

		return "admin-login";
	}

	@RequestMapping("admin/home")
	public String adminLogin(@RequestParam("id") String id, @RequestParam("pass") String pass, Model model,
			HttpSession session, HttpServletRequest req, HttpServletResponse res) {

		session = req.getSession();
		session.setMaxInactiveInterval(2000);

		if (id.equals("admin") && pass.equals("admin")) {
			session.setAttribute("admin", id);
			List<JobDetails> jobList = jobDAO.getJobDetails();

			model.addAttribute("jobs", jobList);
			return "all-jobs";
		} else {
			model.addAttribute("msg", "Login Failed,Either your password or id is not valid");
			session.invalidate();
		}

		return "admin-login";

	}

	@RequestMapping("/listJobs")
	public String listJobs(Model theModel, HttpSession session) {

		List<JobDetails> jobList = jobDAO.getJobDetails();

		theModel.addAttribute("jobs", jobList);

		System.out.println(session.getAttribute("admin"));
		if (session.getAttribute("admin") != null && session.getAttribute("admin").equals("admin"))
			return "all-jobs";

		theModel.addAttribute("msg", "Please Login again,you have been logged out");

		return "admin-login";
	}

	@RequestMapping("FormForAddJob")
	public String addJob(Model theModel, HttpSession session) {

		if (session.getAttribute("admin") != null && session.getAttribute("admin").equals("admin")) {
			theModel.addAttribute("job", new JobDetails());

			return "addJob";
		}

		theModel.addAttribute("msg", "You have been logged out,Login again Pleasess");
		return "admin-login";
	}

	@RequestMapping("/FormForUpdateJob")
	public String updateJob(@RequestParam("jobId") int theId, Model theModel, HttpSession session) {

		
		if (session.getAttribute("admin") != null && session.getAttribute("admin").equals("admin")) {
			
			JobDetails theJob = jobDAO.getJobDetail(theId);
			// set customer as a model attribute to pre populate the form

			// System.out.println(theCustomer);
			theModel.addAttribute("job", theJob);

			session.setAttribute("jobToUpdate", theJob);

			// send over to form
			return "addJob";
			
			
		}
		theModel.addAttribute("msg", "You have been logged out,Login again Pleasess");
		return "admin-login";
		
	}

	@RequestMapping("/saveJob")
	public String saveJob(@ModelAttribute("job") JobDetails jobDetail, HttpSession session) {

		// System.out.println(jobDetail);

		// jobDAO.saveJob(jobDetail);

		if (jobDAO.getJobDetail(jobDetail.getJobId()) == null) {

			jobDAO.saveJob(jobDetail);
		} else if (session.getAttribute("jobToUpdate") != null) {
			// existing person, call update
			JobDetails jd = (JobDetails) session.getAttribute("jobToUpdate");

			List<JobSeeker> js = jd.getApplicant();

			jobDAO.updateJobDetails(jobDetail);

			Iterator<JobSeeker> itr = js.iterator();
			JobDetails updatedJd = jobDAO.getJobDetail(jobDetail.getJobId());
			while (itr.hasNext()) {

				JobSeeker jsi = itr.next();
				// js.addApplicant(emp);
				// jobDao.updateJobWithApplicants(js);
				updatedJd.addApplicant(jsi);

				// jobseekerDao.updateJobSeekerWithJob(jsi);

				jobDAO.updateJobWithApplicants(updatedJd);

			}

		}

		return "redirect: listJobs";
	}

	@RequestMapping("/showJob")
	public String showJobDetails(@RequestParam("jobId") int theId, Model theModel) {

		// get the customer from the DB
		JobDetails job = jobDAO.getJobDetail(theId);
		// set customer as a model attribute to pre populate the form

		System.out.println(job);
		theModel.addAttribute("job", job);

		// send over to form

		return "jobs-detail";
	}

	@RequestMapping("/applicants")
	public String viewApplicants(@RequestParam("jobId") int theId, Model theModel,HttpSession session) {

		if (session.getAttribute("admin") != null && session.getAttribute("admin").equals("admin")) {
		JobDetails job = jobDAO.getJobDetail(theId);

		List<JobSeeker> list = job.getApplicant();

		System.out.print(list);

		theModel.addAttribute("applicants", list);

		return "applicants";
	}
		else {
			
			theModel.addAttribute("msg", "You have been logged out,Login again Pleasess");
			return "admin-login";
		}
	}

	@RequestMapping("/deleteJob")
	public String deleteJob(Model model, @RequestParam("jobId") int id, HttpSession session) {

		if (session.getAttribute("admin") != null) {
			jobDAO.deleteJob(id);

			List<JobDetails> jobList = jobDAO.getJobDetails();

			model.addAttribute("jobs", jobList);

			return "all-jobs";
		} else {
			model.addAttribute("msg", "You have been logged out,Please login again");
			return "admin-login";
		}

	}

	@RequestMapping("admin/logout")
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		if (request.getSession() != null)
			session.invalidate();

		model.addAttribute("msg", "You are logged out successfully");
		return "index";
	}

}
