package com.MyBlog.Dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {

	private int no;
	
	private String title;
	
	private String content;
	
	private String nickName;
	
	private Timestamp date;
	
	private int viewCount;
	
	private int replyCount;
	
	private String category;
	
	private boolean pub;
	

}
