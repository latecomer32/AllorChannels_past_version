package com.MyBlog.Config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.MyBlog.Dto.UserDto;
import com.MyBlog.Repository.HeaderRepository;

@Service
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private HeaderRepository headerRepository;
	
	//스프링이 로그인 요청을 가로챌 때, username, password 변수 2개를 가로채는데
	//password 부분 처리는 알아서 함.
	//username이 DB에 있는지 확인해주면 됨.
	@Override
	public UserDetails loadUserByUsername(String userId)throws UsernameNotFoundException{
		System.out.println("loadUserByUsername"+userId);
		UserDto principal = headerRepository.findByUsername(userId)
				.orElseThrow(()->{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다.:"+userId);
				});
		return new PrincipalDetail(principal); //시큐리티의 세션에 유저 정보가 저장이 됨.
	}
}
