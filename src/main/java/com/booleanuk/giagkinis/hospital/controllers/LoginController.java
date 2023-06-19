package com.booleanuk.giagkinis.hospital.controllers;

import com.booleanuk.giagkinis.hospital.models.User;
import com.booleanuk.giagkinis.hospital.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/login")
    public boolean loggingIn(@RequestBody User user) {
        User loginUser = userRepo.findByUsername(user.getUsername());
        return loginUser.getPassword().equals(user.getPassword());
    }

}
