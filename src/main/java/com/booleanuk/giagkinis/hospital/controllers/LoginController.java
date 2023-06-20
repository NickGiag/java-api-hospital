package com.booleanuk.giagkinis.hospital.controllers;

import com.booleanuk.giagkinis.hospital.dtos.UserDTO;
import com.booleanuk.giagkinis.hospital.exceptions.UserNotFoundException;
import com.booleanuk.giagkinis.hospital.models.User;
import com.booleanuk.giagkinis.hospital.repositories.CustomerRepo;
import com.booleanuk.giagkinis.hospital.repositories.DoctorRepo;
import com.booleanuk.giagkinis.hospital.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> loggingIn(@RequestBody User user) throws UserNotFoundException {
        User loginUser = userRepo.findByUsername(user.getUsername());
        if (loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
            if (loginUser.getUserType().equals("doctor")) {
                long id = doctorRepo.findByUserId(loginUser.getId()).getId();
                return ResponseEntity.ok(new UserDTO(id, loginUser.getUserType()));
            } else if (loginUser.getUserType().equals("customer")) {
                long id = customerRepo.findByUserId(loginUser.getId()).getId();
                return ResponseEntity.ok(new UserDTO(id, loginUser.getUserType()));
            }
        }
        throw new UserNotFoundException();
    }

}
