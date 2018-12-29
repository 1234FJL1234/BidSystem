package com.bidsystem.service;

import java.util.List;

import com.bidsystem.bean.Project;

public interface IProjectService {

	// 更据专家查投标项目
	public List<Project> listProject(Project project);

	// 导出选中
	public List<Project> getById(String[] ids);

	// 导出所有
	public List<Project> getAll();

	// 删除用户信息
	public int deleteProject(int[] ids);

	// 查询用户信息
	public List<Project> listProject();

	// 查询用户信息
	public List<Project> listProjectByNum(Project project);
}
