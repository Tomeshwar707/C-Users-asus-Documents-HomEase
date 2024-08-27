package com.HomEase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.HomEase.entity.User;
import com.HomEase.service.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("user/")
public class UserController {
	@Autowired
	UserService  userService;
	
	/*
	 * @GetMapping("getAll/") public ResponseEntity<List<User>> getUsers() {
	 * List<User> lst=userService.getUsers(); if(lst.isEmpty()) { return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 * 
	 * } return ResponseEntity.status(HttpStatus.OK).body(lst); }
	 */
	
	@GetMapping("get/{id}")
	public ResponseEntity< User> getUser(@PathVariable ("id") Long id) {
		User user= userService.getUser(id);
		if(user==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
			return ResponseEntity.status(HttpStatus.FOUND).body(user);
	}
	
	
	@PostMapping("insert/")
	public ResponseEntity<User> insertUser(@RequestBody User ut) {
				
		User user = userService.insertUser(ut);
		if(user==null)
				return	ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		return	ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("update/{id}")
	public  ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User ut) {
		
		
		User user= userService.updateUser(id,ut);
		if(user==null)
		{
		return	ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return	ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
	User user=	userService.deleteUser(id);
		if(user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}