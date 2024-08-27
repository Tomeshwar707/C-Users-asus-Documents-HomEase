package com.HomEase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.HomEase.entity.Services;
import com.HomEase.service.ServicesService;


@RestController
@RequestMapping("Servicess/")
public class ServicesController {

	@Autowired
	ServicesService service;
	
	/*
	 * @GetMapping("getAll/") public ResponseEntity<List<Services>> getServicess() {
	 * List<Services> lst=service.getServices(); if(lst.isEmpty()) { return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 * 
	 * } return ResponseEntity.status(HttpStatus.OK).body(lst); }
	 */
	
	@GetMapping("get/{id}")
	public ResponseEntity< Services> getServices(@PathVariable ("id") Long id) {
		Services services= service.getServices(id);
		if(services==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
			return ResponseEntity.status(HttpStatus.FOUND).body(services);
	}
	
	
	@PostMapping("insert/")
	public ResponseEntity<Services> insertServices(@RequestBody Services ut) {
				
		Services services = service.insertServices(ut);
		if(services==null)
				return	ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		return	ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("update/{id}")
	public  ResponseEntity<Services> updateServices(@PathVariable Long id, @RequestBody Services ut) {
		
		
		Services services= service.updateServices(id,ut);
		if(services==null)
		{
		return	ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return	ResponseEntity.status(HttpStatus.OK).body(services);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteServices(@PathVariable Long id) {
	Services services=	service.deleteServices(id);
		if(services==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
