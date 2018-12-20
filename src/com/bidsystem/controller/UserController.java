package com.bidsystem.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bidsystem.bean.User;
import com.bidsystem.service.IUserService;
import com.bidsystem.util.Val;


@Controller
public class UserController {
	
	@Autowired
	private IUserService IUserService;
	
	// 映射到登陆
	@RequestMapping("login")
	public String login() {
		return "login";
	}
	
	
	/**
	 * 处理登录请求
	 * @param userName
	 * @param userpwd
	 * @param model
	 * @return
	 */
	@RequestMapping("dologin")
	public String login(String userName,String userpwd,HttpSession session) {
		User user = IUserService.login(userName, userpwd);
		if(user!=null) {
			session.setAttribute(Val.SESSION_KEY_USER,user);
			return "index";
		}else {
			return "login";
		}
	}
	
}
