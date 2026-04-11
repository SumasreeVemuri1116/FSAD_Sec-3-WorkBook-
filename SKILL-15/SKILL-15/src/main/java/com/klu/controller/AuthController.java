package com.klu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.User;
import com.klu.repository.UserRepository;
import com.klu.security.JwtUtil;


@RestController
@RequestMapping("/api")
@CrossOrigin("*")



public class AuthController {

    @Autowired
    UserRepository repo;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User u = repo.findByUsername(user.getUsername());

        if (u != null && u.getPassword().equals(user.getPassword())) {
        	return jwtUtil.generateToken(u.getUsername(), u.getRole());
        }

        return "Invalid Credentials";
    }
} 