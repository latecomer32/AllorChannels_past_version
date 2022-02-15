package com.MyBlog.Service;

import java.util.List;
import java.util.Map;

import com.MyBlog.Dto.Board;


public interface BoardService {



	void saveTheWriting(Board board, String username);

	List<Board> getWritingList(int page, String field, String query, boolean pub, int size, String order, String desc, String categoryName, String nickName, boolean loginCheck, String uri);

	void deleteWritingList(int no);

	int getWritingCount(String field, String query);

	Board getWritingDetail(int no);

}
