package com.academy.app.service;

import java.util.List;

import com.academy.app.entity.StaffType;

public interface StaffTypeService {
	
	public List<StaffType> findAll();
	
	public StaffType findByID(Integer id);
	
	public StaffType save(StaffType obj);
	
	public StaffType update(StaffType obj);
	
	public void delete(Integer id);
}
