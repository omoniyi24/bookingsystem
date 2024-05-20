package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.model.Booking;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    public Booking makeBooking(Booking booking){
        return new Booking();
    }
    public Booking cancelBooking(Booking booking){
        return new Booking();
    }
    public Booking updateBooking(Booking booking){
        return new Booking();
    }
}