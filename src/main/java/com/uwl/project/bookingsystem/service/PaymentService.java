package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.dto.PaymentDTO;
import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.model.Payment;
import com.uwl.project.bookingsystem.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment initiatePayment(PaymentDTO payment, UserDTO userDTO){
        return new Payment();
    }

    public Payment processPayment(PaymentDTO payment, UserDTO userDTO){
        return new Payment();
    }

    public Payment issueRefunds(Long paymentId, UserDTO userDTO){
        return new Payment();
    }

    public Optional<Payment> retrievePaymentDetailById(Long id, UserDTO userDTO){
        return paymentRepository.findById(id);
    }

    public List<Payment> getAllPayment(UserDTO userDTO) {
        return paymentRepository.findAll();
    }
}