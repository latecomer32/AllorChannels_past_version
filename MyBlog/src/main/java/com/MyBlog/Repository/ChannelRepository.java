package com.MyBlog.Repository;

import java.util.List;

import com.MyBlog.Dto.Channel;

public interface ChannelRepository {

	List<Channel> getChannelList(int offset, int size, String query);

	int getChannelCount(String field, String query);

}