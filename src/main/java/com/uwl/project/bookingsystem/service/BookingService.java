package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.dto.BookingDTO;
import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.model.Booking;
import com.uwl.project.bookingsystem.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingDTO createBooking(BookingDTO booking, UserDTO userDTO){
        return new BookingDTO();
    }
    public BookingDTO cancelBooking(Long id, UserDTO userDTO){
        return new BookingDTO();
    }
    public BookingDTO updateBooking(BookingDTO booking, UserDTO userDTO){
        return new BookingDTO();
    }

    public List<Booking> getAllBooking(UserDTO userDTO) {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getAllBookingById(Long id, UserDTO userDTO) {
        return bookingRepository.findById(id);
    }
}