package com.MyBlog.Repository;

import java.util.List;

import com.MyBlog.Dto.Board;

public interface BoardRepository {



	void saveTheWriting(Board board);

	

	List<Board> getWritingList(int offset, String field, String query, boolean pub, Integer rowNum, String order, String desc);



	void deleteWritingList(int no);
}
