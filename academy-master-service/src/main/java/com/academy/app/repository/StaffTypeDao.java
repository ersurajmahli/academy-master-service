package com.academy.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academy.app.entity.StaffType;

@Repository
public interface StaffTypeDao extends CrudRepository<StaffType, Integer> {

}
