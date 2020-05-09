package com.academy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.app.entity.AcademicYears;
import com.academy.app.repository.AcademicYearsDao;

@Service
@Transactional
public class AcademicYearsServiceImpl implements AcademicYearsService {

	@Autowired
	private AcademicYearsDao academicYearsDao;
	
	@Override
	public List<AcademicYears> findAll() {
		return (List<AcademicYears>) academicYearsDao.findAll();
	}

	@Override
	public AcademicYears findByID(Integer id) {
		return academicYearsDao.findById(id).get();
	}

	@Override
	public AcademicYears save(AcademicYears obj) {
		return academicYearsDao.save(obj);
	}

	@Override
	public AcademicYears update(AcademicYears obj) {
		return academicYearsDao.save(obj);
	}

	@Override
	public void delete(Integer id) {
		academicYearsDao.deleteById(id);
	}

}
