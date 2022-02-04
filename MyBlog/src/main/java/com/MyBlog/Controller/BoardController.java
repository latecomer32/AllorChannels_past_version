package com.MyBlog.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
	@GetMapping({ "", "/" })
	public String index(Model model,Board board) {
		model.addAttribute("categoryValue",board.getCategory());
		int page = 1;
		String title = "title";
		String query = "";
		boolean pub =true;
		List<Board> getWritingList = boardService.getWritingList(page, title, query, pub);
		model.addAttribute("getWritingList", getWritingList);
		
		return "root.mid_contentList";
	}

}
