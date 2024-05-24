package com.uwl.project.bookingsystem.controller;


import com.uwl.project.bookingsystem.dto.BookingDTO;
import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.exception.UserException;
import com.uwl.project.bookingsystem.model.Booking;
import com.uwl.project.bookingsystem.service.BookingService;
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
@RequestMapping("/airline/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingDTO> createBooking(@Valid @RequestBody BookingDTO bookingDTO,
                                                    HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        BookingDTO bookConfirmation = bookingService.createBooking(bookingDTO, userDTO);
        return new ResponseEntity<>(bookConfirmation, HttpStatus.OK);
    }

    @PostMapping("/cancel/{id}")
    public ResponseEntity<BookingDTO> cancelBooking(@PathVariable(value = "id") final Long id,
                                                    HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        BookingDTO bookConfirmation = bookingService.cancelBooking(id, userDTO);
        return new ResponseEntity<>(bookConfirmation, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBooking(HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        List<Booking> allBooking = bookingService.getAllBooking(userDTO);
        return new ResponseEntity<>(allBooking, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getAllBookingById(@PathVariable(value = "id") final Long id,
                                                     HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Optional<Booking> booking = bookingService.getAllBookingById(id, userDTO);
        return booking.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
