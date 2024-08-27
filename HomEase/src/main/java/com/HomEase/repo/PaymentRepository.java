package com.HomEase.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.HomEase.entity.Payment;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

}
