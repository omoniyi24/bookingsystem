package com.uwl.project.bookingsystem.util;

import com.uwl.project.bookingsystem.dto.UserDTO;
import com.uwl.project.bookingsystem.exception.UserException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @author OMONIYI ILESANMI
 */
@Slf4j
public class AppUtil {

    public static UserDTO getUserInfo(HttpServletRequest request) throws UserException {
        UserDTO userDTO = (UserDTO) request.getAttribute("userDTO");
        if (userDTO != null) {
            return userDTO;
        } else {
            throw new UserException("Profile not Found");
        }
    }

}
