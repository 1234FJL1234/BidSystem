package com.bidsystem.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bidsystem.bean.Project;
import com.bidsystem.bean.Specialist;

public interface IProjectMapper {
	public List<Specialist> selectByPro(@Param("id") Integer id);
	
}
