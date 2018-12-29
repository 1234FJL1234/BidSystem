package com.bidsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bidsystem.bean.User;
import com.bidsystem.service.IUserService;
import com.bidsystem.util.Val;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private IUserService us;

	// 映射到登陆
	@RequestMapping("login")
	public String login() {
		return "login";
	}

	/**
	 * 处理登录请求
	 * 
	 * @param userName
	 * @param userpwd
	 * @param model
	 * @return
	 */
	@RequestMapping("dologin")
	@ResponseBody
	public Object login(@RequestBody User user, HttpSession session) {
		System.out.println(user);
		User user2 = us.login(user);
		
		
		if (user2 != null) {
			session.setAttribute(Val.SESSION_KEY_USER, user2);
			return "{\"type\":\"2001\"}";
		} else {
			return "{\"type\":\"2002\"}";
		}
	}

	// 映射修改密码
	@RequestMapping("updatepwd")
	public String updatepwd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		return "pwdmodify";
	}

	// 处理用户登陆之后可自行修改密码
	@RequestMapping("pwdmodify")
	@ResponseBody
	public String updatePwd(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {
		User o = (User) request.getSession().getAttribute(Val.SESSION_KEY_USER);
		String newpassword = request.getParameter("newpassword");
		boolean flag = false;
		if (o != null && !StringUtils.isNullOrEmpty(newpassword)) {
			flag = us.updatePwd(o.getId(), newpassword);
			if (flag) {
				request.setAttribute(Val.SYS_MESSAGE, "修改密码成功,请退出并使用新密码重新登录！");
				request.getSession().removeAttribute(Val.SESSION_KEY_USER);// session注销
				return "{\"type\":\"2001\"}";
			} else {
				request.setAttribute(Val.SYS_MESSAGE, "修改密码失败！");
				return "{\"type\":\"2002\"}";
			}
		} else {
			request.setAttribute(Val.SYS_MESSAGE, "修改密码失败！");
			return "{\"type\":\"2002\"}";
		}
	}

	@RequestMapping("finduser")
	@ResponseBody
	public Object findByUser(User user, Model model, HttpSession session) {
		model.addAttribute("listUser", us.findByAddress(user, session));
		return us.findByAddress(user, session);
	}

	// 映射到修改页面
	@RequestMapping("update")
	@ResponseBody
	public Object update(Model model, @RequestBody int id) {
		model.addAttribute("user", us.findById(id));
		return us.findById(id);
	}

	// 处理修改请求
	@RequestMapping("doupdate")
	@ResponseBody
	public String doupdate(@RequestBody int id,@RequestBody String userName,@RequestBody String userpwd,@RequestBody String workUnit, String address) {
		int result = us.update(id, userName, userpwd, workUnit, address);
		if (result >= 1) {
			return "{\"type\":\"2001\"}";
		} else {
			return "{\"type\":\"2002\"}";
		}
	}

}
