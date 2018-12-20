package com.bidsystem.service;

import com.bidsystem.bean.User;

public interface IUserService {

	// 登陆
	public User login(String userName,String userpwd);
}
