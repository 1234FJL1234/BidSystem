package com.bidsystem.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bidsystem.bean.Project;
import com.bidsystem.service.IProjectService;

@Controller
@RequestMapping("project")
public class ProjectController {
	
	@Autowired
	private IProjectService ps;


	@RequestMapping("listProject")
	public String dolistProject(@Param("id") Integer id, Model model) {
		System.out.println("前台正在请求listProject");
		List<Project> list = ps.listProject(id);
		if (list != null) {
			System.out.println("查询成功");
			model.addAttribute("project", list);
		}
		return "listProject";
	}
}
	
