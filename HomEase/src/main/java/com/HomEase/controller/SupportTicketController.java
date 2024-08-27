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

import com.HomEase.entity.SupportTicket;
import com.HomEase.service.SupportTicketService;



@RestController
@RequestMapping("supportTicket")
public class SupportTicketController {


	@Autowired
	SupportTicketService supportTicketService;
	
	/*
	 * @GetMapping("getAll/") public ResponseEntity<List<SupportTicket>>
	 * getSupportTickets() { List<SupportTicket>
	 * lst=supportTicketService.getSupportTickets(); if(lst.isEmpty()) { return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 * 
	 * } return ResponseEntity.status(HttpStatus.OK).body(lst); }
	 * 
	 * @GetMapping("get/{id}") public ResponseEntity< SupportTicket>
	 * getSupportTicket(@PathVariable ("id") Long id) { SupportTicket supportTicket=
	 * supportTicketService.getSupportTicket(id); if(supportTicket==null) { return
	 * ResponseEntity.status(HttpStatus.NOT_FOUND).build(); }
	 * 
	 * return ResponseEntity.status(HttpStatus.FOUND).body(supportTicket); }
	 * 
	 */	
	@PostMapping("insert/")
	public ResponseEntity<SupportTicket> insertSupportTicket(@RequestBody SupportTicket ut) {
				
		SupportTicket supportTicket = supportTicketService.insertSupportTicket(ut);
		if(supportTicket==null)
				return	ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		return	ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("update/{id}")
	public  ResponseEntity<SupportTicket> updateSupportTicket(@PathVariable Long id, @RequestBody SupportTicket ut) {
		
		
		SupportTicket supportTicket= supportTicketService.updateSupportTicket(id,ut);
		if(supportTicket==null)
		{
		return	ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return	ResponseEntity.status(HttpStatus.OK).body(supportTicket);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteSupportTicket(@PathVariable Long id) {
	SupportTicket supportTicket=supportTicketService.deleteSupportTicket(id);
		if(supportTicket==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
