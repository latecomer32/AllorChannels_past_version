package com.MyBlog.Repository.mybatis;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MyBlog.Dto.Board;
import com.MyBlog.Repository.BoardRepository;

@Repository
public class MybatisBoardRepository implements BoardRepository {

	private BoardRepository mapper;
	
	@Autowired
	public MybatisBoardRepository(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(BoardRepository.class);
	}


	@Override
	public void saveTheWriting(Board board) {
	
		mapper.saveTheWriting(board);
		
	}


	@Override
	public List<Board> getWritingList(int offset, String field, String query, boolean pub, Integer rowNum, String order, String desc) {
	System.out.println("getWritingList// offset:"+offset+"// field:"+ field+"// query:"+ query+"// pub:"+ pub+"// rowNum:"+ rowNum+"// order:"+ order+"// desc:"+ desc);
		return mapper.getWritingList(offset, field, query, pub, rowNum, order, desc);
	}
	
	public void deleteWritingList(int no) {
		mapper.deleteWritingList(no);
	}
	


	
}
