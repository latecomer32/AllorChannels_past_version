package com.MyBlog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.MyBlog.Service.HomeService;


@Controller
public class HomeController {

	@Autowired
	public HomeService homeService;
	
	@GetMapping("/index")
	public String index() {
		return "/index";
	}
	
	
}
