package com.mapper;

import com.entity.User;

/**
 * Created by huashuai on 2016/12/17.
 */

public interface UserMapper {
	public User login(String username, String password);

	public User query();
}
