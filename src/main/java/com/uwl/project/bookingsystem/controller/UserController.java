package com.uwl.project.bookingsystem.controller;


import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.enums.Role;
import com.uwl.project.bookingsystem.model.User;
import com.uwl.project.bookingsystem.service.RegisteredUserService;
import com.uwl.project.bookingsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/airline/user")
public class UserController {

    @Autowired
    private RegisteredUserService registeredUserService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@Valid @RequestBody UserDTO userDTO) {
        User register = registeredUserService.register(userDTO, Role.PASSENGER);
        return new ResponseEntity<>(register, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody UserDTO userDTO) {
        User register = registeredUserService.login(userDTO);
        return new ResponseEntity<>(register, HttpStatus.OK);
    }
}
