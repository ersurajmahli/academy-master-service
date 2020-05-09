package com.academy.app.service;

import java.util.List;

import com.academy.app.entity.AcademicYears;

public interface AcademicYearsService {
	
	public List<AcademicYears> findAll();
	
	public AcademicYears findByID(Integer id);
	
	public AcademicYears save(AcademicYears obj);
	
	public AcademicYears update(AcademicYears obj);
	
	public void delete(Integer id);

}
