package com.MyBlog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;

import com.MyBlog.Config.auth.PrincipalDetail;
import com.MyBlog.Dto.Board;
import com.MyBlog.Repository.BoardRepository;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardRepository boardRepository;
	
	
	@Override
	public void saveTheWriting(Board board, String username) {
		board.setNickName(username);
		boardRepository.saveTheWriting(board);
		
	}

	

}
