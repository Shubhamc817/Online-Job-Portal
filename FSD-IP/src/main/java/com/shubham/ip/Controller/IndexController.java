package com.shubham.ip.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sh953432
 * 
 * Index Controller - Handler Application start up
 *
 */

@Controller
public class IndexController {

	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
