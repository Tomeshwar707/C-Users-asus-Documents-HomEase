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

import com.HomEase.entity.Profile;
import com.HomEase.service.ProfileService;


@RestController
@RequestMapping("profile/")
public class ProfileController {

	@Autowired
	ProfileService  profileService;
	
	/*
	 * @GetMapping("getAll/") public ResponseEntity<List<Profile>> getProfiles() {
	 * List<Profile> lst=profileService.getProfiles(); if(lst.isEmpty()) { return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 * 
	 * } return ResponseEntity.status(HttpStatus.OK).body(lst); }
	 */
	
	@GetMapping("get/{id}")
	public ResponseEntity< Profile> getProfile(@PathVariable ("id") Long id) {
		Profile profile= profileService.getProfile(id);
		if(profile==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
			return ResponseEntity.status(HttpStatus.FOUND).body(profile);
	}
	
	@PostMapping("insert/")
	public ResponseEntity< Profile> insertProfile(@RequestBody Profile ut) {
		Profile profile = profileService.insertProfile(ut);
		if(profile==null)
				return	ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		return	ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity <Profile> updateProfile(@PathVariable Long id, @RequestBody Profile ut) {
		
		
		Profile profile= profileService.updateProfile(id,ut);
		if(profile==null)
		{
		return	ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return	ResponseEntity.status(HttpStatus.OK).body(profile);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deletePrfile(@PathVariable Long id) {
		Profile profile=profileService.deleteProfile(id);
		if(profile==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
