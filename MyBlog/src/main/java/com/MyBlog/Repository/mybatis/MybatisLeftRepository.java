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
	public List<Category> getCategoryList(String nickName) {
		System.out.println("categoryName mapper:" + nickName);
		return mapper.getCategoryList(nickName);
	}

	@Override
	public void saveCategoryName(String nickName, String categoryName) {

		mapper.saveCategoryName(nickName, categoryName);
	}


}
