package com.bidsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidsystem.bean.User;
import com.bidsystem.dao.IUserMapper;
import com.bidsystem.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserMapper userMapper;

	// 用户登陆
	@Override
	public User login(String userName, String userpwd) {
		return userMapper.login(userName, userpwd);
	}

	@Override
	public boolean updatePwd(int id, String userpwd) {
		boolean flag = false;
		if (userMapper.updatePwd(id, userpwd) > 0) {
			flag = true;
		}
		return flag;
	}

}
