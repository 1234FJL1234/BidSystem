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
import org.springframework.web.bind.annotation.RequestMapping;

import com.bidsystem.bean.Project;
import com.bidsystem.service.IProjectService;
import com.bidsystem.util.ExcelWriter;

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
}
