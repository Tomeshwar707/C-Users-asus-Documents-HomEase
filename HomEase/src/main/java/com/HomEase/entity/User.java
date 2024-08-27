package com.HomEase.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	private String username;
	private String password;
	private String email;
	private String phone_number;
	
	@Enumerated(EnumType.STRING)
	private String userType;
	
	private LocalDateTime created_at;
	private LocalDateTime update_at;
	
	
	public User(Long userId, String username, String password, String email, String phone_number, String userType) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.userType = userType;
	}



	public User(String username, String password, String email, String phone_number, String userType,
			LocalDateTime created_at, LocalDateTime update_at) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.userType = userType;
		this.created_at = created_at;
		this.update_at = update_at;
	}
	public User(Long userId, String username, String password, String email, String phone_number, String userType,
			LocalDateTime created_at, LocalDateTime update_at) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone_number = phone_number;
		this.userType = userType;
		this.created_at = created_at;
		this.update_at = update_at;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
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
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", phone_number=" + phone_number + ", userType=" + userType + ", created_at=" + created_at
				+ ", update_at=" + update_at + "]";
	}
		
	
	
}
