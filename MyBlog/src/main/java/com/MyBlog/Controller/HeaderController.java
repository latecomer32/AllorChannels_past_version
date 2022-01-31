package com.MyBlog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.MyBlog.Dto.ResponseDto;
import com.MyBlog.Dto.UserDto;
import com.MyBlog.Service.HeaderService;

@Controller
public class HeaderController {

	@Autowired
	public HeaderService headerService;

	@GetMapping({"","/"})
	public String index() {
		return "root.mid_contentList";
	}

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "root.mid_joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm() {
		return "root.mid_loginForm";
	}

	

	

}
