package com.HomEase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.HomEase.entity.Profile;
import com.HomEase.repo.ProfileRepository;

@Service
public class ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	public List<Profile> getProfiles() {
		return (List<Profile>) profileRepository.findAll();
	}

	public Profile getProfile(Long id) {
		Profile profile=null;
		try {
		profile=profileRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return profile;
	}

	public Profile insertProfile(Profile ut) {
		Profile profile=null;
		try {
			profile=profileRepository.save(ut);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return profile;
	}

	public Profile updateProfile(Long id, Profile ut) {
		return profileRepository.save(ut);
	}

	public Profile deleteProfile(Long id) {
		Profile profile=null;
		try {
		profile=profileRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(profile !=null)
		{
			profileRepository.deleteById(id);
		}
	return profile;
	}
	
	

	    
}
