package com.MyBlog.Service;

import java.util.List;

import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserDto;

public interface LeftService {

	void saveCategoryName(UserDto getNickName, Category categoryName);

	List<Category> getCategoryList(String username);

	UserDto getNickName(String username);

}
