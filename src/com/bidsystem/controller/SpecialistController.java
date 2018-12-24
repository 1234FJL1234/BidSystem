package com.bidsystem.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bidsystem.bean.Specialist;
import com.bidsystem.service.ISpecialistService;
@Controller
@RequestMapping("spcialist")
public class SpecialistController {

	@Autowired
	private ISpecialistService ss;
	
	
	@RequestMapping("list")
	public String listSpecialist(@Param(value="id") Integer id,Model model) {
		System.out.println("前台正在请求listSpecialist");
		List<Specialist> list = ss.selectByPro(id);
		if(list!=null) {
			System.out.println("查询成功");
			model.addAttribute("Specialist",list);
		}
		return "listSpecialist";
	}
	
}
