package com.assignment.slisAPI.repository;

import com.assignment.slisAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByName(String name);
}