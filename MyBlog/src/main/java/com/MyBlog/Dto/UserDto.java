package com.MyBlog.Dto;

import java.sql.Timestamp;


import org.springframework.stereotype.Repository;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

	private int id;
	
	private String userId;
	
	private String userName;
	
	private String password;
	
	private int role;
	
	private String oauth; //kakao. google
	
	private Timestamp createDate;
}
