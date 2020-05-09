package com.academy.app.service;

import java.util.List;

import com.academy.app.entity.Subjects;

public interface SubjectsService {
	
	public List<Subjects> findAll();
	
	public Subjects findByID(Integer id);
	
	public Subjects save(Subjects obj);
	
	public Subjects update(Subjects obj);
	
	public void delete(Integer id);




}
