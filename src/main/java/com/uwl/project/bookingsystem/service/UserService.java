package com.uwl.project.bookingsystem.service;

import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.enums.Role;
import com.uwl.project.bookingsystem.enums.UserStatus;
import com.uwl.project.bookingsystem.model.User;
import com.uwl.project.bookingsystem.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;

public abstract class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public User register(UserDTO userDTO, Role role){
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        user.setRole(role);
        user.setStatus(UserStatus.ACTIVE);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void login(UserDTO user){

    }

    public void updateProfile(UserDTO user){

    }

    public void logout(UserDTO user){

    }
}
