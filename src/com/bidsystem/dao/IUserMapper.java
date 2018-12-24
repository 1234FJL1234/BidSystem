package com.bidsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bidsystem.bean.User;

/**
 * 用户接口
 */
public interface IUserMapper {

	// 用户登陆
	public User login(@Param("userName") String userName,@Param("userpwd") String userpwd);
	
	//用户登陆之后可自行修改密码
	public int updatePwd(@Param("id") int id,@Param("userpwd")  String userpwd);
	
	// 按照区域查询用户
	public List<User> findByAddress( User user);
	
	// 修改用户信息
	public int update(@Param("id")int id,@Param("userName")String userName,@Param("userpwd")String userpwd,@Param("workUnit")String workUnit,@Param("address")String address);
	
	// 根据ID查询用户信息
	public User findById(@Param("id") int id);
}
