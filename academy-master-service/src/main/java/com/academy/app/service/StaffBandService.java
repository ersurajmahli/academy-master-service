package com.academy.app.service;

import java.util.List;

import com.academy.app.entity.StaffBand;

public interface StaffBandService {
	
	public List<StaffBand> findAll();
	
	public StaffBand findByID(Integer id);
	
	public StaffBand save(StaffBand obj);
	
	public StaffBand update(StaffBand obj);
	
	public void delete(Integer id);




}
