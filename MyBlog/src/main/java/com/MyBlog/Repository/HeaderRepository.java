package com.MyBlog.Repository;

import java.util.List;
import java.util.Optional;

import com.MyBlog.Dto.UserDto;

public interface HeaderRepository {

	void insert(UserDto user);
	
	//Select * From user WHERE username = 1?;
	

	Optional<UserDto> findByUserId(String userId);

	List<UserDto> getMemberList(int offset, String field, String query, boolean pub, Integer rowNum, String order,
			String desc);

	int getMemberCount(String field, String query);

}
