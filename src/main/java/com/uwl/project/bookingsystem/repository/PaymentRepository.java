package com.uwl.project.bookingsystem.repository;

import com.uwl.project.bookingsystem.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
