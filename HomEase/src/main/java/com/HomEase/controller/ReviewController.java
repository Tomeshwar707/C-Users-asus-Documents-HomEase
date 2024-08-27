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

import com.HomEase.entity.Review;
import com.HomEase.service.ReviewService;



@RestController
@RequestMapping("review/")
public class ReviewController {

	@Autowired
	ReviewService  reviewService;
	
	/*
	 * @GetMapping("getAll/") public ResponseEntity<List<Review>> getReviews() {
	 * List<Review> lst=reviewService.getReviews(); if(lst.isEmpty()) { return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 * 
	 * } return ResponseEntity.status(HttpStatus.OK).body(lst); }
	 * 
	 * @GetMapping("get/{id}") public ResponseEntity< Review>
	 * getReview(@PathVariable ("id") Long id) { Review review=
	 * reviewService.getReview(id); if(review==null) { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
	 * 
	 * return ResponseEntity.status(HttpStatus.FOUND).body(review); }
	 * 
	 */
	@PostMapping("insert/")
	public ResponseEntity<Review> insertReview(@RequestBody Review ut) {
				
		Review review = reviewService.insertReview(ut);
		if(review==null)
				return	ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		return	ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	/*
	 * @PutMapping("update/{id}") public ResponseEntity<Review>
	 * updateReview(@PathVariable Long id, @RequestBody Review ut) {
	 * 
	 * 
	 * Review review= reviewService.updateReview(id,ut); if(review==null) { return
	 * ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); } return
	 * ResponseEntity.status(HttpStatus.OK).body(review); }
	 * 
	 * @DeleteMapping("delete/{id}") public ResponseEntity<Void>
	 * deleteReview(@PathVariable Long id) { Review review=
	 * reviewService.deleteReview(id); if(review==null) { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).build(); } return
	 * ResponseEntity.status(HttpStatus.OK).build(); }
	 */
}
