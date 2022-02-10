package com.MyBlog.Service;

import java.util.List;

import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserDto;

public interface LeftService {

	void saveCategoryName(String getNickName, String categoryName);

	List<Category> getCategoryList(String username);

	String getNickName(String username);

}
