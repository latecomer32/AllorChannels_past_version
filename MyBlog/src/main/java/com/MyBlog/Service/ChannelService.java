package com.MyBlog.Service;

import java.util.List;

import com.MyBlog.Dto.Channel;

public interface ChannelService {

	List<Channel> getChannelList(int page, int size, String query);

	int getChannelCount(String field, String query);


}
