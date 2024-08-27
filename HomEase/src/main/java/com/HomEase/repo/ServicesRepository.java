package com.HomEase.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HomEase.entity.Services;

@Repository
public interface ServicesRepository extends CrudRepository<Services, Long>{

}
