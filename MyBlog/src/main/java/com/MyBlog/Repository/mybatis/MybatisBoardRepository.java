package com.MyBlog.Repository.mybatis;

import java.util.List;

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
		System.out.println("MybatisBoardRepository implements BoardRepository");
		mapper.saveTheWriting(board);
		
	}


	@Override
	public List<Board> getWritingList(int offset, int size, String title, String query, boolean pub) {
		// TODO Auto-generated method stub
		return mapper.getWritingList(offset, size, title, query, pub);
	}
	
	
	


	
}
