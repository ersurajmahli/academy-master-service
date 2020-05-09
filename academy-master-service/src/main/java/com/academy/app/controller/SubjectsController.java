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

import com.academy.app.entity.Subjects;
import com.academy.app.service.SubjectsService;

@RestController
public class SubjectsController {
	
	@Autowired
	private SubjectsService subjectsService;
	
	
	@GetMapping("/subjects")
	public ResponseEntity<List<Subjects>> findAll(){
		List<Subjects> result = subjectsService.findAll();
		return new ResponseEntity<List<Subjects>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/subjects/{id}")
	public ResponseEntity<Subjects> findByID(@PathVariable Integer id){
		try {
			Subjects result = subjectsService.findByID(id);
			return new ResponseEntity<Subjects>(result, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Subjects>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/subjects")
	public ResponseEntity<Void> save(@RequestBody Subjects obj, UriComponentsBuilder builder) {
		Subjects s = subjectsService.save(obj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/subjects/{id}").buildAndExpand(s.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/subjects/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		subjectsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/subjects")
	public ResponseEntity<Subjects> update(@RequestBody Subjects obj) {
		subjectsService.update(obj);
		return new ResponseEntity<Subjects>(obj, HttpStatus.OK);
	}



}
