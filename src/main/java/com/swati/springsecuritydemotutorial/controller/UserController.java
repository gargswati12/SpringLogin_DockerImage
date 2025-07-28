package com.swati.springsecuritydemotutorial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swati.springsecuritydemotutorial.model.AllUsers;
import com.swati.springsecuritydemotutorial.repository.AllUsersRepository;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class UserController {

    @Autowired
    private AllUsersRepository repository;
    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public AllUsers createUser (@RequestBody AllUsers user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }
    
}
