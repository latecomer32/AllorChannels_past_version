package com.MyBlog.Repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.MyBlog.Dto.Board;
import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.UserCategoryView;
import com.MyBlog.Dto.UserDto;

public interface LeftRepository {

	List<Category> getCategoryList(String nickName);

	void saveCategoryName(String nickName,String categoryName);

	void deleteCategoryName(String[] deleteCategory);

}
