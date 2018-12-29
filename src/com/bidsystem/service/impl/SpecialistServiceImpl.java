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
	public List<Specialist> selectByPro(Specialist specialist) {
		return sm.selectByPro(specialist.getId());
	}

	@Override
	public int addSpecialist(Specialist specialist) {
		return sm.addSpecialist(specialist);
	}

	@Override
	public int updateSpecialist(Specialist specialist) {
		return sm.updateSpecialist(specialist);
	}

	@Override
	public List<Specialist> getById(String[] ids) {
		return sm.getById(ids);
	}

	@Override
	public List<Specialist> getAll() {
		return sm.getAll();
	}

	@Override
	public List<Specialist> Listsele1() {
		return sm.Listsele1();
	}

	@Override
	public List<Specialist> Listselect(String type, String name) {
		return sm.Listselect(type, name);
	}

	@Override
	public int iddelete(int[] ids) {
		return sm.iddelete(ids);
	}
	
}
