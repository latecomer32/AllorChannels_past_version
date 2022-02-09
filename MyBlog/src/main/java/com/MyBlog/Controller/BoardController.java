package com.MyBlog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MyBlog.Dto.Board;
import com.MyBlog.Service.BoardService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/board/saveTheWritingForm")
	public String saveTheWriting() {
		return "root.mid_saveTheWritingForm";
	}
	
	@RequestMapping({ "", "/" })
	public String index(
			@RequestParam(name="p", required=false, defaultValue = "1") Integer page,
			@RequestParam(name="f", required=false, defaultValue = "title")String field,
			@RequestParam(name="q", required=false, defaultValue = "")String query,
			@RequestParam(name="r", required=false, defaultValue = "15") Integer rowNum,
			@RequestParam(name="desc", required=false, defaultValue = "DESC")String desc,
			@RequestParam(name="order", required=false, defaultValue = "date")String order,
			Model model,Board board) {
		model.addAttribute("categoryValue",board.getCategory());

		boolean pub =true;

		List<Board> getWritingList = boardService.getWritingList(page, field, query, pub,rowNum,order,desc);
		int getWritingCount = boardService.getWritingCount(field, query);
		model.addAttribute("getWritingList", getWritingList);
		model.addAttribute("getWritingCount", getWritingCount);
		return "root.mid_contentList";
	}
	
	@GetMapping("/board/detail/{no}")
	public String findByNo(@PathVariable int no, Model model) {
		System.out.println("no"+boardService.getWritingDetail(no).getNo());
		model.addAttribute("board",boardService.getWritingDetail(no));
		return "root.mid_detail";
		
	}

}
