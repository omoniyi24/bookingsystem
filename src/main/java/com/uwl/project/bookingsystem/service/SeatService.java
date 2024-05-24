package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.model.Seat;
import com.uwl.project.bookingsystem.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public Boolean checkSeatAvailability(Long id, UserDTO userDTO){
        return Boolean.TRUE;
    }

    public Boolean reserveSeat(Long id, UserDTO userDTO){
        return Boolean.TRUE;
    }

    public Boolean releaseSeat(Long id, UserDTO userDTO){
        return Boolean.TRUE;
    }
    public List<Seat> getAllSeat(UserDTO userDTO){
        return seatRepository.findAll();
    }
    public Optional<Seat> getAllSeatById(Long seatId, UserDTO userDTO){
        return seatRepository.findById(seatId);
    }
}

