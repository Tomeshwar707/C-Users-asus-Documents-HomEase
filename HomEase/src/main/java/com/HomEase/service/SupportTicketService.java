package com.HomEase.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HomEase.entity.SupportTicket;
import com.HomEase.repo.SupportTicketRepository;

@Service
public class SupportTicketService {
	
	@Autowired
	SupportTicketRepository ticketRepository;

	public List<SupportTicket> getSupportTickets() {
		return (List<SupportTicket>) ticketRepository.findAll();
	}

	public SupportTicket getSupportTicket(Long id) {
		SupportTicket supportTicket=null;
		try {
		supportTicket=ticketRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return supportTicket;
	}

	public SupportTicket insertSupportTicket(SupportTicket ut) {
		SupportTicket supportTicket=null;
		try {
			supportTicket=ticketRepository.save(ut);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return supportTicket;
	}


	public SupportTicket updateSupportTicket(Long id, SupportTicket ut) {
		return ticketRepository.save(ut);
	}

	public SupportTicket deleteSupportTicket(Long id) {
		SupportTicket supportTicket=null;
		try {
		supportTicket=ticketRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(supportTicket !=null)
		{
			ticketRepository.deleteById(id);
		}
	return supportTicket;
	}

}
