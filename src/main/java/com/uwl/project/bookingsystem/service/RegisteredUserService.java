package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.model.Flight;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserService extends UserService {

    public Flight bookFlight(Flight flight){
        return new Flight();
    }

    public Flight cancelFlight(Flight flight){
        return new Flight();
    }

}
