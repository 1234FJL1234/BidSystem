package com.bidsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidsystem.bean.Project;
import com.bidsystem.bean.Specialist;
import com.bidsystem.dao.IProjectMapper;
import com.bidsystem.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {
	@Autowired
	private IProjectMapper pd;

	@Override
	public List<Specialist> selectByPro(Integer id) {
		return pd.selectByPro(id);
	}
	

}
