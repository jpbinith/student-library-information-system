package com.assignment.slisAPI.service;

import java.util.List;

import com.assignment.slisAPI.exception.ResourceNotFoundException;
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

    public Student getStudentById(int id) throws ResourceNotFoundException {
        Student student = repository.findById(id).orElse(null);
        if (student != null) {
            return student;
        } else {
            throw new ResourceNotFoundException("Student not found with Id:" + id);
        }
    }
    
    public Student getStudentByName(String name) throws ResourceNotFoundException {
        Student student = repository.findByName(name);
        if (student != null) {
            return student;
        } else {
            throw new ResourceNotFoundException("Student not found with name :" + name);
        }
    }

    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    public String deleteStudentById(int id)  throws ResourceNotFoundException {
        if (repository.findById(id).orElse(null) != null) {
            repository.deleteById(id);
            return "student removed " + id;
        } else {
            throw new ResourceNotFoundException("Student not found with Id :" + id);
        }
    }

    public Student updateStudent(Student student) throws ResourceNotFoundException {
        Student exStudent = repository.findById(student.getId()).orElse(null);
        if (exStudent != null) {
            exStudent.setName(student.getName());
            return repository.save(exStudent);
        } else {
            throw new ResourceNotFoundException("Student not found with Id :" + student.getId());
        }
    }

}