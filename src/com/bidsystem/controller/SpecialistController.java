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

import com.bidsystem.bean.Specialist;
import com.bidsystem.service.ISpecialistService;
import com.bidsystem.util.ExcelWriter;
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
}
