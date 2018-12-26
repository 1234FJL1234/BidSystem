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

	// 显示所有
	public List<Specialist> Listsele1();

	// 根据姓名，身份证，号码模糊查询
	public List<Specialist> Listselect(@Param("type") String type, @Param("name") String name);

	// 删除
	public int iddelete(@Param("array") int[] ids);
}
