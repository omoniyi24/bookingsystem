package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment processPayments(Payment payment){
        return new Payment();
    }

    public Payment issueRefunds(Payment payment){
        return new Payment();
    }

    public Payment retrievePaymentDetails(Payment payment){
        return new Payment();
    }
}