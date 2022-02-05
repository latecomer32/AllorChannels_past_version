package com.MyBlog.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MyBlog.Dto.Board;


public interface BoardService {



	void saveTheWriting(Board board, String username);

	List<Board> getWritingList(int page, String field, String query, boolean pub, Integer rowNum, String order, String desc);

	void deleteWritingList(int no);
}
