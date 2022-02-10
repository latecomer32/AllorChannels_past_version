package com.MyBlog.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserDto;
import com.MyBlog.Repository.LeftRepository;

@Service
public class LeftServiceImp implements LeftService{

	@Autowired
	LeftRepository leftRepository;

	@Override
	public List<Category> getCategoryList(String username) {
		return leftRepository.getCategoryList(username);
	}

	@Override
	public void saveCategoryName(String getNickName, String categoryName) {
		leftRepository.saveCategoryName(getNickName, categoryName);
	}

	@Override
	public String getNickName(String username) {
		return leftRepository.getNickName(username);
	}

	

	
		 
		
	

	

}
