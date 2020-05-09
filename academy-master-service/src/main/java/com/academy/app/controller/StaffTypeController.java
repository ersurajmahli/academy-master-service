package com.academy.app.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.academy.app.entity.StaffType;
import com.academy.app.service.StaffTypeService;

@RestController
public class StaffTypeController {

	@Autowired
	StaffTypeService staffTypeService;
	
	
	@RequestMapping(value = "/staffType")
	public ResponseEntity<List<StaffType>> getAll() {
		List<StaffType> list = staffTypeService.findAll();
		return new ResponseEntity<List<StaffType>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/staffType/{id}", method = RequestMethod.GET)
	public ResponseEntity<StaffType> get(@PathVariable Integer id) {
		try {
			StaffType obj = staffTypeService.findByID(id);
			return new ResponseEntity<StaffType>(obj, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<StaffType>(HttpStatus.NOT_FOUND);
		}
	}

	// @RequestMapping(value = "/staff", method = RequestMethod.POST)
	@PostMapping(value = "/staffType")
	public ResponseEntity<Void> addArticle(@RequestBody StaffType obj, UriComponentsBuilder builder) {
		StaffType s = staffTypeService.save(obj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/staffType/{id}").buildAndExpand(s.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/staffType/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		staffTypeService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/staffType")
	public ResponseEntity<StaffType> updateArticle(@RequestBody StaffType obj) {
		staffTypeService.update(obj);
		return new ResponseEntity<StaffType>(obj, HttpStatus.OK);
	}

}
