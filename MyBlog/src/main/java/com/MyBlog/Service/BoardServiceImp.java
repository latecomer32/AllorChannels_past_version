package com.MyBlog.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBlog.Dto.Board;
import com.MyBlog.Repository.BoardRepository;

@Service
public class BoardServiceImp implements BoardService{

	@Autowired
	BoardRepository boardRepository;
	
	
	@Override
	public void saveTheWriting(Board board, String username) {
		System.out.println("@Service\r\n"
				+ "public class BoardServiceImp implements BoardService{\r\n"
				+ "");
		board.setNickName(username);
		boardRepository.saveTheWriting(board);
		
	}

	
	@Override
	public List<Board> getWritingList(int page, String title, String query, boolean pub) {
		int size = 10;
		int offset = 0+(page-1)*size;
		 List<Board> WritingList =boardRepository.getWritingList(offset, size, title, query, pub);
		 return WritingList;
	} 

	

}
