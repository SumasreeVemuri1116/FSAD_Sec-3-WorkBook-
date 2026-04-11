package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.model.User;
import com.klu.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    // REGISTER
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }

    // LOGIN
    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return repo.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    // PROFILE
    @GetMapping("/profile/{username}")
    public User getProfile(@PathVariable String username) {
        return repo.findByUsername(username);
    }
}