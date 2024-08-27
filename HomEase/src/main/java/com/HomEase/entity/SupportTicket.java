package com.HomEase.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "supportTicket")
public class SupportTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;
	
	@ManyToOne
	@JoinColumn(name = "user_Id")
	private User user;
	
	private String subject;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private TicketStatus status;
	
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	public SupportTicket() {
		super();
	}

	public SupportTicket(Long ticketId, User user, String subject, String description, TicketStatus status,
			LocalDateTime createAt, LocalDateTime updateAt) {
		super();
		this.ticketId = ticketId;
		this.user = user;
		this.subject = subject;
		this.description = description;
		this.status = status;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public SupportTicket(User user, String subject, String description, TicketStatus status, LocalDateTime createAt,
			LocalDateTime updateAt) {
		super();
		this.user = user;
		this.subject = subject;
		this.description = description;
		this.status = status;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TicketStatus getStatus() {
		return status;
	}

	public void setStatus(TicketStatus status) {
		this.status = status;
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
		return "SupportTicket [ticketId=" + ticketId + ", user=" + user + ", subject=" + subject + ", description="
				+ description + ", status=" + status + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
	}
	
	
	
}
