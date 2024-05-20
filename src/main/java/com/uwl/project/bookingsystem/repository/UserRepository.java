package com.uwl.project.bookingsystem.repository;

import com.uwl.project.bookingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
