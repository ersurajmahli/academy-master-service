package com.academy.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academy.app.entity.Subjects;
import com.academy.app.repository.SubjectsDao;

@Service
@Transactional
public class SubjectsServiceImpl implements SubjectsService {

	@Autowired
	private SubjectsDao subjectsDao;
	
	@Override
	public List<Subjects> findAll() {
		return (List<Subjects>) subjectsDao.findAll();
	}

	@Override
	public Subjects findByID(Integer id) {
		return subjectsDao.findById(id).get();
	}

	@Override
	public Subjects save(Subjects obj) {
		return subjectsDao.save(obj);
	}

	@Override
	public Subjects update(Subjects obj) {
		return subjectsDao.save(obj);
	}

	@Override
	public void delete(Integer id) {
		subjectsDao.deleteById(id);
	}

}
