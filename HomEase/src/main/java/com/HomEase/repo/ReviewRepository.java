package com.HomEase.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HomEase.entity.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

}
