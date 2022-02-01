package com.MyBlog.Repository.mybatis;

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
	public Optional<UserDto> findByUsername(String userId) {
		//SELECT * FROM user WHERE username = 1?;
		System.out.println("findByUsername"+userId);
		System.out.println("mapper.findByUsername(userId)"+mapper.findByUsername(userId));
		return mapper.findByUsername(userId);
	}
}
