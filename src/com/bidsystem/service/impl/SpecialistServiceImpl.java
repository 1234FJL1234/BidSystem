package com.bidsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bidsystem.bean.Specialist;
import com.bidsystem.dao.ISpecialistMapper;
import com.bidsystem.service.ISpecialistService;
@Service
public class SpecialistServiceImpl implements ISpecialistService{

	@Autowired
	private ISpecialistMapper sm;
	
	@Override
	public List<Specialist> selectByPro(Integer id) {
		return sm.selectByPro(id);
	}

	@Override
	public int addSpecialist(Specialist specialist) {
		return sm.addSpecialist(specialist);
	}

	@Override
	public int updateSpecialist(Specialist specialist) {
		return sm.updateSpecialist(specialist);
	}
	
}
