package com.uwl.project.bookingsystem.dto;

import com.uwl.project.bookingsystem.enums.SeatClassType;

import java.math.BigDecimal;

public class SeatDTO {

    private Long id;
    private Long flightID;
    private String seatNumber;
    private SeatClassType classType;
    private BigDecimal price;
    private boolean isAvailable;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFlightID() {
        return flightID;
    }

    public void setFlightID(Long flightID) {
        this.flightID = flightID;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatClassType getClassType() {
        return classType;
    }

    public void setClassType(SeatClassType classType) {
        this.classType = classType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}