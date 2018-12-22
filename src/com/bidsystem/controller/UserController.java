package com.bidsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bidsystem.bean.User;
import com.bidsystem.service.IUserService;
import com.bidsystem.util.Val;
import com.mysql.jdbc.StringUtils;


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
		System.out.println(user);
		if(user!=null) {
			session.setAttribute(Val.SESSION_KEY_USER,user);
			return "index";
		}else {
			return "login";
		}
	}
	
	//映射修改密码
	@RequestMapping("updatepwd")
	public String updatepwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "pwdmodify";
	}
	
	
	//处理用户登陆之后可自行修改密码
	@RequestMapping("pwdmodify")
	public String updatePwd(HttpServletRequest request, HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		User o= (User)request.getSession().getAttribute(Val.SESSION_KEY_USER);
		String newpassword = request.getParameter("newpassword");
		boolean flag = false;
		if(o != null && !StringUtils.isNullOrEmpty(newpassword)){
			flag = IUserService.updatePwd(o.getId(),newpassword);
			if(flag){
				request.setAttribute(Val.SYS_MESSAGE, "修改密码成功,请退出并使用新密码重新登录！");
				request.getSession().removeAttribute(Val.SESSION_KEY_USER);//session注销
			}else{
				request.setAttribute(Val.SYS_MESSAGE, "修改密码失败！");
			}
		}else{
			request.setAttribute(Val.SYS_MESSAGE, "修改密码失败！");
		}
		
		return "pwdmodify";
	}
	
}
