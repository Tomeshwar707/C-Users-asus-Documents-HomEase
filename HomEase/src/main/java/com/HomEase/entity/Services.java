package com.HomEase.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
@Table(name="services")
public class Services {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceId;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private User customer;
	
	@ManyToOne
	@JoinColumn(name="provider_id")
	private User provider;
	
	private String serviceType;
	private String description;
	private LocalDate scheduledDate;
	private LocalTime scheduledTime;

	@Enumerated(EnumType.STRING)
	private ServiceStatus status;
	
	private LocalDateTime  createAt;
	private LocalDateTime  updatedAt;
	public Services() {
		super();
	}
	public Services(User customer, User provider, String serviceType, String description, LocalDate scheduledDate,
			LocalTime scheduledTime, ServiceStatus status, LocalDateTime createAt, LocalDateTime updatedAt) {
		super();
		this.customer = customer;
		this.provider = provider;
		this.serviceType = serviceType;
		this.description = description;
		this.scheduledDate = scheduledDate;
		this.scheduledTime = scheduledTime;
		this.status = status;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
	}
	public Services(Long serviceId, User customer, User provider, String serviceType, String description,
			LocalDate scheduledDate, LocalTime scheduledTime, ServiceStatus status, LocalDateTime createAt,
			LocalDateTime updatedAt) {
		super();
		this.serviceId = serviceId;
		this.customer = customer;
		this.provider = provider;
		this.serviceType = serviceType;
		this.description = description;
		this.scheduledDate = scheduledDate;
		this.scheduledTime = scheduledTime;
		this.status = status;
		this.createAt = createAt;
		this.updatedAt = updatedAt;
	}
	
	
	public Long getServiceId() {
		return serviceId;
	}
	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
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
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(LocalDate scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	public LocalTime getScheduledTime() {
		return scheduledTime;
	}
	public void setScheduledTime(LocalTime scheduledTime) {
		this.scheduledTime = scheduledTime;
	}
	public ServiceStatus getStatus() {
		return status;
	}
	public void setStatus(ServiceStatus status) {
		this.status = status;
	}
	public LocalDateTime getCreateAt() {
		return createAt;
	}
	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
	 	this.updatedAt = updatedAt;
	}
	
	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", customer=" + customer + ", provider=" + provider
				+ ", serviceType=" + serviceType + ", description=" + description + ", scheduledDate=" + scheduledDate
				+ ", scheduledTime=" + scheduledTime + ", status=" + status + ", createAt=" + createAt + ", updatedAt="
				+ updatedAt + "]";
	}	
	

}
