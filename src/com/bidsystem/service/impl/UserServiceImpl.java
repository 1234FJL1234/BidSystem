package com.bidsystem.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidsystem.bean.User;
import com.bidsystem.dao.IUserMapper;
import com.bidsystem.service.IUserService;
import com.bidsystem.util.Val;


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

	@Override
	public List<User> findByAddress(User user,HttpSession session) {
		User user2 = (User)session.getAttribute(Val.SESSION_KEY_USER);
		System.out.println("==============="+user2.getUserName());
		if(user2.getUserName().equals("admin")) {
			user.setAddress("");
			user.setId(user2.getId());
		}else {
			user.setAddress(user2.getAddress());
			user.setId(user2.getId());
		}
		return userMapper.findByAddress(user);
	}

		// 更新用户信息
	@Override
	public int update(int id, String userName, String userpwd, String workUnit, String address) {
		return userMapper.update(id, userName, userpwd, workUnit, address);
	}

	// 根据id查询用户信息
	@Override
	public User findById(int id) {
		return userMapper.findById(id);
	}



}
