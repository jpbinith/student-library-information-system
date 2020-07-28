package com.assignment.slisAPI.controller;

import java.util.List;

import com.assignment.slisAPI.model.Student;
import com.assignment.slisAPI.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService service;
    
    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return service.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable int id) {
        return service.getStudentById(id);
    }

    @GetMapping("/student/{name}")
    public Student getStudentByName(@PathVariable String name) {
        return service.getStudentByName(name);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }

    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable(value = "id")final Integer id){
        return "put is working " + id.toString();
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable(value = "id")final Integer id){
        return "delete is working " + id.toString();
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        return service.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        return service.deleteStudentById(id);
    }

}