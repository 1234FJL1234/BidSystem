package com.bidsystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bidsystem.bean.Specialist;

public interface ISpecialistService {

	// 更据项目查专家
	public List<Specialist> selectByPro(@Param("id") Integer id);

	// 新增专家
	public int addSpecialist(Specialist specialist);

	// 修改专家
	public int updateSpecialist(Specialist specialist);

	// 导出选中
	public List<Specialist> getById(String[] ids);

	// 导出所有
	public List<Specialist> getAll();
}
