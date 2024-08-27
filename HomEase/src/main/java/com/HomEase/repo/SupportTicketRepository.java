package com.HomEase.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HomEase.entity.SupportTicket;

@Repository
public interface SupportTicketRepository extends CrudRepository<SupportTicket, Long > {

}
