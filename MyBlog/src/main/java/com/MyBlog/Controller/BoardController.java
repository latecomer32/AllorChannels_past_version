package com.MyBlog.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/board/saveForm")
	public String saveTheWriting() {
		return "root.mid_saveTheWritingForm";
	}
}
