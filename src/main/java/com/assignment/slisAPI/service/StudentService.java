package com.assignment.slisAPI.service;

import java.util.List;

import com.assignment.slisAPI.model.Student;
import com.assignment.slisAPI.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository repository;

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student getStudentById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Student getStudentByName(String name) {
        return repository.findByName(name);
    }

    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    public String deleteStudentById(int id) {
        repository.deleteById(id);
        return "student removed " + id;
    }

    public Student updateStudent(Student student) {
        Student exStudent = repository.findById(student.getId()).orElse(null);
        exStudent.setName(student.getName());
        return repository.save(exStudent);
    }

}