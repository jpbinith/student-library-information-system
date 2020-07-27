package com.assignment.slisAPI.controller;

import com.assignment.slisAPI.model.Student;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private static final String TEMPLATE = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
    
    @GetMapping("/student")
    public Student getAllStudent(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Student(counter.incrementAndGet(), String.format(TEMPLATE, name));
    }

    @PostMapping("/student")
    public String createStudent(){
        return "post is working";
    }

    @PutMapping("/student/{id}")
    public String updateStudent(@PathVariable(value = "id")final Integer id){
        return "put is working " + id.toString();
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable(value = "id")final Integer id){
        return "delete is working " + id.toString();
    }

}