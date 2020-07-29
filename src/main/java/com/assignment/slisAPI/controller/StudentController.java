package com.assignment.slisAPI.controller;

import java.util.List;

import com.assignment.slisAPI.exception.ResourceNotFoundException;
import com.assignment.slisAPI.model.Student;
import com.assignment.slisAPI.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService service;
    
    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return service.getAllStudent();
    }

    @GetMapping("/student/id/{id}")
    public Student getStudentById(@PathVariable int id) throws ResourceNotFoundException {
        return service.getStudentById(id);
    }

    @GetMapping("/student/name/{name}")
    public Student getStudentByName(@PathVariable String name) throws ResourceNotFoundException {
        return service.getStudentByName(name);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return service.saveStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student) throws ResourceNotFoundException {
        return service.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) throws ResourceNotFoundException {
        return service.deleteStudentById(id);
    }

}