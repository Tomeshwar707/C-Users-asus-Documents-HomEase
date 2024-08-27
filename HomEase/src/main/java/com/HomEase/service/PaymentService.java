package com.HomEase.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HomEase.entity.Payment;
import com.HomEase.repo.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository paymentRepository;
	
	public List<Payment> getPayments() {
		return (List<Payment>) paymentRepository.findAll();
	}

	public Payment getPayment(Long id) {
		Payment payment=null;
		try {
		payment=paymentRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return payment;
	}

	public Payment insertPayment(Payment ut) {
		Payment payment=null;
		try {
			payment=paymentRepository.save(ut);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return payment;
	}

	public Payment updatePayment(Long id, Payment ut) {
		Payment payment=null;
		if(ut.getPaymentId()==id) {
		Payment oldUser = paymentRepository.findById(id).get();
		LocalDateTime date = LocalDateTime.now();
		oldUser.setServices(ut.getServices());
		oldUser.setAmount(ut.getAmount());
		oldUser.setPaymentMethod(ut.getPaymentMethod());
		oldUser.setPaymentStatus(ut.getPaymentStatus());
		oldUser.setTransactionId(ut.getTransactionId());
		oldUser.setUpdateAt(date);
		
		return paymentRepository.save(oldUser);
		}
		return payment;
	}

	public Payment deletePayment(Long id) {
		Payment payment=null;
		try {
		payment=paymentRepository.findById(id).get();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		if(payment !=null)
		{
			paymentRepository.deleteById(id);
		}
	return payment;
	}
}
