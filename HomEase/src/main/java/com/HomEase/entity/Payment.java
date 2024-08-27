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
@Table(name = "payments")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	@ManyToOne
	@JoinColumn(name = "service_id")
	private Services services;
	
	private Double amount;
	private String paymentMethod;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	private String transactionId;
	
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	public Payment() {
		super();
	}
	public Payment(Long paymentId, Services services, Double amount, String paymentMethod, PaymentStatus paymentStatus,
			String transactionId, LocalDateTime createAt, LocalDateTime updateAt) {
		super();
		this.paymentId = paymentId;
		this.services = services;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	public Payment(Services services, Double amount, String paymentMethod, PaymentStatus paymentStatus,
			String transactionId, LocalDateTime createAt, LocalDateTime updateAt) {
		super();
		this.services = services;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}
	public Long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Services getServices() {
		return services;
	}
	public void setServices(Services services) {
		this.services = services;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
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
		return "Payment [paymentId=" + paymentId + ", services=" + services + ", amount=" + amount + ", paymentMethod="
				+ paymentMethod + ", paymentStatus=" + paymentStatus + ", transactionId=" + transactionId
				+ ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}

	
	
}
