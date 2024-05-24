package com.uwl.project.bookingsystem.controller;


import com.uwl.project.bookingsystem.dto.BookingDTO;
import com.uwl.project.bookingsystem.dto.PaymentDTO;
import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.exception.UserException;
import com.uwl.project.bookingsystem.model.Booking;
import com.uwl.project.bookingsystem.model.Payment;
import com.uwl.project.bookingsystem.service.BookingService;
import com.uwl.project.bookingsystem.service.PaymentService;
import com.uwl.project.bookingsystem.util.AppUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/airline/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/initiate")
    public ResponseEntity<Payment> initiatePayment(@Valid @RequestBody PaymentDTO paymentDTO,
                                                   HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Payment payment = paymentService.initiatePayment(paymentDTO, userDTO);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PostMapping("/process")
    public ResponseEntity<Payment> processPayment(@Valid @RequestBody PaymentDTO paymentDTO,
                                                  HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Payment payment = paymentService.processPayment(paymentDTO, userDTO);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @PostMapping("/refund/{id}")
    public ResponseEntity<Payment> issueRefunds(@PathVariable(value = "id") final Long id,
                                                HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Payment payment = paymentService.issueRefunds(id, userDTO);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayment(HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        List<Payment> allPayment = paymentService.getAllPayment(userDTO);
        return new ResponseEntity<>(allPayment, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> retrievePaymentDetailById(@PathVariable(value = "id") final Long id,
                                                             HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Optional<Payment> payment = paymentService.retrievePaymentDetailById(id, userDTO);
        return payment.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
