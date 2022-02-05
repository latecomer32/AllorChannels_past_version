package com.MyBlog.Controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MyBlog.Config.auth.PrincipalDetail;
import com.MyBlog.Dto.Board;
import com.MyBlog.Dto.ResponseDto;
import com.MyBlog.Service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	BoardService boardService;
	
	@PostMapping("/board/saveTheWritingForm")
	public ResponseDto<Integer> saveTheWriting(@RequestBody Board board,@AuthenticationPrincipal PrincipalDetail principal) {
		
		System.out.println("@PostMapping(\"/board/saveTheWritingForm\")");
		
		boardService.saveTheWriting(board, principal.getUsername());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
	

}
