package com.MyBlog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBlog.Dto.Board;
import com.MyBlog.Dto.UserDto;
import com.MyBlog.Service.HeaderService;

@Controller
public class HeaderController {

	@Autowired
	public HeaderService headerService;

	

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "root.mid_joinForm";
	}



	//나중에 url주소 수정해서 로그인 실패시 화면제작해서 거기로 실패문구와 함께 보내주자.
	@GetMapping("/auth/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "exception", required = false) String exception, Model model) {
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		return "root.loginForm";
	}

	@RequestMapping("/header/member")
	public String index(
			@RequestParam(name="p", required=false, defaultValue = "1") Integer page,
			@RequestParam(name="f", required=false, defaultValue = "userId")String field,
			@RequestParam(name="q", required=false, defaultValue = "")String query,
			@RequestParam(name="r", required=false, defaultValue = "15") Integer rowNum,
			@RequestParam(name="desc", required=false, defaultValue = "ASC")String desc,
			@RequestParam(name="order", required=false, defaultValue = "date")String order,
			Model model,UserDto user) {
		

		boolean pub =true;

		List<UserDto> getMemberList = headerService.getMemberList(page, field, query, pub,rowNum,order,desc);
		int getMemberCount = headerService.getMemberCount(field, query);
		model.addAttribute("getMemberList", getMemberList);
		model.addAttribute("getMemberCount", getMemberCount);
		return "root.mid_memberList";
	}
}
