package com.MyBlog.Repository;

import java.util.List;

import com.MyBlog.Dto.Board;

public interface BoardRepository {



	void saveTheWriting(Board board);



	List<Board> getWritingList(int offset, int size, String title, String query, boolean pub);
}
