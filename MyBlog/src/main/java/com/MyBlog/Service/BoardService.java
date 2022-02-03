package com.MyBlog.Service;

import org.springframework.stereotype.Service;

import com.MyBlog.Dto.Board;


public interface BoardService {



	void saveTheWriting(Board board, String username);

}
