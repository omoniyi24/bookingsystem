package com.uwl.project.bookingsystem.controller;


import com.uwl.project.bookingsystem.dto.SeatDTO;
import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.enums.Role;
import com.uwl.project.bookingsystem.exception.UserException;
import com.uwl.project.bookingsystem.model.Seat;
import com.uwl.project.bookingsystem.model.User;
import com.uwl.project.bookingsystem.service.RegisteredUserService;
import com.uwl.project.bookingsystem.service.SeatService;
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
@RequestMapping("/airline/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/check")
    public ResponseEntity<Boolean> checkSeatAvailability(@PathVariable(value = "id") final Long id,
                                                         HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Boolean response = seatService.checkSeatAvailability(id, userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/reserve")
    public ResponseEntity<Boolean> reserveSeat(@PathVariable(value = "id") final Long id,
                                               HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Boolean response = seatService.reserveSeat(id, userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/release")
    public ResponseEntity<Boolean> releaseSeat(@PathVariable(value = "id") final Long id,
                                               HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Boolean response = seatService.releaseSeat(id, userDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Seat>> getAllSeat(HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        List<Seat> allSeat = seatService.getAllSeat(userDTO);
        return new ResponseEntity<>(allSeat, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Seat> getAllSeatById(@PathVariable(value = "id") final Long id, HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Optional<Seat> allSeatById = seatService.getAllSeatById(id, userDTO);
        return allSeatById.map(seat -> new ResponseEntity<>(seat, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
