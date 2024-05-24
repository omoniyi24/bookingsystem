package com.uwl.project.bookingsystem.controller;


import com.uwl.project.bookingsystem.dto.FlightDTO;
import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.exception.UserException;
import com.uwl.project.bookingsystem.model.Flight;
import com.uwl.project.bookingsystem.service.FlightService;
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
@RequestMapping("/airline/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @PostMapping("/create")
    public ResponseEntity<Flight> createFlight(@Valid @RequestBody FlightDTO flightDTO,
                                               HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Flight flight = flightService.createFlight(flightDTO, userDTO);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Flight>> flights(HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        List<Flight> flights = flightService.flights(userDTO);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> flightDetails(@PathVariable(value = "id") final Long id,
                                                HttpServletRequest request) throws UserException {
        UserDTO userDTO = AppUtil.getUserInfo(request);
        Optional<Flight> flightDetails = flightService.flightDetails(id, userDTO);
        return flightDetails.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
