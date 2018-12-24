package com.bidsystem.service;

import java.util.List;

import com.bidsystem.bean.Project;

public interface IProjectService {

	// 更据专家查投标项目
	public List<Project> listProject(Integer id);

	// 导出选中
	public List<Project> getById(String[] ids);

	// 导出所有
	public List<Project> getAll();
}
