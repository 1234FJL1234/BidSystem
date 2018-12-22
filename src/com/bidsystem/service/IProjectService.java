package com.bidsystem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bidsystem.bean.Project;
import com.bidsystem.bean.Specialist;

public interface IProjectService {
	

	//更据专家查投标项目
		public List<Project> listProject(Integer id);
}
