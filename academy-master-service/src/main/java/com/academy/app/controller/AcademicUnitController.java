package com.academy.app.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.academy.app.entity.AcademicUnit;
import com.academy.app.service.AcademicUnitService;

@RestController
public class AcademicUnitController {
	
	@Autowired
	private AcademicUnitService academicUnitService;
	
	@GetMapping("/academicUnit")
	public ResponseEntity<List<AcademicUnit>> findAll(){
		List<AcademicUnit> result = academicUnitService.findAll();
		return new ResponseEntity<List<AcademicUnit>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/academicUnit/{id}")
	public ResponseEntity<AcademicUnit> findByID(@PathVariable Integer id){
		try {
			AcademicUnit result = academicUnitService.findByID(id);
			return new ResponseEntity<AcademicUnit>(result, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<AcademicUnit>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/academicUnit")
	public ResponseEntity<Void> save(@RequestBody AcademicUnit obj, UriComponentsBuilder builder) {
		AcademicUnit s = academicUnitService.save(obj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/academicUnit/{id}").buildAndExpand(s.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/academicUnit/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		academicUnitService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/academicUnit")
	public ResponseEntity<AcademicUnit> update(@RequestBody AcademicUnit obj) {
		academicUnitService.update(obj);
		return new ResponseEntity<AcademicUnit>(obj, HttpStatus.OK);
	}



}
