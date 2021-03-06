package com.MyBlog.Repository.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserDto;
import com.MyBlog.Repository.LeftRepository;

@Repository
public class MybatisLeftRepository implements LeftRepository {

	private LeftRepository mapper;

	@Autowired
	public MybatisLeftRepository(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(LeftRepository.class);
	}

	@Override
	public List<Category> getCategoryList(String categoryName) {
		return mapper.getCategoryList(categoryName);
	}

	@Override
	public void saveCategoryName(String nickName, String categoryName) {
		System.out.println("getNickName"+nickName);
		System.out.println("categoryName"+categoryName);
		mapper.saveCategoryName(nickName, categoryName);		
	}

	@Override
	public String getNickName(String username) {
		System.out.println("username:"+username);
		return mapper.getNickName(username);
	}


}
