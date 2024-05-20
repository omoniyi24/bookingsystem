package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.model.Flight;
import com.uwl.project.bookingsystem.model.Seat;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService extends UserService {

    public Flight createFlight(Flight flight){
        return new Flight();
    }

    public Flight modifyFlight(Flight flight){
        return new Flight();
    }

    public Flight deletelight(Flight flight){
        return new Flight();
    }

}
