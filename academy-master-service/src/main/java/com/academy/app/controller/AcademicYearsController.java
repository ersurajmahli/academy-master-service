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

import com.academy.app.entity.AcademicYears;
import com.academy.app.service.AcademicYearsService;

@RestController
public class AcademicYearsController {
	
	@Autowired
	private AcademicYearsService academicYearsService;
	
	
	@GetMapping("/academicYears")
	public ResponseEntity<List<AcademicYears>> findAll(){
		List<AcademicYears> result = academicYearsService.findAll();
		return new ResponseEntity<List<AcademicYears>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/academicYears/{id}")
	public ResponseEntity<AcademicYears> findByID(@PathVariable Integer id){
		try {
			AcademicYears result = academicYearsService.findByID(id);
			return new ResponseEntity<AcademicYears>(result, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<AcademicYears>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/academicYears")
	public ResponseEntity<Void> save(@RequestBody AcademicYears obj, UriComponentsBuilder builder) {
		AcademicYears s = academicYearsService.save(obj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/academicYears/{id}").buildAndExpand(s.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/academicYears/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		academicYearsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/academicYears")
	public ResponseEntity<AcademicYears> update(@RequestBody AcademicYears obj) {
		academicYearsService.update(obj);
		return new ResponseEntity<AcademicYears>(obj, HttpStatus.OK);
	}



}
