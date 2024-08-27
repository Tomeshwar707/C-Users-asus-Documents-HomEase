package com.HomEase.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HomEase.entity.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
