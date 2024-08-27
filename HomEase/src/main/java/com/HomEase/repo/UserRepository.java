package com.HomEase.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HomEase.entity.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
}
