
package com.klu.controller;

import com.klu.model.Course;
import com.klu.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course){
        service.addCourse(course);
        return new ResponseEntity<>("Course Added Successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses(){
        return new ResponseEntity<>(service.getAllCourses(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable int id){
        Course c = service.getCourseById(id);
        if(c==null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course){
        Course updated = service.updateCourse(id, course);
        if(updated==null)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>("Course Updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable int id){
        boolean deleted = service.deleteCourse(id);

        if(!deleted)
            return new ResponseEntity<>("Course Not Found", HttpStatus.NOT_FOUND);

        return new ResponseEntity<>("Course Deleted", HttpStatus.OK);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Course>> searchCourse(@PathVariable String title){
        return new ResponseEntity<>(service.searchByTitle(title), HttpStatus.OK);
    }
}
