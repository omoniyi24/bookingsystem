package com.uwl.project.bookingsystem.repository;

import com.uwl.project.bookingsystem.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
