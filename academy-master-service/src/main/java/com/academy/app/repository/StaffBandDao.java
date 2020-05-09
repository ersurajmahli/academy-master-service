package com.academy.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.academy.app.entity.StaffBand;

@Repository
public interface StaffBandDao extends CrudRepository<StaffBand, Integer>{

}
