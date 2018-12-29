package com.bidsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bidsystem.bean.Project;
import com.bidsystem.service.IProjectService;
import com.bidsystem.util.ExcelWriter;

@Controller
@RequestMapping("project")
public class ProjectController {

	@Autowired
	private IProjectService ps;

	// 通过专家id查项目
	@RequestMapping("listProject")
	@ResponseBody
	public Object dolistProject(@RequestBody Project project, Model model) {
		List<Project> list = ps.listProject(project);
		if (list != null) {
			return list;
		} else {
			return "查询无结果";
		}
	}

	// 导出选中
	@RequestMapping("exportChk")
	protected void doExportChk(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] ids = request.getParameterValues("id");
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition",
				"attachment;filename=Project-" + System.currentTimeMillis() + ".xlsx");
		List<Project> ProjectList = ps.getById(ids);
		ExcelWriter<Project> ew = new ExcelWriter<>();
		XSSFWorkbook workbook = ew.getWorkbook(ProjectList, "项目信息", Project.class);
		workbook.write(response.getOutputStream());
	}

	// 导出
	@RequestMapping("export")
	protected void doExpertAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition",
				"attachment;filename=Project-" + System.currentTimeMillis() + ".xlsx");
		List<Project> ProjectList = ps.getAll();
		ExcelWriter<Project> ew = new ExcelWriter<>();
		XSSFWorkbook workbook = ew.getWorkbook(ProjectList, "项目信息", Project.class);
		workbook.write(response.getOutputStream());
	}

	@RequestMapping("listProjectByNum")
	@ResponseBody
	public Object listProjectByNum(@RequestBody Project project, String names, String selectType, Model model) {
		System.out.println("类型" + selectType + "名字" + names);
		if (selectType == null | selectType == " ") {
			selectType = "-1";
		} else if (selectType.equals("1")) {
			project.setProjectNum(names);
		} else if (selectType.equals("2")) {
			project.setProjectName(names);
		}
		List<Project> list = ps.listProjectByNum(project);
		System.out.println("========================" + list.size());
		model.addAttribute("names", names);
		model.addAttribute("selectType", selectType);
		model.addAttribute("list", list);
		return project;
	}

	@RequestMapping("deleteProject")
	@ResponseBody
	public String deleteProject(int[] ids, Model model) {
		System.out.println("进入删除！");
		int rs = ps.deleteProject(ids);
		if (rs > 0) {
			return "{\"type\":\"2001\"}";
		}else {
			return "{\"type\":\"2002\"}";
		}
	}
}
