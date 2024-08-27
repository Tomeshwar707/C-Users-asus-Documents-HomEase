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

import com.HomEase.entity.Payment;
import com.HomEase.service.PaymentService;



@RestController
@RequestMapping("payment/")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	/*
	 * @GetMapping("getAll/") public ResponseEntity<List<Payment>> getPayments() {
	 * List<Payment> lst=paymentService.getPayments(); if(lst.isEmpty()) { return
	 * ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 * 
	 * } return ResponseEntity.status(HttpStatus.OK).body(lst); }
	 */
	
	@GetMapping("get/{id}")
	public ResponseEntity< Payment> getPayment(@PathVariable ("id") Long id) {
		Payment payment= paymentService.getPayment(id);
		if(payment==null)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
			return ResponseEntity.status(HttpStatus.FOUND).body(payment);
	}
	
	
	@PostMapping("insert/")
	public ResponseEntity<Payment> insertPayment(@RequestBody Payment ut) {
				
		Payment payment = paymentService.insertPayment(ut);
		if(payment==null)
				return	ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			
		return	ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	/*
	 * @PutMapping("update/{id}") public ResponseEntity<com.HomEase.entity.Payment>
	 * updatePayment(@PathVariable Long id, @RequestBody Payment ut) {
	 * 
	 * 
	 * Payment payment= paymentService.updatePayment(id,ut); if(payment==null) {
	 * return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); } return
	 * ResponseEntity.status(HttpStatus.OK).body(payment); }
	 */
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
	Payment payment=paymentService.deletePayment(id);
		if(payment==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}
