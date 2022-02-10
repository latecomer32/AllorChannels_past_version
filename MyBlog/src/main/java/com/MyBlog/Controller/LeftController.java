package com.MyBlog.Controller;



import java.util.List;

import javax.xml.catalog.Catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBlog.Config.auth.PrincipalDetail;
import com.MyBlog.Dto.Board;
import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserDto;
import com.MyBlog.Service.HeaderService;
import com.MyBlog.Service.LeftService;

@Controller
public class LeftController {

	@Autowired
	public LeftService leftService;

	@RequestMapping("/category")
	public String index(
			Model model, Category category) {
		
		List<Category> getCategoryList = leftService.getCategoryList(category.getNickName());
		
		model.addAttribute("getCategoryList", getCategoryList);
		return "rediret:/";
	}

	
}
