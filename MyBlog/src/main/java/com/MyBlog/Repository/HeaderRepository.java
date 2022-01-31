package com.MyBlog.Repository;

import java.util.Optional;

import com.MyBlog.Dto.UserDto;

public interface HeaderRepository {

	void insert(UserDto user);
	
	//Select * From user WHERE username = 1?;
	

	Optional<UserDto> findByUsername(String userId);

}
