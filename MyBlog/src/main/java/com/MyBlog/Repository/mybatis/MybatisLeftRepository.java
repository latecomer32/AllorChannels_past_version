package com.MyBlog.Repository.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserCategoryView;
import com.MyBlog.Repository.LeftRepository;

@Repository
public class MybatisLeftRepository implements LeftRepository {

	private LeftRepository mapper;

	@Autowired
	public MybatisLeftRepository(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(LeftRepository.class);
	}

	@Override
	public List<Category> getCategoryList(UserCategoryView getNickName) {
		System.out.println("categoryName mapper:" + getNickName.getNickName());
		return mapper.getCategoryList(getNickName);
	}

	@Override
	public void saveCategoryName(UserCategoryView getNickName, UserCategoryView categoryName) {

		mapper.saveCategoryName(getNickName, categoryName);
	}

	@Override
	public UserCategoryView getNickName(String username) {

		return mapper.getNickName(username);
	}

}
