package com.academy.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academy.app.entity.AcademicUnit;

@Repository
public interface AcademicUnitDao extends CrudRepository<AcademicUnit, Integer>{

}
