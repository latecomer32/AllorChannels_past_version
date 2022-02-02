package com.MyBlog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBlog.Service.HeaderService;

@Controller
public class HeaderController {

	@Autowired
	public HeaderService headerService;

	@GetMapping({ "", "/" })
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

	@GetMapping("/auth/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "exception", required = false) String exception, Model model) {
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return "root.loginForm";
	}

}
