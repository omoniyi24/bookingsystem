package com.uwl.project.bookingsystem.dto;

import com.uwl.project.bookingsystem.enums.PaymentMethod;
import com.uwl.project.bookingsystem.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class PaymentDTO {

    private Long id;
    private Long bookingID;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Instant paymentDate;

    private PaymentStatus status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookingID() {
        return bookingID;
    }

    public void setBookingID(Long bookingID) {
        this.bookingID = bookingID;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Instant getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Instant paymentDate) {
        this.paymentDate = paymentDate;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}