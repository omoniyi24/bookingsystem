package com.uwl.project.bookingsystem.repository;

import com.uwl.project.bookingsystem.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
