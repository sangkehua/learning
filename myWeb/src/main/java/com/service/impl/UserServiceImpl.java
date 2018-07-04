package com.service.impl;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class UserServiceImpl implements UserService {

	private UserMapper userMapper;

	@Transactional(propagation = Propagation.REQUIRED)
	public User login(String username, String password) {
		return userMapper.login(username,password);

	}


	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
