package com.haikuo.sky.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haikuo.sky.dao.FuckDao;
import com.haikuo.sky.dao.impl.FuckDaoImpl;
import com.haikuo.sky.model.Fuck;
import com.haikuo.sky.service.FuckService;

@Service
public class FuckServiceImpl implements FuckService{
	
	@Autowired
	private FuckDao fuckDao;

	public FuckDao getFuckDao() {
		return fuckDao;
	}

	public void setFuckDao(FuckDao fuckDao) {
		this.fuckDao = fuckDao;
	}

	@Override
	public void add(Fuck fc) {
		// TODO Auto-generated method stub
		fuckDao.save(fc);
	}

	
	
	
}
