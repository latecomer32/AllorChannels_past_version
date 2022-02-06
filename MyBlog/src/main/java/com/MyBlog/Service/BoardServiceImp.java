package com.MyBlog.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
	public List<Board> getWritingList(int page, String field, String query, boolean pub, Integer rowNum, String order, String desc) {
		
		int offset = 0+(page-1)*rowNum;
		 List<Board> WritingList =boardRepository.getWritingList(offset, field, query, pub, rowNum, order, desc);
		 return WritingList;
	}

	@Override
	public void deleteWritingList(Map<String, Object> numbers) {
		boardRepository.deleteWritingList(numbers);
		
	} 
	
	
	@Override
	public int getWritingCount(String field, String query) {
		return boardRepository.getWritingCount(field, query);
	}


	@Override
	public Board getWritingDetail(int no) {
		return boardRepository.getWritingDetail(no);
		
	}
	
	

	

}
