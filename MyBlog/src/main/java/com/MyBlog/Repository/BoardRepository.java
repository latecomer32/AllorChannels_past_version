package com.MyBlog.Repository;

import java.util.List;
import java.util.Map;

import com.MyBlog.Dto.Board;

public interface BoardRepository {

	void saveTheWriting(Board board);

	List<Board> getWritingList(int offset, String field, String query, boolean pub, Integer rowNum, String order, String desc);

	int getWritingCount(String field, String query);

	int deleteWritingList(int no);

	Board getWritingDetail(int no);
}
