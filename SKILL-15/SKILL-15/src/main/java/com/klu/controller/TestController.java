package com.klu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/admin/add")
    public String add() {
        return "Admin can add employee";
    }

    @GetMapping("/admin/delete")
    public String delete() {
        return "Admin can delete employee";
    }

    @GetMapping("/employee/profile")
    public String profile() {
        return "Employee profile data";
    }
}