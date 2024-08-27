package com.HomEase.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HomEase.entity.Review;
import com.HomEase.repo.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	ReviewRepository reviewRepository;

	public List<Review> getReviews() {
		return (List<Review>) reviewRepository.findAll();
	}

	public Review getReview(Long id) {
		Review review=null;
		try {
		review=reviewRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return review;
	}

	public Review insertReview(Review ut) {
		Review review=null;
		try {
			review=reviewRepository.save(ut);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return review;
	}
	public Review updateReview(Long id, Review ut) {
		Review review=null;
		if(ut.getReviewId()==id) {
		Review oldUser = reviewRepository.findById(id).get();
		LocalDateTime date = LocalDateTime.now();
		oldUser.setServices(ut.getServices());
		oldUser.setCustomer(ut.getCustomer());
		oldUser.setProvider(ut.getProvider());
		oldUser.setRating(ut.getRating());
		oldUser.setComment(ut.getComment());
		oldUser.setUpdateAt(date);
		
		return reviewRepository.save(oldUser);
		}
		return review;
	}


	public Review deleteReview(Long id) {
		Review review=null;
		try {
		review=reviewRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(review !=null)
		{
			reviewRepository.deleteById(id);
		}
	return review;
	}

}
