package com.bidsystem.dao;

import org.apache.ibatis.annotations.Param;

import com.bidsystem.bean.User;

/**
 * 用户接口
 */
public interface IUserMapper {

	// 用户登陆
	public User login(@Param("userName") String userName,@Param("userpwd") String userpwd);
	
}
