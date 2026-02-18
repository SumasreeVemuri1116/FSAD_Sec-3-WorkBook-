package com.klu.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.klu.model.Student;

@Component
public class Skill5Runner implements CommandLineRunner {

    private final Student student;

    public Skill5Runner(Student student) {
        this.student = student;
    }

    @Override
    public void run(String... args) {

        System.out.println("=== SKILL-5 AUTOWIRING ===");
        student.display();
    }
}
