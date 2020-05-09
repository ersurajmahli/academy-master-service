package com.academy.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academy.app.entity.AcademicYears;

@Repository
public interface AcademicYearsDao extends CrudRepository<AcademicYears, Integer>{

}
