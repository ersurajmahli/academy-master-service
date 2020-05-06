package com.academy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.app.entity.StaffType;
import com.academy.app.repository.StaffTypeDao;

@Service
@Transactional
public class StaffTypeServiceImpl implements StaffTypeService {
	
	@Autowired
	StaffTypeDao staffTypeDao;

	@Override
	public List<StaffType> findAll() {
		return (List<StaffType>) staffTypeDao.findAll();
	}

	@Override
	public StaffType findByID(Integer id) {
		return staffTypeDao.findById(id).get();
	}

	@Override
	public StaffType save(StaffType obj) {
		return staffTypeDao.save(obj);
	}

	@Override
	public StaffType update(StaffType obj) {
		return staffTypeDao.save(obj);
	}

	@Override
	public void delete(Integer id) {
		staffTypeDao.deleteById(id);
	}

}
