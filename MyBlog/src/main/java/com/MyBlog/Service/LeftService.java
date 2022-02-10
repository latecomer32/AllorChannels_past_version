package com.MyBlog.Service;

import java.util.List;

import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserCategoryView;
import com.MyBlog.Dto.UserDto;

public interface LeftService {

	void saveCategoryName(UserCategoryView getNickName, UserCategoryView categoryName);

	List<Category> getCategoryList(UserCategoryView getNickName);

	UserCategoryView getNickName(String string);

}
