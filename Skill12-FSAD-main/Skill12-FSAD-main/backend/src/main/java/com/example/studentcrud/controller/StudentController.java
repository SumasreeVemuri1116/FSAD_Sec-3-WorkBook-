
package com.example.studentcrud.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.studentcrud.model.Student;
import com.example.studentcrud.service.StudentService;

@RestController
@CrossOrigin
public class StudentController{

 private final StudentService service;

 public StudentController(StudentService service){
  this.service=service;
 }

 @GetMapping("/students")
 public List<Student> getAll(){
  return service.getAll();
 }

 @PostMapping("/students")
 public ResponseEntity<Student> add(@RequestBody Student s){
  return ResponseEntity.ok(service.add(s));
 }

 @PutMapping("/students/{id}")
 public ResponseEntity<Student> update(@PathVariable Long id,@RequestBody Student s){
  return ResponseEntity.ok(service.update(id,s));
 }

 @DeleteMapping("/students/{id}")
 public ResponseEntity<?> delete(@PathVariable Long id){
  service.delete(id);
  return ResponseEntity.ok().build();
 }
}
