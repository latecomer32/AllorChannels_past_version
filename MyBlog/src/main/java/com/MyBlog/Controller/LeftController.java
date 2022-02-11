package com.MyBlog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBlog.Config.auth.PrincipalDetail;
import com.MyBlog.Dto.Board;
import com.MyBlog.Dto.Category;
import com.MyBlog.Service.BoardService;
import com.MyBlog.Service.LeftService;

@Controller
public class LeftController {

	@Autowired
	BoardService boardService;

	@Autowired
	public LeftService leftService;

	@GetMapping("/category")
	public String saveCategoryName(@RequestParam(value = "categoryName", required = false) String categoryName,
			@RequestParam(name = "p", required = false, defaultValue = "1") Integer page,
			@RequestParam(name = "f", required = false, defaultValue = "title") String field,
			@RequestParam(name = "q", required = false, defaultValue = "") String query,
			@RequestParam(name = "r", required = false, defaultValue = "15") Integer rowNum,
			@RequestParam(name = "desc", required = false, defaultValue = "DESC") String desc,
			@RequestParam(name = "order", required = false, defaultValue = "date") String order,
			@AuthenticationPrincipal PrincipalDetail principal, Model model, Board board) {

		if (principal == null) {
			return "redirect:/";
		} else {
			List<Category> getCategoryList = leftService.getCategoryList(principal.getNickName());
			model.addAttribute("getCategoryList", getCategoryList);
		}

		boolean pub = true;
		List<Board> getWritingList = boardService.getWritingList(page, field, query, pub, rowNum, order, desc);
		int getWritingCount = boardService.getWritingCount(field, query);
		model.addAttribute("getWritingList", getWritingList);
		model.addAttribute("getWritingCount", getWritingCount);
		return "root.mid_contentList";

	}
}
