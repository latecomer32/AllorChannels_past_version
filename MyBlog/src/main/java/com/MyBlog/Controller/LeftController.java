package com.MyBlog.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserCategoryView;
import com.MyBlog.Service.LeftService;

@Controller
public class LeftController {

	@Autowired
	public LeftService leftService;

	@RequestMapping("/category")
	public String index(
			Model model, UserCategoryView userCategoryView) {
		
			return "redirect:/";
	}

	
}
