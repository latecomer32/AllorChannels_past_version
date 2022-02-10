package com.MyBlog.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserCategoryView;
import com.MyBlog.Repository.LeftRepository;

@Service
public class LeftServiceImp implements LeftService{

	@Autowired
	LeftRepository leftRepository;

	@Override
	public List<Category> getCategoryList(UserCategoryView getNickName) {
		return leftRepository.getCategoryList(getNickName);
	}

	@Override
	public void saveCategoryName(UserCategoryView getNickName, UserCategoryView categoryName) {
		leftRepository.saveCategoryName(getNickName, categoryName);
	}

	@Override
	public UserCategoryView getNickName(String username) {
		return leftRepository.getNickName(username);
	}

	

	
		 
		
	

	

}
