package com.booleanuk.giagkinis.hospital.controllers;

import com.booleanuk.giagkinis.hospital.dtos.UserDTO;
import com.booleanuk.giagkinis.hospital.exceptions.UserNotFoundException;
import com.booleanuk.giagkinis.hospital.exceptions.WrongPasswordException;
import com.booleanuk.giagkinis.hospital.models.Customer;
import com.booleanuk.giagkinis.hospital.models.Doctor;
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
    public ResponseEntity<UserDTO> loggingIn(@RequestBody User user) throws UserNotFoundException,WrongPasswordException {
        User loginUser = userRepo.findByUsername(user.getUsername());
        if (loginUser != null) {
            if (loginUser.getPassword().equals(user.getPassword())) {
                if (loginUser.getUserType().equals("doctor")) {
                    Doctor doctor = doctorRepo.findByUserId(loginUser.getId());
                    return ResponseEntity.ok(new UserDTO(doctor.getId(), loginUser.getUserType(), doctor.getFullName()));
                } else if (loginUser.getUserType().equals("customer")) {
                    Customer customer = customerRepo.findByUserId(loginUser.getId());
                    return ResponseEntity.ok(new UserDTO(customer.getId(), loginUser.getUserType(), customer.getFullName()));
                }
            }
            throw new WrongPasswordException();
        }
        throw new UserNotFoundException();

    }

}
