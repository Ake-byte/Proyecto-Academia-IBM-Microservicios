package com.ibm.ejercicio1.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.ejercicio1.producer.dao.IPassionDao;
import com.ibm.ejercicio1.producer.model.Passion;

@Service
public class PassionServiceImpl implements IPassionService{

	@Autowired
	private IPassionDao passionDao;
	
	@Override
	@Transactional(readOnly=true)
	public Passion findPassion(Long id) {
		return passionDao.findById(id).orElse(null);
	}

	@Override
	public Passion findPassionByName(String passionName) {
		return passionDao.findPassionByName(passionName);
	}

}
