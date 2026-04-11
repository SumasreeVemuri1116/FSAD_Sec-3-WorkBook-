
package com.example.studentcrud.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.studentcrud.repository.StudentRepository;
import com.example.studentcrud.model.Student;

@Service
public class StudentService{

 private final StudentRepository repo;

 public StudentService(StudentRepository repo){
  this.repo=repo;
 }

 public List<Student> getAll(){
  return repo.findAll();
 }

 public Student add(Student s){
  return repo.save(s);
 }

 public void delete(Long id){
  repo.deleteById(id);
 }

 public Student update(Long id,Student s){
  s.setId(id);
  return repo.save(s);
 }
}
