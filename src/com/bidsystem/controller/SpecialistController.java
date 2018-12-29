package com.bidsystem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bidsystem.bean.Specialist;
import com.bidsystem.service.ISpecialistService;
import com.bidsystem.util.ExcelWriter;

@Controller
@RequestMapping("specialist")
public class SpecialistController {

	@Autowired
	private ISpecialistService ss;

	// 根据项目ID查询有多少专家投 
	@RequestMapping("list")
	@ResponseBody
	public Object listSpecialist(@RequestBody Specialist specialist, Model model) {
		List<Specialist> list = ss.selectByPro(specialist);
		if (list != null) {
			return list;
		}else {
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
				"attachment;filename=Specialist-" + System.currentTimeMillis() + ".xlsx");
		List<Specialist> SpecialistList = ss.getById(ids);
		ExcelWriter<Specialist> ew = new ExcelWriter<>();
		XSSFWorkbook workbook = ew.getWorkbook(SpecialistList, "项目信息", Specialist.class);
		workbook.write(response.getOutputStream());
	}

	// 导出
	@RequestMapping("export")
	protected void doExpertAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition",
				"attachment;filename=Specialist-" + System.currentTimeMillis() + ".xlsx");
		List<Specialist> SpecialistList = ss.getAll();
		ExcelWriter<Specialist> ew = new ExcelWriter<>();
		XSSFWorkbook workbook = ew.getWorkbook(SpecialistList, "项目信息", Specialist.class);
		workbook.write(response.getOutputStream());
	}

	// 删除专家
	@RequestMapping("delete")
	@ResponseBody
	public String delete(@RequestBody int[] ids, Model model) {
		int result = ss.iddelete(ids);
		if (result >= 1) {
			return "{\"type\":\"2001\"}";
		} else {
			return "{\"type\":\"2002\"}";
		}
	}

	// 主界面显示（专家）
	@RequestMapping("search")
	@ResponseBody
	public Object fun2(Model m,HttpServletRequest request) {
		List<Specialist> list = ss.Listsele1();
		m.addAttribute("list", list);
		return list;
	}

	// 多条件查询（专家）
	@RequestMapping("doselect")
	@ResponseBody
	public Object fun3(Model m, @RequestBody String name, @RequestBody String type,HttpServletRequest request) {
		List<Specialist> list = ss.Listselect(type, name);
		if (list == null) {
			return "无查询结果";
		} else {
			m.addAttribute("list", list);
			return list;
		}
	}
}
