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

import com.academy.app.entity.StaffBand;
import com.academy.app.service.StaffBandService;

@RestController
public class StaffBandController {
	
	@Autowired
	private StaffBandService staffBandService;
	
	
	@GetMapping("/staffBand")
	public ResponseEntity<List<StaffBand>> findAll(){
		List<StaffBand> result = staffBandService.findAll();
		return new ResponseEntity<List<StaffBand>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/staffBand/{id}")
	public ResponseEntity<StaffBand> findByID(@PathVariable Integer id){
		try {
			StaffBand result = staffBandService.findByID(id);
			return new ResponseEntity<StaffBand>(result, HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<StaffBand>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/staffBand")
	public ResponseEntity<Void> save(@RequestBody StaffBand obj, UriComponentsBuilder builder) {
		StaffBand s = staffBandService.save(obj);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/staffBand/{id}").buildAndExpand(s.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@DeleteMapping("/staffBand/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		staffBandService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	@PutMapping("/staffBand")
	public ResponseEntity<StaffBand> update(@RequestBody StaffBand obj) {
		staffBandService.update(obj);
		return new ResponseEntity<StaffBand>(obj, HttpStatus.OK);
	}

}
