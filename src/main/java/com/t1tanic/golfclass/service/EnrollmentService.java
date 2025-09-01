package com.t1tanic.golfclass.service;

import com.t1tanic.golfclass.domain.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    Enrollment create(Enrollment enrollment);
    List<Enrollment> findAll();
    Optional<Enrollment> findById(Long id);
    Enrollment update(Enrollment enrollment);
    void deleteById(Long id);
}

