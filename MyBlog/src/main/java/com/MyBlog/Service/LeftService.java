package com.MyBlog.Service;

import java.util.List;

import com.MyBlog.Dto.Category;
import com.MyBlog.Dto.ChannelCategory;
import com.MyBlog.Dto.UserCategoryView;
import com.MyBlog.Dto.UserDto;

public interface LeftService {

	void saveCategoryName(String nickName, String string);
	
	void deleteCategoryName(String[] deleteCategory);
	
	List<Category> getCategoryList(String nickName);


	void saveChannelCategoryName(String categoryName, String title);

	void deleteChannelCategoryName(String[] deleteChannelCategoryNoArray);

	List<ChannelCategory> getChannelCategoryList(String channelName);

	void deleteChannelName(String deleteChannelName);

}
