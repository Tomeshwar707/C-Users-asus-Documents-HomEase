package com.HomEase.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="profile")
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long profileId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private String name;
	
	private String email;
	
	private String mobileNo;
	
	@Enumerated(EnumType.STRING)
	private UserType userType;
	
	private String password;
	
	private String serviceType;
	
	private String experience;
	
	private String location;
	
	private String availability;
	
	private Double rating;
	
	private String bio;
	
	private Byte image;

	private LocalDateTime created_at;
	private LocalDateTime update_at;
	

	public Profile() {
		super();
	}


	public Profile(Long profileId, User user, String name, String serviceType, String experience, String location,
			String availability, Double rating, String bio, LocalDateTime created_at, LocalDateTime update_at) {
		super();
		this.profileId = profileId;
		this.user = user;
		this.name = name;
		this.serviceType = serviceType;
		this.experience = experience;
		this.location = location;
		this.availability = availability;
		this.rating = rating;
		this.bio = bio;
		this.created_at = created_at;
		this.update_at = update_at;
	}


	public Profile(User user, String name, String email, String mobileNo, UserType userType, String password,
			String serviceType, String experience, String location, String availability, Double rating, String bio,
			LocalDateTime created_at, LocalDateTime update_at) {
		super();
		this.user = user;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.userType = userType;
		this.password = password;
		this.serviceType = serviceType;
		this.experience = experience;
		this.location = location;
		this.availability = availability;
		this.rating = rating;
		this.bio = bio;
		this.created_at = created_at;
		this.update_at = update_at;
	}


	public Profile(Long profileId, User user, String name, String email, String mobileNo, UserType userType,
			String password, String serviceType, String experience, String location, String availability, Double rating,
			String bio, LocalDateTime created_at, LocalDateTime update_at) {
		super();
		this.profileId = profileId;
		this.user = user;
		this.name = name;
		this.email = email;
		this.mobileNo = mobileNo;
		this.userType = userType;
		this.password = password;
		this.serviceType = serviceType;
		this.experience = experience;
		this.location = location;
		this.availability = availability;
		this.rating = rating;
		this.bio = bio;
		this.created_at = created_at;
		this.update_at = update_at;
	}


	public Long getProfileId() {
		return profileId;
	}


	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public UserType getUserType() {
		return userType;
	}


	public void setUserType(UserType userType) {
		this.userType = userType;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getServiceType() {
		return serviceType;
	}


	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getAvailability() {
		return availability;
	}


	public void setAvailability(String availability) {
		this.availability = availability;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public String getBio() {
		return bio;
	}


	public void setBio(String bio) {
		this.bio = bio;
	}


	public LocalDateTime getCreated_at() {
		return created_at;
	}


	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}


	public LocalDateTime getUpdate_at() {
		return update_at;
	}


	public void setUpdate_at(LocalDateTime update_at) {
		this.update_at = update_at;
	}


	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", user=" + user + ", name=" + name + ", email=" + email
				+ ", mobileNo=" + mobileNo + ", userType=" + userType + ", password=" + password + ", serviceType="
				+ serviceType + ", experience=" + experience + ", location=" + location + ", availability="
				+ availability + ", rating=" + rating + ", bio=" + bio + ", created_at=" + created_at + ", update_at="
				+ update_at + "]";
	}


}