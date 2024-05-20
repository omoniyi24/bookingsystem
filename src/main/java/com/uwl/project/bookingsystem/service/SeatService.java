package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.model.Seat;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    public Seat checkSeatAvailability(Seat seat){
        return new Seat();
    }

    public Seat reserveSeat(Seat seat){
        return new Seat();
    }

    public Seat releaseSeat(Seat seat){
        return new Seat();
    }
}

