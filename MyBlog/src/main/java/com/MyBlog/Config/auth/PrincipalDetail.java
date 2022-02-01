package com.MyBlog.Config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.MyBlog.Dto.UserDto;

public class PrincipalDetail implements UserDetails {

	private UserDto user;

	public PrincipalDetail(UserDto user) {
		this.user = user;
		System.out.println("PrincipalDetail(UserDto user):"+user);
		System.out.println("getUsername():"+user.getUserId());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUserId();
	}


	// 계정이 만료되지 않았는지 리턴한다. (true:만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정이 잠겨있지 않았는지 리턴한다. (true:잠기지 않음)
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	// 비밀번호가 만료되지 않았는지 리턴한다.(true:만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정이 활성화(사용가능)인지 리턴한다.(true:활성화)
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	// 계정이 갖고있는 권한 목록을 리턴한다. (권한이 여러개 있을 수 있어서 루프를 돌아야 하는데 우리는 한개만)
	// 권한이 여러개면 for문을 돌려야 함.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(() -> {
			return "ROLE_" + user.getRole();
		});

		return collectors;
	}

	
}
