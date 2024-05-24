package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.dto.FlightDTO;
import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.model.Flight;
import com.uwl.project.bookingsystem.repository.FlightRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public Flight searchFlight(FlightDTO flight, UserDTO userDTO){
        return new Flight();
    }

    public Optional<Flight> flightDetails(Long id, UserDTO userDTO){
        return flightRepository.findById(id);
    }

    public List<Flight> flights(UserDTO userDTO){
        return flightRepository.findAll();
    }

    public Flight createFlight(FlightDTO flightDTO, UserDTO userDTO) {
        Flight flight = new Flight();
        BeanUtils.copyProperties(flightDTO, flight);
        return flightRepository.save(flight);
    }
}
