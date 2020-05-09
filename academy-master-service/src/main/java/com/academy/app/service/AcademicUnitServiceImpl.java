package com.academy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.app.entity.AcademicUnit;
import com.academy.app.repository.AcademicUnitDao;

@Service
@Transactional
public class AcademicUnitServiceImpl implements AcademicUnitService {

	@Autowired
	private AcademicUnitDao academicUnitDao;
	
	@Override
	public List<AcademicUnit> findAll() {
		return (List<AcademicUnit>) academicUnitDao.findAll();
	}

	@Override
	public AcademicUnit findByID(Integer id) {
		return academicUnitDao.findById(id).get();
	}

	@Override
	public AcademicUnit save(AcademicUnit obj) {
		return academicUnitDao.save(obj);
	}

	@Override
	public AcademicUnit update(AcademicUnit obj) {
		return academicUnitDao.save(obj);
	}

	@Override
	public void delete(Integer id) {
		academicUnitDao.deleteById(id);
	}

}
