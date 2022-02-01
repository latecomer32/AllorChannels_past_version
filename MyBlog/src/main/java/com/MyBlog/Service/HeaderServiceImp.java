package com.MyBlog.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MyBlog.Dto.UserDto;
import com.MyBlog.Repository.HeaderRepository;

@Service
public class HeaderServiceImp implements HeaderService{

	@Autowired
	public HeaderRepository headerRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void join(UserDto user) {
		String rawPassword =user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(1);
		
		headerRepository.insert(user);
	}

}
