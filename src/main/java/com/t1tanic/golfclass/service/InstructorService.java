package com.t1tanic.golfclass.service;

import com.t1tanic.golfclass.domain.Instructor;

import java.util.List;
import java.util.Optional;

public interface InstructorService {
    Instructor create(Instructor instructor);
    List<Instructor> findAll();
    Optional<Instructor> findById(Long id);
    Instructor update(Instructor instructor);
    void deleteById(Long id);
}

