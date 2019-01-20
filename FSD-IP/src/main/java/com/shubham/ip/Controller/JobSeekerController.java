/**
 * 
 */
package com.shubham.ip.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shubham.ip.Entity.JobSeeker;
import com.shubham.ip.dao.JobDAO;

/**
 * @author sh953432
 * JobSeeker Controller - Handles JobSeeker Login, and renders its home page, if login successful
 */

@Controller
@RequestMapping("/jobseeker")
public class JobSeekerController {

	@Autowired
	JobDAO jobDAO;

	@RequestMapping("/jobSeekerLogin")
	public String login(Model theModel) {

		theModel.addAttribute("jobseeker", new JobSeeker());
		return "jobSeeker-login";

	}

	@RequestMapping("/home")
	public String home(@ModelAttribute("jobseeker") JobSeeker jobseeker, Model model, HttpSession session) {

		if (session.getAttribute("user") != null) {
			model.addAttribute("jobs", jobDAO.getJobDetails());
			//model.addAttribute("jobseeker", session.getAttribute("user"));
			model.addAttribute("jobseeker", session.getAttribute("user"));
			// System.out.println(jobseeker.getId());
			return "jobseeker-home";
		} else {

			model.addAttribute("msg", "You have been logged out, Login again,Please");
			return "jobSeeker-login";
		}

	}

}
