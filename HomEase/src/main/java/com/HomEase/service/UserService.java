package com.HomEase.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HomEase.entity.User;
import com.HomEase.repo.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository repository;

	public List<User> getUsers() {
	
		return (List<User>)repository.findAll();
	}

	public User getUser(Long id) {
		
		User user=null;
		try {
		user=repository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public User insertUser(User ut) {
	
		User user=null;
		try {
			user=repository.save(ut);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public User updateUser(Long id, User ut) {
		User user=null;
		if(ut.getUserId()==id) {
		User oldUser = repository.findById(id).get();
		LocalDateTime date = LocalDateTime.now();
		oldUser.setUsername(ut.getUsername());
		oldUser.setPassword(ut.getPassword());
		oldUser.setEmail(ut.getEmail());
		oldUser.setPhone_number(ut.getPhone_number());
		oldUser.setUpdate_at(date);
		
		return repository.save(oldUser);
		}
		return user;
	}

	public User deleteUser(Long id) {
		
		User user=null;
		try {
		user=repository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(user !=null)
		{
			repository.deleteById(id);
		}
	return user;
	}
}
