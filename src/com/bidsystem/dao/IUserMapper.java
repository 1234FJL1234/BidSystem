package com.bidsystem.dao;

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
	
}
