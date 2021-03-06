package com.MyBlog.Repository.mybatis;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MyBlog.Dto.UserDto;
import com.MyBlog.Repository.HeaderRepository;


@Repository
public class MybatisHeaderRepository implements HeaderRepository {

	private HeaderRepository mapper;
	
	
	@Autowired
	public MybatisHeaderRepository(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(HeaderRepository.class);
	}
	
	@Override
	public void insert(UserDto user) {
		mapper.insert(user);
	}

	
	@Override
	public Optional<UserDto> findByUserId(String userId) {
		//SELECT * FROM user WHERE username = 1?;
			return mapper.findByUserId(userId);
	}

	@Override
	public List<UserDto> getMemberList(int offset, String field, String query, boolean pub, Integer rowNum,
			String order, String desc) {
		return mapper.getMemberList(offset, field, query, pub, rowNum, order, desc);
	}

	@Override
	public int getMemberCount(String field, String query) {
		return mapper.getMemberCount(field, query);
	}
}
