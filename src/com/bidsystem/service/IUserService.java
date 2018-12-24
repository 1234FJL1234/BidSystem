package com.bidsystem.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;

import com.bidsystem.bean.User;

public interface IUserService {

	// 登陆
	public User login(String userName, String userpwd);

	// 用户登陆之后可自行修改密码
	public boolean updatePwd(int id, String userpwd);

	// 按照区域查询用户
	public List<User> findByAddress(User user, HttpSession session);

	// 修改用户信息
	public int update(int id, String userName, String userpwd, String workUnit, String address);

	// 根据ID查询用户信息
	public User findById(int id);

	// 导出选中
	public List<User> getById(String[] ids);

	// 导出所有
	public List<User> getAll();
}
