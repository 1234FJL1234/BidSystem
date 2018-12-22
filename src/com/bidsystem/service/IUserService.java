package com.bidsystem.service;

import com.bidsystem.bean.User;

public interface IUserService {

	// 登陆
	public User login(String userName,String userpwd);
	
	//用户登陆之后可自行修改密码
	public boolean updatePwd(int id,String userpwd);
}
