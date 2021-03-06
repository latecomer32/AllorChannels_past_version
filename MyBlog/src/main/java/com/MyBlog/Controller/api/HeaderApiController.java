package com.MyBlog.Controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyBlog.Dto.ResponseDto;
import com.MyBlog.Dto.UserDto;
import com.MyBlog.Service.HeaderService;

@RestController
public class HeaderApiController {

	@Autowired
	private HeaderService headerService;

	@PostMapping("/auth/joinForm")
	public ResponseDto<Integer> join(@RequestBody UserDto user) {
		headerService.join(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}
