package com.MyBlog.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.MyBlog.Dto.Board;
import com.MyBlog.Dto.RoleType;
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
		String rawPassword =user.getPassword(); //비번 원문
		String encPassword = encoder.encode(rawPassword); //비번 암호화(해쉬화)
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		headerRepository.insert(user);
	}

	@Override
	public List<UserDto> getMemberList(Integer page, String field, String query, boolean pub, Integer rowNum,
			String order, String desc) {

		int offset = 0+(page-1)*rowNum;
		 List<UserDto> getMemberList =headerRepository.getMemberList(offset, field, query, pub, rowNum, order, desc);
		 return getMemberList;
	}

	@Override
	public int getMemberCount(String field, String query) {
		return headerRepository.getMemberCount(field, query);
	}


}
