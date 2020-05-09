package com.academy.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academy.app.entity.Subjects;

@Repository
public interface SubjectsDao extends CrudRepository<Subjects, Integer>{

}
