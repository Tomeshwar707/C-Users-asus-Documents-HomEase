package com.HomEase.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long reviewId;
	
	@ManyToOne
	@JoinColumn(name = "service_ id")
	private Services services;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User customer;
	
	@ManyToOne
	@JoinColumn(name = "provider_id")
	private User provider;
	
	private Integer  rating;
	private String comment;

	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	public Review() {
		super();
	}

	public Review(Services services, User customer, User provider, Integer rating, String comment,
			LocalDateTime createAt, LocalDateTime updateAt) {
		super();
		this.services = services;
		this.customer = customer;
		this.provider = provider;
		this.rating = rating;
		this.comment = comment;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Review(Long reviewId, Services services, User customer, User provider, Integer rating, String comment,
			LocalDateTime createAt, LocalDateTime updateAt) {
		super();
		this.reviewId = reviewId;
		this.services = services;
		this.customer = customer;
		this.provider = provider;
		this.rating = rating;
		this.comment = comment;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Services getServices() {
		return services;
	}

	public void setServices(Services services) {
		this.services = services;
	}

	public User getCustomer() {
		return customer;
	}

	public void setCustomer(User customer) {
		this.customer = customer;
	}

	public User getProvider() {
		return provider;
	}

	public void setProvider(User provider) {
		this.provider = provider;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", services=" + services + ", customer=" + customer + ", provider="
				+ provider + ", rating=" + rating + ", comment=" + comment + ", createAt=" + createAt + ", updateAt="
				+ updateAt + "]";
	}
	
	
	
}
