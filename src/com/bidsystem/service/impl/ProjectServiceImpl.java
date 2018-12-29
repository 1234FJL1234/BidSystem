package com.bidsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidsystem.bean.Project;
import com.bidsystem.dao.IProjectMapper;
import com.bidsystem.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {
	
	@Autowired
	private IProjectMapper pd;


	@Override
	public List<Project> listProject(Project project) {
		return pd.listProject(project.getId());
	}


	@Override
	public List<Project> getById(String[] ids) {
		return pd.getById(ids);
	}


	@Override
	public List<Project> getAll() {
		return pd.getAll();
	}

	@Override
	public int deleteProject(int[] ids) {
		return pd.deleteProject(ids);
	}


	@Override
	public List<Project> listProject() {
		return pd.listProject();
	}


	@Override
	public List<Project> listProjectByNum(Project project) {
		return pd.listProjectByNum(project.getProjectNum(), project.getProjectName());
	}
}
