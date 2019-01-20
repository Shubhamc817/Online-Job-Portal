
/**
 * 
 */
package com.shubham.ip.Controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.shubham.ip.Entity.JobDetails;
import com.shubham.ip.Entity.JobSeeker;
import com.shubham.ip.Entity.Profile;
import com.shubham.ip.dao.JobDAO;
import com.shubham.ip.dao.JobSeekerDAO;
import com.shubham.ip.dao.ProfileDAO;

/**
 * @author sh953432
 * 
 * Main Controller for JobSeeker, apart from rendering home, it provides actions through which
 * jobseeker can login & logout , can view and apply jobs , can upload their CV/Resume
 * and can update their profile
 * 
 *
 */

@Configuration
@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	JobSeekerDAO jobseekerDao;

	@Autowired
	JobDAO jobDao;

	@Autowired
	ProfileDAO profileDao;

	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getCommonsMultipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520); // 20MB
		multipartResolver.setMaxInMemorySize(1048576); // 1MB
		return multipartResolver;
	}

	/**
	 * 
	 * @param binder
	 *            Binds Date formatter
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	/**
	 * 
	 * @param model
	 * @return- JobSeeker Signup page
	 */
	@RequestMapping("/signUp")
	public String signUpPage(Model model) {

		model.addAttribute("jobseeker", new JobSeeker());
		return "SignUp";
	}

	// Registration
	/**
	 * 
	 * @param emp
	 * @param model
	 * @return Processes JobSeeker signup data and returns to JobSeeker login page
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String signUp(@ModelAttribute("jobseeker") JobSeeker emp, Model model) {

		String result = "error";
		String flag = null;
		flag = jobseekerDao.signUp(emp);

		if (flag != "failure") {
			model.addAttribute("msg", "Registration Successful with UserId " + emp.getId());
			model.addAttribute("msg2", "Please login now with UserId ");
			return "jobSeeker-login";
		}
		model.addAttribute("msg", "Couldn't register the user,User with this id already registered,"
				+ " Please use your unique user id");
		return result;
	}

	/**
	 * 
	 * @param jobseeker
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return Handles JobSeeker Login - validates jobSeeker, create session if
	 *         valid user
	 */
	// Employee Login
	@PostMapping("/login")
	public String register(@ModelAttribute("jobseeker") JobSeeker jobseeker, Model model, HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {

		String flag = "error";
        
		
		JobSeeker js = jobseekerDao.login(jobseeker.getId());

		System.out.println(js);

		if (js != null && js.getId() == jobseeker.getId() && js.getPassword().equals(jobseeker.getPassword())) {
			System.out.println("Welcome User!");
			model.addAttribute("jobs", jobDao.getJobDetails());
			model.addAttribute("jobseeker", jobseeker);
			flag = "jobseeker-home";
			model.addAttribute("msg", "welcome: " + js.getFirstName());

			session = request.getSession();
			session.setAttribute("user", jobseeker);

		} else {
			model.addAttribute("msg", "Username or password is not valid!");
			flag = "jobSeeker-login";
		}
		return flag;
	}

	/**
	 * 
	 * @param model
	 * @param request
	 * @param response
	 * @param session
	 * @return
	 * 
	 */
	@RequestMapping("/logout")
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

		if (request.getSession() != null)
			session.invalidate();

		return "index";
	}

	/**
	 * 
	 * @param theId
	 * @param theModel
	 * @param session
	 * @return Show Job Details through which user can apply to particular Job
	 */

	@RequestMapping("/jobview")
	public String viewJob(@RequestParam("jobId") int theId, Model theModel, HttpSession session) {

		// List<JobDetails> jobList=jobDAO.getJobDetails();

		System.out.println(theId);
		// theModel.addAttribute("jobs",jobList);
		session.setAttribute("jobId", theId);
		JobDetails job = jobDao.getJobDetail(theId);
		// set customer as a model attribute to pre populate the form

		// System.out.println(job);

		theModel.addAttribute("job", job);

		return "jobdetail-jobseeker";
	}

	/**
	 * 
	 * @param theModel
	 * @param session
	 * @return Handles Job application of user
	 */
	@RequestMapping("/apply")
	public String applyJob(Model theModel, HttpSession session) {

		if (session.getAttribute("user") != null) {
			JobSeeker js = (JobSeeker) session.getAttribute("user");
			int id = js.getId();
			int jobId = Integer.parseInt(session.getAttribute("jobId").toString());

			String res = jobseekerDao.applyForJob(id, jobId);

			if (res.equals("success")) {
				List<JobDetails> jobs = jobDao.getJobDetails();
				theModel.addAttribute("jobs", jobs);
				session.setAttribute("jobseeker", js);
				return "jobseeker-home";
			} else {

				theModel.addAttribute("msg", "You have already applied");
				JobDetails job = jobDao.getJobDetail(jobId);
				// set customer as a model attribute to pre populate the form

				// System.out.println(job);

				theModel.addAttribute("job", job);

				return "jobdetail-jobseeker";
			}
		} else {
			theModel.addAttribute("msg", "You have been logged out,Login again Pleasess");
			return "index";
		}

	}

	/**
	 * 
	 * @param theModel
	 * @param request
	 * @param file
	 * @param session
	 * @return
	 * @throws Exception
	 *             Handles JobSeeker's Profile Upload and save the profile to DB
	 */
	@RequestMapping("/doUpload")
	public String uploadResume(Model theModel, HttpServletRequest request,
			@RequestParam("file") CommonsMultipartFile file, HttpSession session) throws Exception {

		if (file != null) {

			System.out.println("Saving file: " + file.getOriginalFilename());

			JobSeeker js=(JobSeeker)session.getAttribute("user");
			int empId = js.getId();
			Profile uploadFile = new Profile();
			// uploadFile.setEmpId(empId);
			uploadFile.setProfile(file.getBytes());
			//System.out.println(file.getBytes().toString());
			uploadFile.setProfileId(empId);
			profileDao.addResume(uploadFile);

			System.out.println("Uploaded");
		}

		List<JobDetails> jobs = jobDao.getJobDetails();
		theModel.addAttribute("jobs", jobs);
		JobSeeker js = (JobSeeker) session.getAttribute("user");
        session.setAttribute("jobseeker", js);
		return "jobseeker-home";
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @param id
	 * @return
	 * @throws IOException
	 * 
	 *             Through this, Admin can view/download the applicant's profile,who
	 *             has applied to particular Job
	 */

	@RequestMapping(value = "/profile", method = RequestMethod.GET)

	public HttpEntity<?> downloadPdf(HttpServletRequest req, HttpServletResponse resp, @RequestParam("empId") int id)
			throws IOException {

		// JobSeeker js=jobseekerDao.getJobSeeker(id);

		// System.out.println("In Profile - "+js);
		Profile p = profileDao.getProfile(id);

		System.out.println(p);
		try{
		byte[] file = p.getProfile();

		// System.out.println(p.getProfile().length);
		/*try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\Admin\\Desktop\\HTML L1\\test.pdf");
			fos.write(file);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_PDF);

		// header.setContentLength(file.length);

		return new HttpEntity<byte[]>(file, header);
		
		}catch(Exception e) {
			
			return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping("/applicantProfile")
	public String applicantProfile(@RequestParam("empId") int id, Model theModel) {

		JobSeeker jobseeker = jobseekerDao.getJobSeeker(id);

		theModel.addAttribute("jobseeker", jobseeker);
		return "view-jobseeker";
	}

	/**
	 * 
	 * @param theId
	 * @param theModel
	 * @param session
	 * @return Handles JobSeeker Profile Updation
	 */
	@RequestMapping("/updateProfile")
	public String update(@RequestParam("empId") int theId, Model theModel, HttpSession session) {

		JobSeeker jobseeker = null;
		if (session.getAttribute("user") != null) {
			// get the customer from the DB
			if (theId != 0) {
				jobseeker = jobseekerDao.getJobSeeker(theId);
			} else {
				int id = (int) session.getAttribute("user");
				jobseeker = jobseekerDao.getJobSeeker(id);
			}
			// set customer as a model attribute to pre populate the form
			// System.out.println(theCustomer);
			List<JobDetails> appliedJobs = jobseeker.getAppliedJobs();
			System.out.println("In Update" + appliedJobs);
			session.setAttribute("appliedJobs", appliedJobs);
			theModel.addAttribute("jobseeker", jobseeker);
			// send over to form
			return "update-profile";
		}
		theModel.addAttribute("msg", "You have been logged out,Login again,Please");

		return "jobSeeker-login";

	}

	/**
	 * 
	 * @param emp
	 * @param model
	 * @param session
	 * @return Checks if profile updated successfully or not,and returns user to
	 *         appropriate view
	 */
	@RequestMapping("/updateSuccess")
	public String updateProfile(@ModelAttribute("jobseeker") JobSeeker emp, Model model, HttpSession session) {

		String flag = null;

		flag = jobseekerDao.updateJobSeeker(emp);

		if (flag.equals("success")) {
			List<JobDetails> appliedJobs = (List<JobDetails>) session.getAttribute("appliedJobs");

			System.out.println(appliedJobs);

			Iterator<JobDetails> itr = appliedJobs.iterator();
			while (itr.hasNext()) {

				JobDetails js = itr.next();
				js.addApplicant(emp);
				jobDao.updateJobWithApplicants(js);
			}

			model.addAttribute("jobs", jobDao.getJobDetails());
		
			return "jobseeker-home";
		}

		model.addAttribute("msg", "Ops!!! Couldn't update profile,Please try again");
		// model.addAttribute("jobs", jobDao.getJobDetails());

		return "error";
	}
	
	@RequestMapping("/searchJobs")
	public String searchJob(Model model,HttpSession session ) {
		
		if(session.getAttribute("user")!=null)
			return "search-jobs";
			else
			{
			model.addAttribute("msg","Please login first!");
			return "jobSeeker-login";	
			}
		
	}
	
	@RequestMapping("/showJobBySkill")
	public String searchProfileBySkill(@RequestParam("showJobBySkill") String skill,Model model) {

		String flag="errors";
		List<JobDetails> list=null;
		list=jobDao.showJobBySkill(skill);
				
		if(list!=null)
		{
		model.addAttribute("msg","Matching jobs fetched Successfully!");
		model.addAttribute("list",list);
		flag="search-jobs";
		}
		else if(list==null)
		{
		
		model.addAttribute("msg","No job found matching your criteria");
		flag="search-jobs";
		}
		return flag;
		}
			
		// View JobByLocation
	 @RequestMapping("/showJobByLoc")
		public String searchProfileByLoc(@RequestParam("showJobByLoc") String loc,Model model) {

		String flag="errors";
		List<JobDetails> list=null;
		list=jobDao.showJobByLoc(loc);
				
		if(list!=null)
		{
		//model.addAttribute("msg","Matching jobs fetched Successfully!");
		model.addAttribute("list",list);
		flag="search-jobs";
		}
		else if(list==null)
		{
		model.addAttribute("msg","No job found matching your criteria");
		flag="search-jobs";
		}
		return flag;
		}
			
		// View JobByExp 
		@RequestMapping("/showJobByExp")
		public String searchProfileByExp(@RequestParam("showJobByExp") String exp,Model model) {

		String flag="errors";
		List<JobDetails> list=null;
		list=jobDao.showJobByExp(exp);
				
		if(list!=null)
		{
		model.addAttribute("msg","Matching jobs fetched Successfully!");
		model.addAttribute("list",list);
		flag="search-jobs";
		}
		else if(list==null)
		{
		model.addAttribute("msg","No job found matching your criteria");
		flag="search-jobs";
		}
		return flag;
	}
	

}