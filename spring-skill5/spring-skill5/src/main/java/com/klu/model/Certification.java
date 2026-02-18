package com.klu.model;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 501;
    private String name = "Spring Boot";
    private String dateOfCompletion = "2025-02-01";

    @Override
    public String toString() {
        return "Certification [id=" + id +
                ", name=" + name +
                ", dateOfCompletion=" + dateOfCompletion + "]";
    }
}
