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
	public List<Category> getCategoryList(String nickName) {
		return leftRepository.getCategoryList(nickName);
	}

	@Override
	public void saveCategoryName(String nickName, String categoryName) {
		leftRepository.saveCategoryName(nickName, categoryName);
	}


	

	
		 
		
	

	

}
