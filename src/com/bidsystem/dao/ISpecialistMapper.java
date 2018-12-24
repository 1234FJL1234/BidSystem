package com.bidsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bidsystem.bean.Specialist;

public interface ISpecialistMapper {

	// 更据专家查投标项目
	public List<Specialist> selectByPro(@Param("id") Integer id);

	// 新增专家
	public int addSpecialist(Specialist specialist);

	// 修改专家
	public int updateSpecialist(Specialist specialist);

	// 导出选中
	public List<Specialist> getById(String[] ids);

	// 导出
	public List<Specialist> getAll();
}
