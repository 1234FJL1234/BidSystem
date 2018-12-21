package com.bidsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bidsystem.bean.Project;
import com.bidsystem.bean.Specialist;
import com.bidsystem.service.IProjectService;

@Controller
@RequestMapping("list")
public class ProjectController {
	@Autowired
	private IProjectService ps;
	
	@RequestMapping("listproject")
	public String list(Integer id, Model model) {
		List<Specialist> Specialist =  ps.selectByPro(id);
		if(Specialist.size()>0) {
		model.addAttribute("Specialist", Specialist);
		}
		return "main";
		
	}

}
