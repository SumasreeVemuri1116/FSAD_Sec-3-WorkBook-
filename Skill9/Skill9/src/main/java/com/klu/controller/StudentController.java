
package com.klu.controller;

import com.klu.exception.*;
import com.klu.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class StudentController {

    private static Map<Integer, Student> studentMap = new HashMap<>();

    static{
        studentMap.put(1,new Student(1,"Rahul","CSE"));
        studentMap.put(2,new Student(2,"Anjali","ECE"));
        studentMap.put(3,new Student(3,"Kiran","IT"));
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id){

        if(id <= 0){
            throw new InvalidInputException("Student ID must be positive");
        }

        Student student = studentMap.get(id);

        if(student == null){
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }

        return student;
    }
}
