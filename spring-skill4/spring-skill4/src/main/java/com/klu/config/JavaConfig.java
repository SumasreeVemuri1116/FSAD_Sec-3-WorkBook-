package com.klu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.klu.model.Student;

@Configuration
public class JavaConfig {

    @Bean
    public Student javaStudent() {

        Student s = new Student(201, "Ravi", "AI", 2024);
        s.setCourse("ML");
        s.setYear(2025);

        return s;
    }
}
