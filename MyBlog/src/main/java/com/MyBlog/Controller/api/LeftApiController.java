package com.MyBlog.Controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyBlog.Config.auth.PrincipalDetail;
import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.ResponseDto;
import com.MyBlog.Dto.UserCategoryView;
import com.MyBlog.Service.LeftService;

@RestController
public class LeftApiController {

	@Autowired
	LeftService leftService;

	@PostMapping("/category/saveCategoryName")
	public ResponseDto<Integer> saveCategoryName(@RequestBody UserCategoryView categoryName,
			@AuthenticationPrincipal PrincipalDetail principal, Model model) {

		UserCategoryView getNickName = leftService.getNickName(principal.getUsername());
		leftService.saveCategoryName(getNickName, categoryName);

		List<Category> getCategoryList = leftService.getCategoryList(getNickName);
		System.out.println("getNickName:" + getNickName);
		System.out.println("LeftController getCategoryList:" + getCategoryList);
		
		model.addAttribute("getCategoryList", getCategoryList);

		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}
