package com.bidsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bidsystem.bean.Project;

public interface IProjectMapper {
	
	//更据专家查投标项目
		public List<Project> listProject(@Param("id") Integer id);
	
}
