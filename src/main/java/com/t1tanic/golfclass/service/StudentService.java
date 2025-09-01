package com.t1tanic.golfclass.service;

import com.t1tanic.golfclass.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student create(Student student);
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Student update(Student student);
    void deleteById(Long id);
}

