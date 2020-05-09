package com.academy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.app.entity.StaffBand;
import com.academy.app.repository.StaffBandDao;

@Service
@Transactional
public class StaffBandServiceImpl implements StaffBandService {
	
	@Autowired
	private StaffBandDao staffBandDao;

	@Override
	public List<StaffBand> findAll() {
		return (List<StaffBand>) staffBandDao.findAll();
	}

	@Override
	public StaffBand findByID(Integer id) {
		return staffBandDao.findById(id).get();
	}

	@Override
	public StaffBand save(StaffBand obj) {
		return staffBandDao.save(obj);
	}

	@Override
	public StaffBand update(StaffBand obj) {
		return staffBandDao.save(obj);
	}

	@Override
	public void delete(Integer id) {
		staffBandDao.deleteById(id);
	}

}
