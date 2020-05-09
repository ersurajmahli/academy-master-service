package com.academy.app.service;

import java.util.List;

import com.academy.app.entity.AcademicUnit;

public interface AcademicUnitService {
	
	public List<AcademicUnit> findAll();
	
	public AcademicUnit findByID(Integer id);
	
	public AcademicUnit save(AcademicUnit obj);
	
	public AcademicUnit update(AcademicUnit obj);
	
	public void delete(Integer id);


}
