package com.MyBlog.Controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyBlog.Config.auth.PrincipalDetail;
import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.ResponseDto;
import com.MyBlog.Dto.UserDto;
import com.MyBlog.Service.LeftService;

@RestController
public class LeftApiController {

	@Autowired
	LeftService leftService;

	@PostMapping("/category/saveCategoryName" )
	public ResponseDto<Integer> saveCategoryName(@RequestBody String categoryName,
			@AuthenticationPrincipal PrincipalDetail principal) {
		
	
		String getNickName=leftService.getNickName(principal.getUsername());
		
		
		 leftService.saveCategoryName(getNickName, categoryName);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	
}
